package com.inProject.in.domain.RoleNeeded.controller;

import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.ResponseRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.service.RoleNeededService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roleNeededs")
public class RoleNeededController {
    private RoleNeededService roleNeededService;

    @Autowired
    public RoleNeededController(RoleNeededService roleNeededService){
        this.roleNeededService = roleNeededService;
    }

    @PostMapping()
    public ResponseEntity<List<ResponseRoleNeededDto>> createRoleNeeded(@RequestBody RequestRoleNeededDto requestRoleNeededDto){
        List<ResponseRoleNeededDto> responseRoleNeededDto = roleNeededService.createRoleNeededs(requestRoleNeededDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseRoleNeededDto);
    }

//    @DeleteMapping()
//    public ResponseEntity<String> deleteRoleNeeded(@RequestParam Long role_id){
//
//    }
}
