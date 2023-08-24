package com.inProject.in.domain.CommonLogic.Application.controller;

import com.inProject.in.domain.CommonLogic.Application.Dto.ResponseApplicationDto;
import com.inProject.in.domain.CommonLogic.Application.Dto.ApplicationDto;
import com.inProject.in.domain.CommonLogic.Application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @PostMapping()
    public ResponseEntity<ResponseApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto){
        ResponseApplicationDto responseApplicationDto = applicationService.createApplication(applicationDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseApplicationDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteApplication(ApplicationDto applicationDto){
        applicationService.deleteApplication(applicationDto);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }
    
}
