package com.inProject.in.domain.CommonLogic.Application.service;

import com.inProject.in.domain.CommonLogic.Application.Dto.ApplicationDto;
import com.inProject.in.domain.CommonLogic.Application.Dto.ResponseApplicationDto;

public interface ApplicationService {
    ResponseApplicationDto createApplication(ApplicationDto applicationDto);
    void deleteApplication(ApplicationDto applicationDto);
}
