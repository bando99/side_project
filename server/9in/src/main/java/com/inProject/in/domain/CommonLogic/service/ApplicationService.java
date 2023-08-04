package com.inProject.in.domain.CommonLogic.service;

import com.inProject.in.domain.CommonLogic.Dto.ApplicationDto;
import com.inProject.in.domain.CommonLogic.Dto.ResponseApplicationDto;

public interface ApplicationService {
    ResponseApplicationDto createApplication(ApplicationDto applicationDto);
    void deleteApplication(ApplicationDto applicationDto);
}
