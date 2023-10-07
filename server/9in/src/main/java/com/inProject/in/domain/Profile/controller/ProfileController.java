package com.inProject.in.domain.Profile.controller;

import com.inProject.in.Global.exception.ConstantsClass;
import com.inProject.in.Global.exception.CustomException;
import com.inProject.in.domain.Board.Dto.response.ResponseBoardListDto;
import com.inProject.in.domain.Board.service.BoardService;
import com.inProject.in.domain.Profile.Dto.request.*;
import com.inProject.in.domain.Profile.Dto.response.*;
import com.inProject.in.domain.Profile.service.*;
import com.inProject.in.domain.User.Dto.ResponseUserDto;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import com.inProject.in.domain.User.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@Tag(name = "profile", description = "프로필 전체 관련 api")
public class ProfileController {
    private final ProfileService profileService;
    private final BoardService boardService;
    private final UserRepository userRepository;

    @Autowired
    public ProfileController(ProfileService profileService,
                             BoardService boardService,
                             UserRepository userRepository){

        this.profileService = profileService;
        this.boardService = boardService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{username}")
    @Parameter(name = "username", description = "username 입력", in = ParameterIn.PATH)
    public ResponseEntity<ResponseProfileDto> getProfile(@PathVariable(name = "username") String username){

        ResponseProfileDto responseProfileDto = profileService.getProfile(username);

        return ResponseEntity.status(HttpStatus.OK).body(responseProfileDto);
    }

    @GetMapping("/myBoards/{username}")
    public ResponseEntity<List<ResponseBoardListDto>> getMyProjectBoards(@PageableDefault(size = 5) Pageable pageable,
                                                                         @RequestParam String type,
                                                                         @PathVariable(name = "username") String username
                                                                         ){
        List<ResponseBoardListDto> responseBoardListDtoList = boardService.getBoardListForUserInfo(pageable, username, type);

        return ResponseEntity.status(HttpStatus.OK).body(responseBoardListDtoList);
    }
}
