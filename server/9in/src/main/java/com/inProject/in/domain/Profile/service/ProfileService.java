package com.inProject.in.domain.Profile.service;

import com.inProject.in.Global.exception.ConstantsClass;
import com.inProject.in.Global.exception.CustomException;
import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.Profile.Dto.response.*;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    @Autowired
    public ProfileService(UserRepository userRepository,
                          BoardRepository boardRepository){
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    public ResponseProfileDto getProfile(String username){

        User user = userRepository.getByUsername(username)
                .orElseThrow(() -> new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.NOT_FOUND, "ProfileController getProfile에서 잘못된 username : " + username));

        if(user.getCertificate() == null || user.getEducation() == null || user.getJobEx() == null || user.getProjectSkill() == null || user.getMyInfo() == null){
            throw new CustomException(ConstantsClass.ExceptionClass.PROFILE, HttpStatus.TEMPORARY_REDIRECT, username + "의 프로필작성이 완료되지 않았습니다.");         //307 코드.
        }

        ResponseCertificateDto responseCertificateDto = new ResponseCertificateDto(user.getCertificate());
        ResponseJob_exDto responseJobExDto = new ResponseJob_exDto(user.getJobEx());
        ResponseEducationDto responseEducationDto = new ResponseEducationDto(user.getEducation());
        ResponseProject_skillDto responseProjectSkillDto = new ResponseProject_skillDto(user.getProjectSkill());
        ResponseMyInfoDto responseMyInfoDto = new ResponseMyInfoDto(user.getMyInfo());

        Long clipedCount = boardRepository.CountsClipedBoards(user);
        Long projectCount = boardRepository.CountsUserBoards(user, "project");
        Long studyCount = boardRepository.CountsUserBoards(user, "study");

        ResponseProfileDto responseProfileDto = ResponseProfileDto.builder()
                .certificateDto(responseCertificateDto)
                .jobExDto(responseJobExDto)
                .educationDto(responseEducationDto)
                .projectSkillDto(responseProjectSkillDto)
                .myInfoDto(responseMyInfoDto)
                .clipedCounts(clipedCount)
                .projectCounts(projectCount)
                .studyCounts(studyCount)
                .build();

        return responseProfileDto;
    }


}
