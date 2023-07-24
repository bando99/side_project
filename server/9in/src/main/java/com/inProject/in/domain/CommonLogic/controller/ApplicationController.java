package com.inProject.in.domain.CommonLogic.controller;

import com.inProject.in.domain.CommonLogic.Dto.ApplicationDto;
import com.inProject.in.domain.CommonLogic.Dto.ResponseApplicationDto;
import com.inProject.in.domain.CommonLogic.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @PostMapping()
    public ResponseEntity<ResponseApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto){
        ResponseApplicationDto responseApplicationDto = applicationService.applyToBoard(applicationDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseApplicationDto);
    }


    //지원한 거 취소하기.
}
