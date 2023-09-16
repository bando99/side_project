package com.inProject.in.domain.Profile.controller;

import com.inProject.in.domain.Profile.Dto.*;
import com.inProject.in.domain.Profile.service.CertificateServiceImpl;
import com.inProject.in.domain.Profile.service.EducationServiceImpl;
import com.inProject.in.domain.Profile.service.Job_exServiceImpl;
import com.inProject.in.domain.Profile.service.Project_skillServiceImpl;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private CertificateServiceImpl certificateService;
    private Job_exServiceImpl jobExService;
    private EducationServiceImpl educationService;
    private Project_skillServiceImpl projectSkillService;
    private UserRepository userRepository;

    @Autowired
    public ProfileController(
            CertificateServiceImpl certificateService,
            Job_exServiceImpl jobExService,
            EducationServiceImpl educationService,
            Project_skillServiceImpl projectSkillService,
            UserRepository userRepository){

        this.certificateService = certificateService;
        this.educationService = educationService;
        this.jobExService = jobExService;
        this.projectSkillService = projectSkillService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{username}")
    @Parameter(name = "username", description = "username 입력", in = ParameterIn.PATH)
    public ResponseEntity<ResponseProfileDto> getProfile(@PathVariable(name = "username") String username){

        User user = userRepository.getByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("ProfileController getProfile에서 잘못된 username : " + username));

        ResponseCertificateDto responseCertificateDto = new ResponseCertificateDto(user.getCertificate());
        ResponseJob_exDto responseJobExDto = new ResponseJob_exDto(user.getJobEx());
        ResponseEducationDto responseEducationDto = new ResponseEducationDto(user.getEducation());
        ResponseProject_skillDto responseProjectSkillDto = new ResponseProject_skillDto(user.getProjectSkill());

        ResponseProfileDto responseProfileDto = new ResponseProfileDto(responseCertificateDto, responseProjectSkillDto, responseJobExDto, responseEducationDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseProfileDto);
    }

    @PostMapping("/certificate")
    public ResponseEntity<ResponseCertificateDto> createCertificate(@RequestBody RequestCertificateDto requestCertificateDto){

        ResponseCertificateDto responseCertificateDto = certificateService.createCertificate(requestCertificateDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseCertificateDto);
    }

    @PostMapping("/job_ex")
    public ResponseEntity<ResponseJob_exDto> createJob_ex(@RequestBody RequestJob_exDto requestJobExDto){
        ResponseJob_exDto responseJobExDto = jobExService.createJob_ex(requestJobExDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseJobExDto);
    }

    @PostMapping("/project_skill")
    public ResponseEntity<ResponseProject_skillDto> createProject_skill(@RequestBody RequestProject_skillDto requestProjectSkillDto){
        ResponseProject_skillDto responseProjectSkillDto = projectSkillService.createProject_skill(requestProjectSkillDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseProjectSkillDto);
    }

    @PostMapping("/education")
    public ResponseEntity<ResponseEducationDto> createEducation(@RequestBody RequestEducationDto requestEducationDto){
        ResponseEducationDto responseEducationDto = educationService.createEducation(requestEducationDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseEducationDto);
    }
}
