package com.inProject.in.domain.CommonLogic.Sign.controller;

import com.inProject.in.domain.CommonLogic.Sign.Dto.RequestSignInDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.RequestSignUpDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.ResponseSignInDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.ResponseSignUpDto;
import com.inProject.in.domain.CommonLogic.Sign.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sign")
public class SignController {
    private final Logger log = LoggerFactory.getLogger(SignController.class);
    private SignService signService;

    @Autowired
    public SignController(SignService signService){
        this.signService = signService;
    }

    @PostMapping("/sign-in")
    public ResponseSignInDto signIn(@RequestBody RequestSignInDto requestSignInDto) throws RuntimeException{
        log.info("SignController signIn ==> 로그인 시도   id : " + requestSignInDto.getUsername());

        ResponseSignInDto responseSignInDto = signService.signIn(requestSignInDto);

        if(responseSignInDto.getCode() == 0){
            log.info("로그인 성공 ==> token : " + responseSignInDto.getToken());
        }

        return responseSignInDto;
    }

    @PostMapping("/sign-up")
    public ResponseSignUpDto signUp(@RequestBody RequestSignUpDto requestSignUpDto){
        log.info("SignController signUp ==> 회원가입 시도   id : " + requestSignUpDto.getUsername() + " mail : " + requestSignUpDto.getMail() +
                " role : " + requestSignUpDto.getRole());
        ResponseSignUpDto responseSignUpDto = signService.signUp(requestSignUpDto);

        log.info("회원가입 완료");
        return responseSignUpDto;
    }

    @GetMapping("/exception")
    public void exception() throws RuntimeException{
        throw new RuntimeException("접근이 금지되었습니다.");
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(RuntimeException e){
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        log.info("ExceptionHandler ==> " + e.getCause() + " " + e.getMessage());

        Map<String, String> m = new HashMap<>();

        m.put("error type", httpStatus.getReasonPhrase());
        m.put("code", "400");
        m.put("message", "에러 발생");

        return new ResponseEntity<>(m, responseHeaders, httpStatus);
    }
}
