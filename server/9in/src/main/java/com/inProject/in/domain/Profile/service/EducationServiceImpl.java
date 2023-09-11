package com.inProject.in.domain.Profile.service;

import com.inProject.in.domain.Profile.Dto.RequestEducationDto;
import com.inProject.in.domain.Profile.Dto.ResponseEducationDto;
import com.inProject.in.domain.Profile.entity.Education;
import com.inProject.in.domain.Profile.repository.EducationRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl {
    private UserRepository userRepository;
    private EducationRepository educationRepository;


    @Autowired
    public EducationServiceImpl(UserRepository userRepository,
                                  EducationRepository educationRepository){
        this.userRepository = userRepository;
        this.educationRepository = educationRepository;
    }

    public ResponseEducationDto getEducation(Long user_id){
        Education education = educationRepository.findEducationByUserId(user_id)
                .orElseThrow(() -> new IllegalArgumentException("EducationService getEducation 에서 유효하지 않은 user id : " + user_id));

        ResponseEducationDto responseEducationDto = new ResponseEducationDto(education);
        return responseEducationDto;
    }

    public ResponseEducationDto createEducation(RequestEducationDto requestEducationDto){
        Long user_id = requestEducationDto.getUser_id();
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("EducationService getEducation 에서 유효하지 않은 user id : " + user_id));

        Education education = requestEducationDto.toEntity(user);

        Education savedEducation = educationRepository.save(education);

        ResponseEducationDto responseEducationDto = new ResponseEducationDto(savedEducation);

        return responseEducationDto;
    }

    public ResponseEducationDto updateEducation(RequestEducationDto requestEducationDto){
        Long user_id = requestEducationDto.getUser_id();

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("EducationService getEducation 에서 유효하지 않은 user id : " + user_id));

        Education education = requestEducationDto.toEntity(user);

        Education updatedEducation = educationRepository.save(education);

        ResponseEducationDto responseEducationDto = new ResponseEducationDto(updatedEducation);

        return responseEducationDto;
    }

    public void deleteEducation(Long user_id){
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new IllegalArgumentException("EducationService getEducation 에서 유효하지 않은 user id : " + user_id));

        educationRepository.deleteById(user.getEducation().getId());
    }
}
