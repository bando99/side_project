package com.inProject.in.domain.Board.service.impl;

import com.inProject.in.domain.Board.Dto.RequestParamDto;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.repository.RoleBoardRelationRepository;
import com.inProject.in.domain.MToNRelation.TagBoardRelation.entity.TagBoardRelation;
import com.inProject.in.domain.MToNRelation.TagBoardRelation.repository.TagBoardRelationRepository;
import com.inProject.in.domain.Board.Dto.BoardDto;
import com.inProject.in.domain.Board.Dto.ResponseBoardDto;
import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.Board.service.BoardService;
import com.inProject.in.domain.RoleNeeded.Dto.RoleNeededDto;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.RoleNeeded.repository.RoleNeededRepository;
import com.inProject.in.domain.SkillTag.Dto.SkillTagDto;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
import com.inProject.in.domain.SkillTag.repository.SkillTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)   //mockito 의 mock객체를 사용하기 위한 어노테이션.
class BoardServiceImplTest {
    @Mock
    BoardRepository boardRepository;
    @Mock
    TagBoardRelationRepository tagBoardRelationRepository;
    @Mock
    SkillTagRepository skillTagRepository;
    @Mock
    RoleNeededRepository roleNeededRepository;
    @Mock
    RoleBoardRelationRepository roleBoardRelationRepository;
    @InjectMocks                                       //생성한 mock 객체를 주입받음.
    BoardService boardService = new BoardServiceImpl(
            boardRepository,
            skillTagRepository,
            roleNeededRepository,
            tagBoardRelationRepository,
            roleBoardRelationRepository);

    @BeforeEach
    void dataSetting(){

    }

    @Test
    @DisplayName("게시글 하나 조회하는 로직")
    void getBoard() {

        //given
        Board board = Board.builder()
                .title("title1")
                .text("text1")
                .build();

        given(boardRepository.findById(1L)).willReturn(Optional.ofNullable(board));

        //when
        ResponseBoardDto responseBoardDto = boardService.getBoard(1L);

        //then
        assertEquals(board.getId(), responseBoardDto.getId());
    }

    @Test
    @DisplayName("게시글 하나 생성하는 로직")
    void createBoard() {

        //given
        Long testId = 1l;

        BoardDto boardDto = BoardDto.builder()
                .title("title1")
                .text("text1")
                .build();

        SkillTagDto skillTagDto = SkillTagDto.builder()
                .name("react")
                .build();

        RoleNeededDto roleNeededDto = RoleNeededDto.builder()
                .pre_cnt(0)
                .want_cnt(4)
                .name("백엔드")
                .build();

        Board board = boardDto.toEntity();
        SkillTag skillTag = skillTagDto.toEntity();
        RoleNeeded roleNeeded = roleNeededDto.toEntity();

        board.setId(testId);
        skillTag.setId(testId);
        roleNeeded.setId(testId);

        TagBoardRelation tagBoardRelation = TagBoardRelation.builder()
                .board(board)
                .skillTag(skillTag)
                .build();

        RoleBoardRelation roleBoardRelation = RoleBoardRelation.builder()
                .roleNeeded(roleNeeded)
                .board(board)
                .build();

        List<SkillTagDto> skillTagDtoList = new ArrayList<>();
        List<RoleNeededDto> roleNeededDtoList = new ArrayList<>();

        skillTagDtoList.add(skillTagDto);
        roleNeededDtoList.add(roleNeededDto);

        given(boardRepository.save(any(Board.class))).willReturn(board);
        given(skillTagRepository.findTagByName(any(String.class))).willReturn(Optional.of(skillTag));
        given(roleNeededRepository.findRoleByName(any(String.class))).willReturn(Optional.of(roleNeeded));
        given(tagBoardRelationRepository.save(any(TagBoardRelation.class))).willReturn(tagBoardRelation);
        given(roleBoardRelationRepository.save(any(RoleBoardRelation.class))).willReturn(roleBoardRelation);


        //when
        ResponseBoardDto responseBoardDto = boardService.createBoard(boardDto, skillTagDtoList, roleNeededDtoList);

        //then
        assertEquals(responseBoardDto.getId(), board.getId());

    }

    @Test
    @DisplayName("게시글 수정 로직")
    void updateBoard() {
        //given
        Long id = 1L;

        BoardDto boardDto = BoardDto.builder()
                .title("title1")
                .text("text1")
                .build();

        BoardDto boardDto2 = BoardDto.builder()
                .title("title2")
                .text("text2")
                .build();

        Board board = boardDto.toEntity();
        Board board2 = boardDto2.toEntity();

        board2.setId(id);

        given(boardRepository.findById(id)).willReturn(Optional.ofNullable(board)); //ofNullable을 통해
        given(boardRepository.save(eq(board))).willReturn(board2);

        //when
        ResponseBoardDto responseBoardDto = boardService.updateBoard(1L, boardDto2);


        //then

        assertEquals(responseBoardDto.getId(), board2.getId());
    }



    @Test
    @DisplayName("게시글 리스트 출력 로직")
    void getBoardList() {

        //given
        BoardDto boardDto1 = BoardDto.builder()
                .title("title1")
                .text("text1")
                .build();

        BoardDto boardDto2 = BoardDto.builder()
                .title("title2")
                .text("text2")
                .build();

        BoardDto boardDto3 = BoardDto.builder()
                .title("title3")
                .text("text3")
                .build();

        Board board1 = boardDto1.toEntity();
        Board board2 = boardDto2.toEntity();
        Board board3 = boardDto3.toEntity();

        Pageable pageable = PageRequest.of(0 , 3);
        String user_id = "";
        String title = "";
        String type = "";
        List<String> tags = new ArrayList<>();

        RequestParamDto requestParamDto = RequestParamDto.builder()
                .user_id(user_id)
                .title(title)
                .type(type)
                .tags(tags)
                .build();

        List<Board> boardList = List.of(board1, board2, board3);
        Page<Board> page = new PageImpl<>(boardList, pageable, boardList.size()); //이렇게 해도 가능!

        given(boardRepository.findBoards(pageable, user_id, title, type, tags)).willReturn(page);
        
        //when
        List<ResponseBoardDto> responseBoardDtoList = boardService.getBoardList(pageable, requestParamDto);

        //then
        int i = 1;
        assertEquals(3, responseBoardDtoList.size());

        for(ResponseBoardDto responseBoardDto : responseBoardDtoList){
            assertEquals(responseBoardDto.getTitle(), "title" + i);
            i++;
        }
    }
}