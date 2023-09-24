package com.inProject.in.domain.SkillTag.controller;

import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import com.inProject.in.domain.SkillTag.Dto.ResponseSkillTagDto;
import com.inProject.in.domain.SkillTag.service.SkillTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skillTag")
public class SkillTagController {
    private SkillTagService skillTagService;

    @Autowired
    public SkillTagController(SkillTagService skillTagService){
        this.skillTagService = skillTagService;
    }

    @GetMapping()
    public ResponseEntity<List<ResponseSkillTagDto>> getSkillTagList(){
        List<ResponseSkillTagDto> responseSkillTagDtos = skillTagService.getSkillTagList();

        return ResponseEntity.status(HttpStatus.OK).body(responseSkillTagDtos);
    }
    @PostMapping()
    public ResponseEntity<ResponseSkillTagDto> createSkillTag(@RequestBody RequestSkillTagDto requestSkillTagDto){

        ResponseSkillTagDto responseSkillTagDto = skillTagService.createSkillTag(requestSkillTagDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseSkillTagDto);
    }
}
