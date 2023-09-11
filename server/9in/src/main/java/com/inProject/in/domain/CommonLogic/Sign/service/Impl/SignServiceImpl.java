package com.inProject.in.domain.CommonLogic.Sign.service.Impl;

import com.inProject.in.Global.CommonResponse;
import com.inProject.in.config.security.JwtTokenProvider;
import com.inProject.in.domain.CommonLogic.RefreshToken.entity.RefreshToken;
import com.inProject.in.domain.CommonLogic.RefreshToken.repository.RefreshTokenRepository;
import com.inProject.in.domain.CommonLogic.Sign.Dto.*;
import com.inProject.in.domain.CommonLogic.Sign.service.SignService;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SignServiceImpl implements SignService {

    private final Logger log = LoggerFactory.getLogger(SignServiceImpl.class);

    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private PasswordEncoder passwordEncoder;
    private RefreshTokenRepository refreshTokenRepository;
    @Autowired
    public SignServiceImpl(UserRepository userRepository,
                           JwtTokenProvider jwtTokenProvider,
                           PasswordEncoder passwordEncoder,
                           RefreshTokenRepository refreshTokenRepository){
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.refreshTokenRepository = refreshTokenRepository;
    }
    @Override
    public ResponseSignUpDto signUp(RequestSignUpDto requestSignUpDto) {
        log.info("SignService signup ==> 회원가입 정보 확인");
        User user;
        //String userId = requestSignUpDto.getUserId();
        String username = requestSignUpDto.getUsername();
        String password = requestSignUpDto.getPassword();
        String mail = requestSignUpDto.getMail();
        String role = requestSignUpDto.getRole();

        if(userRepository.getByUsername(username).isPresent()){   //아이디 중복 확인
            throw new RuntimeException("아이디 중복 발생");
        }

        if(role.equalsIgnoreCase("admin")){
            user = User.builder()
                    //.userId(userId)
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .mail(mail)
                    .roles(Collections.singletonList("ROLE_ADMIN"))
                    .build();
        }
        else{
            user = User.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .mail(mail)
                    .roles(Collections.singletonList("ROLE_USER"))
                    .build();
        }
        // 여기서 오류 뜨는데 Error: 1364-HY000: Field 'user_id' doesn't have a default value
        User savedUser = userRepository.save(user);
        ResponseSignUpDto responseSignUpDto = new ResponseSignInDto();

        log.info("SignService signup ==> user 저장");
        if(!savedUser.getUsername().isEmpty()){
           log.info("signup 정상 동작 완료");
           setSuccess(responseSignUpDto);
        }
        else{
            log.info("signup 실패");
            setFailed(responseSignUpDto);
        }

        return responseSignUpDto;
    }

    @Override
    public ResponseSignInDto signIn(RequestSignInDto requestSignInDto) {
        log.info("SignService signin ==> 회원 인증 확인 시작");
        String username = requestSignInDto.getUsername();
        String password = requestSignInDto.getPassword();

        User user = userRepository.getByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("SignIn ==> 유저 정보 찾지 못함"));

        log.info("회원 id : " + username);

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("비밀번호 불일치");
        }

        log.info("비밀번호 일치");

        String accessToken = jwtTokenProvider.createToken(String.valueOf(user.getUsername()), user.getRoles());
        String refreshToken = jwtTokenProvider.createRefreshToken(String.valueOf(user.getUsername()), user.getRoles());

       // Optional<RefreshToken> findRefreshToken = refreshTokenRepository.getByUsername(username);

//        if(!findRefreshToken.isPresent()){      //refresh토큰이 없다면 새로 생성해서 DB에 insert, 있다면 갱신.
//            RefreshToken newRefreshToken = RefreshToken.builder()
//                    .user(user)
//                    .refreshToken(refreshToken)
//                    .build();
//
//            RefreshToken savedRefreshToken = refreshTokenRepository.save(newRefreshToken);
//        }
//        else{
//            findRefreshToken.get().updateRefreshToken(refreshToken);
//
//            RefreshToken savedRefreshToken = refreshTokenRepository.save(findRefreshToken.get());
//        }

        refreshTokenRepository.getByUsername(username)         //위의 if문은 이렇게 간단하게도 만들 수 있다.
                .ifPresentOrElse(
                        token -> token.updateRefreshToken(refreshToken),
                        () -> refreshTokenRepository.save(new RefreshToken(user, refreshToken))
                        );

        ResponseSignInDto responseSignInDto = ResponseSignInDto.builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .build();


        log.info("ResponseSignInDto 생성");
        setSuccess(responseSignInDto);
        return responseSignInDto;
    }

    @Override
    public ResponseRefreshDto reissue(RequestRefreshDto requestRefreshDto) {

        log.info("reissue ==> refresh 토큰 통한 토큰 재발급 시작");
        String refreshToken = requestRefreshDto.getRefreshToken();


        if(!jwtTokenProvider.validateRefreshToken(refreshToken)){   //refresh 토큰이 유효기간이 지났는지 검증
            throw new RuntimeException("refresh 토큰이 유효하지 않음.");
        }
        log.info("reissue ==> refresh 토큰 검증 성공");


        Authentication authentication = jwtTokenProvider.getAuthentication(refreshToken);
        String username = authentication.getName();

        RefreshToken findRefreshToken = refreshTokenRepository.getByUsername(username)    //DB에 실제로 그 유저에게 발급된 refresh토큰이 있는지 확인
                .orElseThrow(() -> new RuntimeException("로그아웃된 사용자"));
        log.info("reissue ==> DB에 사용자 이름과 refresh 토큰 존재 확인");


        if(!findRefreshToken.getRefreshToken().equals(refreshToken)){
            throw new RuntimeException("토큰에 있는 정보와 일치하지 않음.");
        }
        log.info("reissue ==> DB refresh token과 일치 확인");



        String newAccessToken = jwtTokenProvider.createToken(     //새로운 토큰 발급.
                username,
                authentication.getAuthorities()
                        .stream()
                        .map(Objects::toString)
                        .collect(Collectors.toList())
        );

        log.info("reissue ==> 새 토큰 발급 : " + newAccessToken);

        String newRefreshToken = jwtTokenProvider.createRefreshToken(
                username,
                authentication.getAuthorities()
                        .stream()
                        .map(Objects::toString)
                        .collect(Collectors.toList())
        );

        findRefreshToken.updateRefreshToken(newRefreshToken);    //refresh 토큰도 업데이트.
        refreshTokenRepository.save(findRefreshToken);

        ResponseRefreshDto responseRefreshDto = new ResponseRefreshDto(newAccessToken, newRefreshToken);

        return responseRefreshDto;
    }


    private void setSuccess(ResponseSignUpDto responseSignUpDto){
        responseSignUpDto.setSuccess(true);
        responseSignUpDto.setCode(CommonResponse.SUCCESS.getCode());
        responseSignUpDto.setMsg(CommonResponse.SUCCESS.getMsg());
    }
    private void setFailed(ResponseSignUpDto responseSignUpDto){
        responseSignUpDto.setSuccess(false);
        responseSignUpDto.setCode(CommonResponse.FAIL.getCode());
        responseSignUpDto.setMsg(CommonResponse.FAIL.getMsg());
    }
}
