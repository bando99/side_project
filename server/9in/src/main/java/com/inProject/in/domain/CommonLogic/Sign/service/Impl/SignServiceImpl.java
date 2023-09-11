package com.inProject.in.domain.CommonLogic.Sign.service.Impl;

import com.inProject.in.Global.CommonResponse;
import com.inProject.in.config.security.JwtTokenProvider;
import com.inProject.in.domain.CommonLogic.Sign.Dto.RequestSignInDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.RequestSignUpDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.ResponseSignInDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.ResponseSignUpDto;
import com.inProject.in.domain.CommonLogic.Sign.service.SignService;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SignServiceImpl implements SignService {

    private final Logger log = LoggerFactory.getLogger(SignServiceImpl.class);

    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public SignServiceImpl(UserRepository userRepository,
                           JwtTokenProvider jwtTokenProvider,
                           PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
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
            throw new RuntimeException();
        }

        log.info("비밀번호 일치");

        ResponseSignInDto responseSignInDto = ResponseSignInDto.builder()
                .token(jwtTokenProvider.createToken(String.valueOf(user.getUsername()), user.getRoles()))
                .build();

        log.info("ResponseSignInDto 생성");
        setSuccess(responseSignInDto);
        return responseSignInDto;
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
