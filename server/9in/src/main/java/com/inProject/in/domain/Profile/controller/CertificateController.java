package com.inProject.in.domain.Profile.controller;

import com.inProject.in.domain.Profile.Dto.request.RequestCertificateDto;
import com.inProject.in.domain.Profile.Dto.response.ResponseCertificateDto;
import com.inProject.in.domain.Profile.service.CertificateServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    private final CertificateServiceImpl certificateService;

    @Autowired
    public CertificateController(CertificateServiceImpl certificateService){
        this.certificateService = certificateService;
    }

    @PostMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    public ResponseEntity<ResponseCertificateDto> createCertificate(@RequestBody RequestCertificateDto requestCertificateDto, HttpServletRequest request){

        ResponseCertificateDto responseCertificateDto = certificateService.createCertificate(requestCertificateDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseCertificateDto);
    }

    @PutMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    public ResponseEntity<ResponseCertificateDto> updateCertificate(@RequestBody RequestCertificateDto requestCertificateDto, HttpServletRequest request){
        ResponseCertificateDto responseCertificateDto = certificateService.updateCertificate(requestCertificateDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseCertificateDto);
    }
}
