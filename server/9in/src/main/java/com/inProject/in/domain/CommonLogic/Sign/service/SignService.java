package com.inProject.in.domain.CommonLogic.Sign.service;

import com.inProject.in.domain.CommonLogic.Sign.Dto.RequestSignInDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.RequestSignUpDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.ResponseSignInDto;
import com.inProject.in.domain.CommonLogic.Sign.Dto.ResponseSignUpDto;

public interface SignService {
    ResponseSignUpDto signUp(RequestSignUpDto requestSignUpDto);
    ResponseSignInDto signIn(RequestSignInDto requestSignInDto);
}
