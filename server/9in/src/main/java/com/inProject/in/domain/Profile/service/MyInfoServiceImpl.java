package com.inProject.in.domain.Profile.service;

import com.inProject.in.Global.exception.ConstantsClass;
import com.inProject.in.Global.exception.CustomException;
import com.inProject.in.config.security.JwtTokenProvider;
import com.inProject.in.domain.Profile.Dto.request.RequestMyInfoDto;
import com.inProject.in.domain.Profile.Dto.response.ResponseMyInfoDto;
import com.inProject.in.domain.Profile.entity.MyInfo;
import com.inProject.in.domain.Profile.repository.MyInfoRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class MyInfoServiceImpl {

    private final MyInfoRepository myInfoRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final Logger log = LoggerFactory.getLogger(MyInfoServiceImpl.class);
    public MyInfoServiceImpl(MyInfoRepository myInfoRepository,
                             UserRepository userRepository,
                             JwtTokenProvider jwtTokenProvider){
        this.myInfoRepository = myInfoRepository;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    public ResponseMyInfoDto getMyInfo(Long user_id){
        MyInfo myInfo = myInfoRepository.findMyInfoByUserId(user_id)
                .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.BAD_REQUEST, user_id + "는 myinfo를 생성하지 않았음."));

        return new ResponseMyInfoDto(myInfo);
    }
    @Transactional
    public ResponseMyInfoDto createMyInfo(RequestMyInfoDto requestMyInfoDto, HttpServletRequest request){
        User user = getUserFromRequest(request);
        MyInfo myInfo = requestMyInfoDto.toEntity(user);

        MyInfo find = myInfoRepository.findMyInfoByUserId(user.getId()).get();

        if(find != null){
            throw new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.CONFLICT, "이미 내 정보 작성함");
        }


        MyInfo savedMyInfo = myInfoRepository.save(myInfo);

        return new ResponseMyInfoDto(savedMyInfo);
    }
    @Transactional
    public ResponseMyInfoDto updateMyInfo(RequestMyInfoDto requestMyInfoDto, HttpServletRequest request){
        User user = getUserFromRequest(request);

        MyInfo myInfo = myInfoRepository.findMyInfoByUserId(user.getId())
                .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.BAD_REQUEST, user.getId() + "는 myinfo를 생성하지 않았음"));

        if(!myInfo.getUser().getId().equals(user.getId())){
            throw new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.UNAUTHORIZED, user.getId() + "은 프로필 작성자가 아닙니다.");
        }

        myInfo.updateMyInfo(requestMyInfoDto);
        return new ResponseMyInfoDto(myInfo);

    }
    @Transactional
    public void deleteMyInfo(HttpServletRequest request){
        User user = getUserFromRequest(request);

        MyInfo myInfo = myInfoRepository.findMyInfoByUserId(user.getId())
                .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.BAD_REQUEST, user.getId() + "는 myinfo를 생성하지 않았음"));

        if(!myInfo.getUser().getId().equals(user.getId())){
            throw new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.UNAUTHORIZED, user.getId() + "은 프로필 작성자가 아닙니다.");
        }

        myInfoRepository.deleteById(myInfo.getId());

    }

    private User getUserFromRequest(HttpServletRequest request){
        String token = jwtTokenProvider.resolveToken(request);
        User user;

        if(token != null && jwtTokenProvider.validateToken(token)){
            String username = jwtTokenProvider.getUsername(token);

            return user = userRepository.getByUsername(username)
                    .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.BOARD, HttpStatus.BAD_REQUEST, "BoardService ==> request로부터 user를 찾지 못함"));
        }
        else{
            throw new CustomException(ConstantsClass.ExceptionClass.USER, HttpStatus.UNAUTHORIZED, "token이 없거나, 권한이 유효하지 않습니다.");
        }


    }
}
