package com.inProject.in.domain.Profile.controller;

import com.inProject.in.domain.Profile.Dto.request.RequestEducationDto;
import com.inProject.in.domain.Profile.Dto.response.ResponseEducationDto;
import com.inProject.in.domain.Profile.service.EducationServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/education")
public class EducationController {

    private final EducationServiceImpl educationService;

    @Autowired
    public EducationController(EducationServiceImpl educationService){
        this.educationService = educationService;
    }
    @PostMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    public ResponseEntity<ResponseEducationDto> createEducation(@RequestBody RequestEducationDto requestEducationDto, HttpServletRequest request){
        ResponseEducationDto responseEducationDto = educationService.createEducation(requestEducationDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseEducationDto);
    }

    @PutMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    public ResponseEntity<ResponseEducationDto> updateEducation(@RequestBody RequestEducationDto requestEducationDto, HttpServletRequest request){
        ResponseEducationDto responseEducationDto = educationService.updateEducation(requestEducationDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseEducationDto);
    }
}
