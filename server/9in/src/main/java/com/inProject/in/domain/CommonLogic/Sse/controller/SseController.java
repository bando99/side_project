package com.inProject.in.domain.CommonLogic.Sse.controller;

import com.inProject.in.domain.Board.Dto.RequestUpdateBoardDto;
import com.inProject.in.domain.Board.Dto.ResponseBoardDto;
import com.inProject.in.domain.CommonLogic.Sse.service.SseService;
import com.inProject.in.domain.User.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController("/sse")
public class SseController {

    private SseService sseService;
    private SseController(SseService sseService){
        this.sseService = sseService;
    }


    //로그인성공시 반드시 sseConnect를 호출해야 합니다.
    @Parameter(name = "X-AUTH-TOKEN", description = "토큰을 전송합니다.", in = ParameterIn.HEADER)
    @GetMapping(value = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public void SseConnect(HttpServletRequest request){
        SseEmitter sse = sseService.createEmitter(request);
    }


    // id 에게 알림메세지를 보낸다. (test용 api 입니다. 원래는 api call로 작동하는 로직이 아닙니다.)
    @GetMapping(value = "/apply", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter subscribe(@PathVariable String id) {
        Long board_id_long = Long.parseLong(id);
        return sseService.subscribe(id);
    }


//        @PostMapping("/send-data/{id}")
//        public void sendData(@PathVariable String id) {
//            sseService.notify(id, "data");
//    }
}