package com.inProject.in.domain.Profile.controller;

import com.inProject.in.domain.Profile.Dto.request.RequestProject_skillDto;
import com.inProject.in.domain.Profile.Dto.response.ResponseProject_skillDto;
import com.inProject.in.domain.Profile.service.Project_skillServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project_skill")
public class ProjectController {

    private final Project_skillServiceImpl projectSkillService;

    @Autowired
    public ProjectController(Project_skillServiceImpl projectSkillService){
        this.projectSkillService = projectSkillService;
    }
    @PostMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    public ResponseEntity<ResponseProject_skillDto> createProject_skill(@RequestBody RequestProject_skillDto requestProjectSkillDto, HttpServletRequest request){
        ResponseProject_skillDto responseProjectSkillDto = projectSkillService.createProject_skill(requestProjectSkillDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseProjectSkillDto);
    }

    @PutMapping()
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    public ResponseEntity<ResponseProject_skillDto> updateProject_skill(@RequestBody RequestProject_skillDto requestProjectSkillDto, HttpServletRequest request){
        ResponseProject_skillDto responseProjectSkillDto = projectSkillService.updateProject_skill(requestProjectSkillDto, request);

        return ResponseEntity.status(HttpStatus.OK).body(responseProjectSkillDto);
    }
}
