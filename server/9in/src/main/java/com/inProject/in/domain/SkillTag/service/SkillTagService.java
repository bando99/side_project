package com.inProject.in.domain.SkillTag.service;

import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import com.inProject.in.domain.SkillTag.Dto.ResponseSkillTagDto;

public interface SkillTagService {
    ResponseSkillTagDto getSkillTag(Long skillTag_id);
    ResponseSkillTagDto createSkillTag(RequestSkillTagDto requestSkillTagDto);
    ResponseSkillTagDto updateSkillTag(Long skillTag_id, RequestSkillTagDto requestSkillTagDto);
    void deleteSkillTag(Long skillTag_id);
}
