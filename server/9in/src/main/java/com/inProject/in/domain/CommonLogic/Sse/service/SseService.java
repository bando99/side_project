//sseService
package com.inProject.in.domain.CommonLogic.Sse.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.xml.crypto.Data;


public interface SseService {
    SseEmitter subscribe(String username, String msg);
    void sendToClient(String id, Object data);
    SseEmitter createEmitter(HttpServletRequest request);


}
