package com.inProject.in.domain.CommonLogic.Application.service;

import com.inProject.in.domain.CommonLogic.Application.Dto.RequestApplicationDto;
import com.inProject.in.domain.CommonLogic.Application.Dto.ResponseApplicationDto;

public interface ApplicationService {
    ResponseApplicationDto createApplication(RequestApplicationDto requestApplicationDto);
    ResponseApplicationDto deleteApplication(RequestApplicationDto requestApplicationDto);
}
