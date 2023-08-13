package com.inProject.in.domain.SkillTag.service.Impl;

import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import com.inProject.in.domain.SkillTag.Dto.ResponseSkillTagDto;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
import com.inProject.in.domain.SkillTag.repository.SkillTagRepository;
import com.inProject.in.domain.SkillTag.service.SkillTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillTagServiceImpl implements SkillTagService {

    private SkillTagRepository skillTagRepository;
    @Autowired
    public SkillTagServiceImpl(SkillTagRepository skillTagRepository){
        this.skillTagRepository = skillTagRepository;
    }

    @Override
    public ResponseSkillTagDto getSkillTag(Long skillTag_id) {

        SkillTag skillTag = skillTagRepository.findById(skillTag_id).get();

        ResponseSkillTagDto responseSkillTagDto = ResponseSkillTagDto.builder()
                .name(skillTag.getName())
                .build();

        return responseSkillTagDto;
    }

    @Override
    public ResponseSkillTagDto createSkillTag(RequestSkillTagDto requestSkillTagDto) {
        SkillTag skillTag = requestSkillTagDto.toEntity();
        SkillTag savedTag = skillTagRepository.save(skillTag);

        ResponseSkillTagDto responseSkillTagDto = new ResponseSkillTagDto(savedTag);

        return responseSkillTagDto;
    }

    @Override
    public ResponseSkillTagDto updateSkillTag(Long skillTag_id, RequestSkillTagDto requestSkillTagDto) {
        SkillTag skillTag = skillTagRepository.findById(skillTag_id).get();

        skillTag.updateSkillTag(requestSkillTagDto);
        SkillTag updateTag = skillTagRepository.save(skillTag);

        ResponseSkillTagDto responseSkillTagDto = new ResponseSkillTagDto(updateTag);

        return responseSkillTagDto;
    }

    @Override
    public void deleteSkillTag(Long skillTag_id) {
        skillTagRepository.deleteById(skillTag_id);
    }
}
