package com.inProject.in.Global.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{              //커스터마이징한 예외 클래스
    private ConstantsClass.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public CustomException(ConstantsClass.ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public ConstantsClass.ExceptionClass getExceptionClass(){
        return exceptionClass;
    }

    public int getHttpStatusCode(){
        return httpStatus.value();
    }

    public String getHttpStatusType(){
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }


}
