package com.inProject.in.domain.Board.service.impl;

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
import com.inProject.in.domain.User.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;
    private SkillTagRepository skilltagRepository;
    private RoleNeededRepository roleNeededRepository;
    private TagBoardRelationRepository tagBoardRelationRepository;
    private RoleBoardRelationRepository roleBoardRelationRepository;

    private final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository,
                            SkillTagRepository skilltagRepository,
                            RoleNeededRepository roleNeededRepository,
                            TagBoardRelationRepository tagBoardRelationRepository,
                            RoleBoardRelationRepository roleBoardRelationRepository){

        this.boardRepository = boardRepository;
        this.tagBoardRelationRepository = tagBoardRelationRepository;
        this.skilltagRepository = skilltagRepository;
        this.roleBoardRelationRepository = roleBoardRelationRepository;
        this.roleNeededRepository = roleNeededRepository;

    }

    public List<TagBoardRelation> InsertTagBoardRelation(Board board, List<SkillTagDto> skillTagDtoList){

        List<TagBoardRelation> tagBoardRelationList = new ArrayList<>();

        for(SkillTagDto skillTagDto : skillTagDtoList){   //받아온 태그 당 관계 데이터를 생성

            SkillTag skillTag = skilltagRepository.findTagByName(skillTagDto.toEntity().getName())
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 태그 정보 : " + skillTagDto.toEntity().getId()));    //태그 잘못 입력했으면 오류 반환

            TagBoardRelation tagBoardRelation = TagBoardRelation.builder()
                    .skillTag(skillTag)
                    .board(board)
                    .build();

            tagBoardRelationList.add(tagBoardRelationRepository.save(tagBoardRelation));
        }

        return tagBoardRelationList;
    }

    public List<RoleBoardRelation> InsertRolePostRelation(Board board, List<RoleNeededDto> roleNeededDtoList){

        List<RoleBoardRelation> roleBoardRelationList = new ArrayList<>();

        for(RoleNeededDto roleNeededDto : roleNeededDtoList){

            RoleNeeded roleNeeded = roleNeededRepository.findRoleByName(roleNeededDto.getName())
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 직군 정보" + roleNeededDto.toEntity().getId()));  //직군이 DB에 이미 정해진 대로 저장되어있다는 점.

            RoleBoardRelation roleBoardRelation = RoleBoardRelation.builder()
                    .pre_cnt(roleNeededDto.getPre_cnt())
                    .want_cnt(roleNeededDto.getWant_cnt())                    //roleNeeded엔티티에는 pre, want카운트가 없음. 하지만 dto에는 있음. 입력하기 편하도록.
                    .roleNeeded(roleNeeded)
                    .board(board)
                    .build();

            roleBoardRelationList.add(roleBoardRelationRepository.save(roleBoardRelation));
        }
        return roleBoardRelationList;
    }


    @Override
    public ResponseBoardDto getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("getpost에서 유효하지 않은 게시글 id " + id));

        ResponseBoardDto responseBoardDto = new ResponseBoardDto(board);

        return responseBoardDto;
    }

    @Override
    public ResponseBoardDto createBoard(BoardDto boardDto, List<SkillTagDto> skillTagDtoList, List<RoleNeededDto> roleNeededDtoList) {

        Board board = boardDto.toEntity();
        board.setCreateAt(LocalDateTime.now());
        board.setUpdateAt(LocalDateTime.now());

        Board createBoard = boardRepository.save(board);

        List<TagBoardRelation> tagBoardRelationList = InsertTagBoardRelation(createBoard, skillTagDtoList);
        List<RoleBoardRelation> roleBoardRelationList = InsertRolePostRelation(createBoard, roleNeededDtoList);  //DB에 연관 데이터인 태그, 직군 데이터 삽입

        createBoard.setTagBoardRelationList(tagBoardRelationList);
        createBoard.setRoleBoardRelationList(roleBoardRelationList);

        log.info("Using PostService createPost : " + createBoard.getId() + " " + createBoard.getTitle());

        for(TagBoardRelation tagBoardRelation : tagBoardRelationList){
            log.info("Insert Tag - Post relation ==> post id : " + tagBoardRelation.getBoard().getId() + " tag id : "
                    + tagBoardRelation.getSkillTag().getId());
        }

        for(RoleBoardRelation roleBoardRelation : roleBoardRelationList){
            log.info("Insert Role - Post relation ==> post id :" + roleBoardRelation.getBoard().getId()
                    + " role id : " + roleBoardRelation.getRoleNeeded().getId());
        }

        ResponseBoardDto responseBoardDto = new ResponseBoardDto(createBoard);

        return responseBoardDto;
    }

    @Override
    public ResponseBoardDto updateBoard(Long id, BoardDto boardDto) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("updatePost에서 유효하지 않은 게시글 id" + id));

        board.updatePost(boardDto);
        Board updatedBoard = boardRepository.save(board);
        ResponseBoardDto responseBoardDto = new ResponseBoardDto(updatedBoard);

        return responseBoardDto;
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }


    @Override
    public List<ResponseBoardDto> getBoardList(Pageable pageable, String user_id, String title, String type, List<String> tags) {

        Page<Board> postPage = boardRepository.findBoards(pageable, user_id, title, type, tags);
        List<Board> boardList = postPage.getContent();
        List<ResponseBoardDto> responseBoardDtoList = new ArrayList<>();

        for (Board board : boardList) {

            ResponseBoardDto responseBoardDto = new ResponseBoardDto(board);
            responseBoardDtoList.add(responseBoardDto);

        }

        return responseBoardDtoList;
    }
}
