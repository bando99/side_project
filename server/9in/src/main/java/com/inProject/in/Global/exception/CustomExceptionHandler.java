package com.inProject.in.Global.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice   //restcontroller에서 발생하는 예외를 처리하는 기능 수행
public class CustomExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Map<String, String>> handleException(RuntimeException e, HttpServletRequest request){
        HttpHeaders responseHeaders = new HttpHeaders();

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        log.error("Advice 내 handleException 호출, {}, {}", request.getRequestURI(), e.getMessage());

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}
