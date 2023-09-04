package com.inProject.in.domain.Profile.service;

import com.inProject.in.domain.Profile.Dto.RequestProject_skillDto;
import com.inProject.in.domain.Profile.Dto.ResponseProject_skillDto;
import com.inProject.in.domain.Profile.entity.Project_skill;
import com.inProject.in.domain.Profile.repository.Project_skillRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Project_skillServiceImpl {
    private UserRepository userRepository;
    private Project_skillRepository project_skillRepository;

    @Autowired
    public Project_skillServiceImpl(UserRepository userRepository,
                                  Project_skillRepository project_skillRepository){
        this.userRepository = userRepository;
        this.project_skillRepository = project_skillRepository;
    }

    public ResponseProject_skillDto getProject_skill(Long user_id){
        Project_skill project_skill = project_skillRepository.findProject_skillByUserId(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Project_skillService getProject_skill 에서 유효하지 않은 user id : " + user_id));

        ResponseProject_skillDto responseProject_skillDto = new ResponseProject_skillDto(project_skill);
        return responseProject_skillDto;
    }

    public ResponseProject_skillDto createProject_skill(RequestProject_skillDto requestProject_skillDto){
        Long user_id = requestProject_skillDto.getUser_id();
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Project_skillService getProject_skill 에서 유효하지 않은 user id : " + user_id));

        Project_skill project_skill = requestProject_skillDto.toEntity(user);

        Project_skill savedProject_skill = project_skillRepository.save(project_skill);

        ResponseProject_skillDto responseProject_skillDto = new ResponseProject_skillDto(savedProject_skill);

        return responseProject_skillDto;
    }

    public ResponseProject_skillDto updateProject_skill(RequestProject_skillDto requestProject_skillDto){
        Long user_id = requestProject_skillDto.getUser_id();

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Project_skillService getProject_skill 에서 유효하지 않은 user id : " + user_id));

        Project_skill project_skill = requestProject_skillDto.toEntity(user);

        Project_skill updatedProject_skill = project_skillRepository.save(project_skill);

        ResponseProject_skillDto responseProject_skillDto = new ResponseProject_skillDto(updatedProject_skill);

        return responseProject_skillDto;
    }

    public void deleteProject_skill(Long user_id){
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("Project_skillService getProject_skill 에서 유효하지 않은 user id : " + user_id));

        project_skillRepository.deleteById(user.getProjectSkill().getId());
    }
}
