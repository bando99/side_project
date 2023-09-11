package com.inProject.in.domain.Board.service.impl;

import com.inProject.in.config.security.JwtTokenProvider;
import com.inProject.in.domain.Board.Dto.*;
import com.inProject.in.domain.Board.entity.Board;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.entity.RoleBoardRelation;
import com.inProject.in.domain.MToNRelation.RoleBoardRelation.repository.RoleBoardRelationRepository;
import com.inProject.in.domain.MToNRelation.TagBoardRelation.entity.TagBoardRelation;
import com.inProject.in.domain.MToNRelation.TagBoardRelation.repository.TagBoardRelationRepository;
import com.inProject.in.domain.Board.repository.BoardRepository;
import com.inProject.in.domain.Board.service.BoardService;
import com.inProject.in.domain.RoleNeeded.Dto.RequestRoleNeededDto;
import com.inProject.in.domain.RoleNeeded.Dto.RequestUsingInBoardDto;
import com.inProject.in.domain.RoleNeeded.entity.RoleNeeded;
import com.inProject.in.domain.RoleNeeded.repository.RoleNeededRepository;
import com.inProject.in.domain.SkillTag.Dto.RequestSkillTagDto;
import com.inProject.in.domain.SkillTag.entity.SkillTag;
import com.inProject.in.domain.SkillTag.repository.SkillTagRepository;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.engine.spi.SessionLazyDelegator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;

    private final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);


    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository,
                            SkillTagRepository skilltagRepository,
                            RoleNeededRepository roleNeededRepository,
                            TagBoardRelationRepository tagBoardRelationRepository,
                            RoleBoardRelationRepository roleBoardRelationRepository,
                            UserRepository userRepository,
                            JwtTokenProvider jwtTokenProvider){

        this.boardRepository = boardRepository;
        this.tagBoardRelationRepository = tagBoardRelationRepository;
        this.skilltagRepository = skilltagRepository;
        this.roleBoardRelationRepository = roleBoardRelationRepository;
        this.roleNeededRepository = roleNeededRepository;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public List<TagBoardRelation> InsertTagBoardRelation(Board board, List<RequestSkillTagDto> requestSkillTagDtoList){

        List<TagBoardRelation> tagBoardRelationList = new ArrayList<>();

        for(RequestSkillTagDto requestSkillTagDto : requestSkillTagDtoList){   //받아온 태그 당 관계 데이터를 생성

            SkillTag skillTag = skilltagRepository.findTagByName(requestSkillTagDto.toEntity().getName())
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 태그 정보 : " + requestSkillTagDto.toEntity().getId()));    //태그 잘못 입력했으면 오류 반환

            TagBoardRelation tagBoardRelation = TagBoardRelation.builder()
                    .skillTag(skillTag)
                    .board(board)
                    .build();

            tagBoardRelationList.add(tagBoardRelationRepository.save(tagBoardRelation));
        }

        return tagBoardRelationList;
    }

    public List<RoleBoardRelation> InsertRolePostRelation(Board board, List<RequestUsingInBoardDto> requestRoleNeededDtoList){

        List<RoleBoardRelation> roleBoardRelationList = new ArrayList<>();

        for(RequestUsingInBoardDto requestRoleNeededDto : requestRoleNeededDtoList){

            RoleNeeded roleNeeded = roleNeededRepository.findRoleByName(requestRoleNeededDto.getName())
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 직군 정보" + requestRoleNeededDto.getName()));  //직군이 DB에 이미 정해진 대로 저장되어있다는 점.

            RoleBoardRelation roleBoardRelation = RoleBoardRelation.builder()
                    .pre_cnt(requestRoleNeededDto.getPre_cnt())
                    .want_cnt(requestRoleNeededDto.getWant_cnt())                    //roleNeeded엔티티에는 pre, want카운트가 없음. 하지만 dto에는 있음. 입력하기 편하도록.
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
                .orElseThrow(() -> new IllegalArgumentException("getBoard에서 유효하지 않은 게시글 id " + id));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //현재 실행중인 스레드의 인증 정보를 보게 된다.

        ResponseBoardDto responseBoardDto = new ResponseBoardDto(board);

        return responseBoardDto;
    }

    @Override
    public ResponseBoardDto createBoard(//Long user_id, 없애도 될 것 같다.
                                        RequestCreateBoardDto requestCreateBoardDto,
                                        HttpServletRequest request) {

        User user = getUserFromRequest(request);
        Board board = requestCreateBoardDto.toBoardDto().toEntity();
        List<RequestSkillTagDto> requestSkillTagDtoList = requestCreateBoardDto.getTagDtoList();
        List<RequestUsingInBoardDto> requestRoleNeededDtoList = requestCreateBoardDto.getRoleNeededDtoList();

//        User user = userRepository.findById(user_id)
//                .orElseThrow(() -> new IllegalArgumentException("BoardService createBoard에서 유저를 찾지 못함 : " + user_id));

//        Board board = requestBoardDto.toEntity();
        board.setCreateAt(LocalDateTime.now());
        board.setUpdateAt(LocalDateTime.now());
        board.setAuthor(user);

        Board createBoard = boardRepository.save(board);

        List<TagBoardRelation> tagBoardRelationList = InsertTagBoardRelation(createBoard, requestSkillTagDtoList);
        List<RoleBoardRelation> roleBoardRelationList = InsertRolePostRelation(createBoard, requestRoleNeededDtoList);  //DB에 연관 데이터인 태그, 직군 데이터 삽입

        createBoard.setTagBoardRelationList(tagBoardRelationList);
        createBoard.setRoleBoardRelationList(roleBoardRelationList);

        log.info("BoardService createPost : " + createBoard.getId() + " " + createBoard.getTitle());

        for(TagBoardRelation tagBoardRelation : tagBoardRelationList){
            log.info("Insert Tag - Board relation ==> board id : " + tagBoardRelation.getBoard().getId() + " tag id : "
                    + tagBoardRelation.getSkillTag().getId());
        }

        for(RoleBoardRelation roleBoardRelation : roleBoardRelationList){
            log.info("Insert Role - Board relation ==> Board id :" + roleBoardRelation.getBoard().getId()
                    + " role id : " + roleBoardRelation.getRoleNeeded().getId());
        }

        ResponseBoardDto responseBoardDto = new ResponseBoardDto(createBoard );

        return responseBoardDto;
    }
    @Override
    //@PreAuthorize("#board.author.username == authentication.principal.username")                                              //메서드 매개변수로 전달된 board를 참조한다. 여기서 #board는 SpEL(Spring Expression Language)을 통해
    public ResponseBoardDto updateBoard(Long id, RequestUpdateBoardDto requestUpdateBoardDto, HttpServletRequest request) {   //해당 메서드의 매개변수로 전달되지 않아도 메서드 내의 board를 참조한다.

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("updateBoard에서 유효하지 않은 게시글 id" + id));

        User user = getUserFromRequest(request);

        if(board.getAuthor().getUsername() != user.getUsername()){
            throw new IllegalArgumentException("작성자만 게시글을 수정할 수 있습니다.");
        }

        board.updateBoard(requestUpdateBoardDto);
        Board updatedBoard = boardRepository.save(board);
        ResponseBoardDto responseBoardDto = new ResponseBoardDto(updatedBoard);
        log.info("Using BoardService updateBoard : " + responseBoardDto.getBoard_id() + responseBoardDto.getTitle());

        return responseBoardDto;
    }

    @Override
    @Transactional
   // @PreAuthorize("hasAuthority('ADMIN') or #board.author.username == authentication.principal.username")      //hasAuthority를 사용해야 함.여기서 hasRole은 단지 문자열 비교로
    public void deleteBoard(Long id, HttpServletRequest request) {                                                //권한을 확인하기에, 권한 계층을 고려하지 않음.

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("deleteBoard에서 유효하지 않은 게시글 id" + id));
        User user = getUserFromRequest(request);

        if(!user.getUsername().equals(board.getAuthor().getUsername()) && !request.isUserInRole("ROLE_ADMIN")){
            throw new AccessDeniedException("권한이 없습니다.");
        }

//        user.getAuthoredBoardList().remove(board);

        boardRepository.deleteById(id);

        log.info("BoardService deleteBoard ==> username : " + user.getUsername());
        log.info("authorization ADMIN : " + request.isUserInRole("ROLE_ADMIN"));
    }


    @Override
    public List<ResponseBoardListDto> getBoardList(Pageable pageable, RequestSearchBoardDto requestSearchBoardDto)  {  //Pageable pageable, String user_id, String title, String type, List<String> tags

        String username = requestSearchBoardDto.getUsername();
        String title = requestSearchBoardDto.getTitle();
        String type = requestSearchBoardDto.getType();
        List<String> tags = requestSearchBoardDto.getTags();

        Page<Board> boardPage = boardRepository.findBoards(pageable, username, title, type, tags);
        List<Board> boardList = boardPage.getContent();
        List<ResponseBoardListDto> responseBoardDtoList = new ArrayList<>();
        log.info("Using BoardService getBoardList ==> filtering by username : " + username + " title : " + title + " type : " + type );
        log.info("Tag filtering : " + tags.toString());

        for (Board board : boardList) {
            ResponseBoardListDto responseBoardDto = new ResponseBoardListDto(board);
            responseBoardDtoList.add(responseBoardDto);
        }

        return responseBoardDtoList;
    }

    private User getUserFromRequest(HttpServletRequest request){
        String token = jwtTokenProvider.resolveToken(request);
        User user;

        if(token != null && jwtTokenProvider.validateToken(token)){
            String username = jwtTokenProvider.getUsername(token);

            return user = userRepository.getByUsername(username)
                    .orElseThrow(() -> new IllegalArgumentException("BoardService에서 user를 찾지 못함"));
        }
        else{
            throw new IllegalArgumentException("token이 없거나, 권한이 유효하지 않습니다.");
        }


    }
}
