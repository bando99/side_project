package com.inProject.in.domain.Profile.controller;

import com.inProject.in.domain.Profile.Dto.request.RequestJob_exDto;
import com.inProject.in.domain.Profile.Dto.response.ResponseJob_exDto;
import com.inProject.in.domain.Profile.service.Job_exServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job_ex")
public class JobController {

    private final Job_exServiceImpl jobExService;

    @Autowired
    public JobController(Job_exServiceImpl jobExService){
        this.jobExService = jobExService;
    }

    @PostMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    public ResponseEntity<ResponseJob_exDto> createJob_ex(@RequestBody RequestJob_exDto requestJobExDto, HttpServletRequest request){
        ResponseJob_exDto responseJobExDto = jobExService.createJob_ex(requestJobExDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseJobExDto);
    }

    @PutMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    public ResponseEntity<ResponseJob_exDto> updateJob_ex(@RequestBody RequestJob_exDto requestJobExDto, HttpServletRequest request){
        ResponseJob_exDto responseJobExDto = jobExService.updateJob_ex(requestJobExDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseJobExDto);
    }
}
