//sseServiceimple
package com.inProject.in.domain.CommonLogic.Sse.service.impl;

import com.inProject.in.config.security.CustomAccessDeniedHandler;
import com.inProject.in.config.security.JwtTokenProvider;
import com.inProject.in.domain.CommonLogic.Sse.repository.SseRepository;
import com.inProject.in.domain.CommonLogic.Sse.service.SseService;
import com.inProject.in.domain.User.entity.User;
import com.inProject.in.domain.User.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

//dd
@Service
public class SseServiceImpl implements SseService {
    // 기본 타임아웃 설정
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private  SseRepository sseRepository;
    private ApplicationEventPublisher applicationEventPublisher;
    private final Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
    @Autowired
    SseServiceImpl(SseRepository sseRepository , JwtTokenProvider jwtTokenProvider, UserRepository userRepository, ApplicationEventPublisher applicationEventPublisher){
        this.userRepository = userRepository;
        this.sseRepository = sseRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    /**
     * 클라이언트가 구독을 위해 호출하는 메서드.
     *
     * @param username - 구독하는 클라이언트의 사용자 아이디.
     * @return SseEmitter - 서버에서 보낸 이벤트 Emitter
     */
    //SseEmitter inputEmitter
    public SseEmitter subscribe(String username) {
        SseEmitter emitter =sseRepository.get(username);
        sendToClient(username, "게시글에 지원자가 발생했습니다 확인해보세요.");
        return emitter;
    }

    /**
     * 서버의 이벤트를 클라이언트에게 보내는 메서드
     * 다른 서비스 로직에서 이 메서드를 사용해 데이터를 Object event에 넣고 전송하면 된다.
     *
     * @param userId - 메세지를 전송할 사용자의 아이디.
     * @param event  - 전송할 이벤트 객체.
     */
    // 서버 -> 클라이언트
    public void notify(String userId, Object event) {
        sendToClient(userId, event);
    }

    /**
     * 클라이언트에게 데이터를 전송
     *
     * @param id   - 데이터를 받을 사용자의 아이디.
     * @param data - 전송할 데이터.
     */
    public void sendToClient(String id, Object data) {
        SseEmitter emitter = sseRepository.get(id);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event()
                        .id(String.valueOf(id))
                        .name("sse")
                        .data(data));
                log.info("data 전송 완료 : message => " + data);
            } catch (IOException exception) {
                sseRepository.deleteById(id);
                emitter.completeWithError(exception);
            }
        }
        else if(emitter == null){
            log.info("sseEmitter is null");
        }

    }


    public SseEmitter createEmitter(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        User user;

        if(token != null && jwtTokenProvider.validateToken(token)){
            String username = jwtTokenProvider.getUsername(token);
            user = userRepository.getByUsername(username)
                    .orElseThrow(() -> new IllegalArgumentException("sseCreate user를 찾지 못함"));
        }
        else{
            throw new IllegalArgumentException("token이 없거나, 권한이 유효하지 않습니다.");
        }

        String id =  user.getUsername();
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);

        sseRepository.save(id, emitter);

        // Emitter가 완료될 때(모든 데이터가 성공적으로 전송된 상태) Emitter를 삭제한다.
        emitter.onCompletion(() -> sseRepository.deleteById(id));
        // Emitter가 타임아웃 되었을 때(지정된 시간동안 어떠한 이벤트도 전송되지 않았을 때) Emitter를 삭제한다.
        emitter.onTimeout(() -> sseRepository.deleteById(id));
        return emitter;
    }
}