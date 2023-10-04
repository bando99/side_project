package com.inProject.in.domain.CommonLogic.Sign.service;

import com.inProject.in.domain.CommonLogic.Sign.Dto.request.*;
import com.inProject.in.domain.CommonLogic.Sign.Dto.response.*;
import jakarta.servlet.http.HttpServletRequest;

public interface SignService {
    ResponseSignUpDto signUp(RequestSignUpDto requestSignUpDto);
    ResponseSignInDto signIn(RequestSignInDto requestSignInDto);
    ResponseRefreshDto reissue(RequestRefreshDto requestRefreshDto, HttpServletRequest request);
}
