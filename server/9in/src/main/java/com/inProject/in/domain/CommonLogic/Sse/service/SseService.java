//sseService
package com.inProject.in.domain.CommonLogic.Sse.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


public interface SseService {
    SseEmitter subscribe(String username);
    void notify(String userId, Object event);
    void sendToClient(String id, Object data);
    SseEmitter createEmitter(HttpServletRequest request);

}
