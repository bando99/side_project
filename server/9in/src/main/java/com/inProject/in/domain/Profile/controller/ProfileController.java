package com.inProject.in.domain.Profile.controller;

import com.inProject.in.domain.Profile.Dto.*;
import com.inProject.in.domain.Profile.service.CertificateServiceImpl;
import com.inProject.in.domain.Profile.service.EducationServiceImpl;
import com.inProject.in.domain.Profile.service.Job_exServiceImpl;
import com.inProject.in.domain.Profile.service.Project_skillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private CertificateServiceImpl certificateService;
    private Job_exServiceImpl jobExService;
    private EducationServiceImpl educationService;
    private Project_skillServiceImpl projectSkillService;

    @Autowired
    public ProfileController(CertificateServiceImpl certificateService,
     Job_exServiceImpl jobExService,
     EducationServiceImpl educationService,
     Project_skillServiceImpl projectSkillService){

        this.certificateService = certificateService;
        this.educationService = educationService;
        this.jobExService = jobExService;
        this.projectSkillService = projectSkillService;
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<ResponseProfileDto> getProfile(@PathVariable Long user_id){
        return null;
    }

    @PostMapping("/certificate")
    public ResponseEntity<ResponseCertificateDto> createCertificate(){
        return null;
    }

    @PostMapping("/job_ex")
    public ResponseEntity<ResponseJob_exDto> createJob_ex(){
        return null;
    }

    @PostMapping("/project_skill")
    public ResponseEntity<ResponseProject_skillDto> createProject_skill(){
        return null;
    }

    @PostMapping("/education")
    public ResponseEntity<ResponseEducationDto> createEducation(){
        return null;
    }

}
