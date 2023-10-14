//sseService
package com.inProject.in.domain.CommonLogic.Sse.service;

import com.inProject.in.domain.CommonLogic.Application.Dto.RequestApplicationDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.xml.crypto.Data;


public interface SseService {
    SseEmitter subscribe(String username, RequestApplicationDto msg);
    void sendToClient(String id, RequestApplicationDto data);
    SseEmitter createEmitter(HttpServletRequest request);


}
