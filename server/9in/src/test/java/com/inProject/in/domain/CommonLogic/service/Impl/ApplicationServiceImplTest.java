package com.inProject.in.domain.CommonLogic.service.Impl;

import com.inProject.in.domain.Board.Dto.BoardDto;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.CommonLogic.Dto.ApplicationDto;
import com.inProject.in.domain.CommonLogic.Dto.ResponseApplicationDto;
import com.inProject.in.domain.CommonLogic.service.ApplicationService;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.entity.ApplicantBoardRelation;
import com.inProject.in.domain.MToNRelation.ApplicantBoardRelation.repository.ApplicantBoardRelationRepository;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.entity.ApplicantRoleRelation;
import com.inProject.in.domain.MToNRelation.ApplicantRoleRelation.repository.ApplicantRoleRelationRepository;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.repository.RoleBoardRelationRepository;
import com.inProject.in.domain.RoleNeeded.Dto.RoleNeededDto;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.RoleNeeded.repository.RoleNeededRepository;
import com.inProject.in.domain.User.Dto.UserDto;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BoardRepository boardRepository;
    @Mock
    private RoleNeededRepository roleNeededRepository;
    @Mock
    private ApplicantBoardRelationRepository applicantBoardRelationRepository;
    @Mock
    private ApplicantRoleRelationRepository applicantRoleRelationRepository;
    @Mock
    private RoleBoardRelationRepository roleBoardRelationRepository;

    @InjectMocks
    ApplicationService applicationService = new ApplicationServiceImpl(userRepository,
            boardRepository,
            roleNeededRepository,
            applicantBoardRelationRepository,
            applicantRoleRelationRepository,
            roleBoardRelationRepository);

    @Test
    @DisplayName("게시글의 직군에 지원하기")
    void applyToBoard() {

        //given
        Long id = 1L;
        int pre_cnt = 0;
        int want_cnt = 4;

        User author = User.builder()
                .username("author")
                .build();

        UserDto userDto = UserDto.builder()
                .username("applicant")
                .build();

        BoardDto boardDto = BoardDto.builder()
                .text("text1")
                .title("title1")
                .author(author)
                .build();

        RoleNeededDto roleNeededDto = RoleNeededDto.builder()
                .name("backend")
                .build();


        User applicant = userDto.toEntity();
        Board board = boardDto.toEntity();
        RoleNeeded roleNeeded = roleNeededDto.toEntity();

        RoleBoardRelation roleBoardRelation = RoleBoardRelation.builder()
                .roleNeeded(roleNeeded)
                .board(board)
                .pre_cnt(pre_cnt)
                .want_cnt(want_cnt)
                .build();

        RoleBoardRelation updatedRoleBoardRelation = RoleBoardRelation.builder()
                .roleNeeded(roleNeeded)
                .board(board)
                .pre_cnt(pre_cnt + 1)
                .want_cnt(want_cnt)
                .build();

        ApplicantRoleRelation applicantRoleRelation = ApplicantRoleRelation.builder()
                .role_applicant(applicant)
                .roleNeeded(roleNeeded)
                .build();

        ApplicantBoardRelation applicantBoardRelation = ApplicantBoardRelation.builder()
                .board_applicant(applicant)
                .board(board)
                .build();

        ApplicationDto applicationDto = ApplicationDto.builder()
                .board_id(id)
                .user_id(id)
                .role_id(id)
                .build();

        given(userRepository.findById(id)).willReturn(Optional.ofNullable(applicant));
        given(boardRepository.findById(id)).willReturn(Optional.ofNullable(board));
        given(roleNeededRepository.findById(id)).willReturn(Optional.ofNullable(roleNeeded));
        given(roleBoardRelationRepository.findRelationById(id, id)).willReturn(Optional.ofNullable(roleBoardRelation));
        given(roleBoardRelationRepository.save(any(RoleBoardRelation.class))).willReturn(updatedRoleBoardRelation);
        given(applicantBoardRelationRepository.save(any(ApplicantBoardRelation.class))).willReturn(applicantBoardRelation);
        given(applicantRoleRelationRepository.save(any(ApplicantRoleRelation.class))).willReturn(applicantRoleRelation);

        //when
        ResponseApplicationDto responseApplicationDto =  applicationService.createApplication(applicationDto);


        //then
        assertEquals(id , responseApplicationDto.getApplicant_id());
        assertEquals(id, responseApplicationDto.getBoard_id());
        assertEquals(id, responseApplicationDto.getRole_id());
    }
}