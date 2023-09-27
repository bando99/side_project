package com.inProject.in.domain.CommonLogic.Find.controller;

import com.inProject.in.domain.CommonLogic.Change.Dto.response.ResponseChangeDto;
import com.inProject.in.domain.CommonLogic.Find.Dto.request.RequestCheckIdDto;
import com.inProject.in.domain.CommonLogic.Find.Dto.response.ResponseCheckIdDto;
import com.inProject.in.domain.CommonLogic.Find.service.FindService;
import com.inProject.in.domain.CommonLogic.Find.Dto.request.RequestFindDto;
import com.inProject.in.domain.CommonLogic.Find.Dto.response.ResponseFindIdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
public class FindController {
    private final Logger log = LoggerFactory.getLogger(FindController.class);
    private FindService findService;

    @Autowired
    public FindController(FindService findService){
        this.findService = findService;
    }

    @PostMapping("/findId")
    @Operation(summary = "아이디 찾기", description = "메일을 통해 아이디를 찾습니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "아이디 찾기 성공", content = {
                            @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ResponseFindIdDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "아이디 찾기 실패")
            })
    public ResponseEntity<ResponseFindIdDto> findId(@RequestBody RequestFindDto requestFindDto){
        log.info("SignController findId ==> 아이디 찾기 시작");
        ResponseFindIdDto responseFindIdDto = findService.findId(requestFindDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseFindIdDto);
    }

    @PostMapping("/checkId")
    public ResponseEntity<ResponseCheckIdDto> checkId(@RequestBody RequestCheckIdDto requestCheckIdDto){
        ResponseCheckIdDto responseCheckIdDto = findService.checkId(requestCheckIdDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseCheckIdDto);
    }

    @PostMapping("/findPw")
    @Operation(summary = "비밀번호 찾기", description = "임시 비밀번호를 받습니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "비밀번호 찾기 성공", content = {
                            @Content(mediaType = "application/json", schema =
                            @Schema(implementation = ResponseChangeDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "비밀번호 찾기실패")
            })
    public ResponseEntity<String> findPw(@RequestBody RequestFindDto requestFindDto){
        log.info("SignController findPw ==> 비밀번호 찾기 시작");
        findService.findPw(requestFindDto);
        String message = "임시 비밀번호 생성 성공";

        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
