package com.inProject.in.domain.CommonLogic.Application.controller;

import com.inProject.in.Global.exception.CustomException;
import com.inProject.in.domain.CommonLogic.Application.Dto.ResponseApplicationDto;
import com.inProject.in.domain.CommonLogic.Application.Dto.ApplicationDto;
import com.inProject.in.domain.CommonLogic.Application.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
@Tag(name = "application", description = "게시글에 지원하는 api")
public class ApplicationController {
    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @PostMapping()
    @Operation(summary = "지원하기", description = "게시글에 지원 버튼을 누르면 실행되는 api입니다.")
    public ResponseEntity<ResponseApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto){
        try{
            ResponseApplicationDto responseApplicationDto = applicationService.createApplication(applicationDto);

            return ResponseEntity.status(HttpStatus.OK).body(responseApplicationDto);
        }catch (CustomException e){
            throw e;
        }

    }

    @DeleteMapping()
    @Operation(summary = "지원 취소", description = "게시글에 지원한 걸 취소합니다.")
    public ResponseEntity<String> deleteApplication(ApplicationDto applicationDto){
        try{
            applicationService.deleteApplication(applicationDto);

            return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
        }catch (CustomException e){
            throw e;
        }
    }
}
