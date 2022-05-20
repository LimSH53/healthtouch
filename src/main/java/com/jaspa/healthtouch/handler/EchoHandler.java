package com.jaspa.healthtouch.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EchoHandler extends TextWebSocketHandler {
	
	private Map<String, WebSocketSession> userSessionMap = new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		userSessionMap.put(currentUserName(session), session);
		log.info("현재 접속 : {}", userSessionMap);
	}
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg = message.getPayload();
		
		if(msg != null) {
			String[] msgs = msg.split(",");
			if(msgs != null && msgs.length == 4) {
				log.info(msg);
				String title = msgs[0]; // 제목 
				String target = msgs[1]; // 수신자 
				String content = msgs[2]; // 내용 
				String reqUrl = msgs[3]; // 이동할 페이지 URL 
				log.info("title: " + title);
				log.info("content: " + content);
				log.info("target: " + target);
				log.info("reqUrl: " + reqUrl);
				WebSocketSession targetSession = userSessionMap.get(target);
				
				if(targetSession != null) {
					TextMessage tmpMsg = new TextMessage("<a href='"+ reqUrl +"'>[<b>" + title + "</b>]<br>" + content + "</a>");
					targetSession.sendMessage(tmpMsg);
				}
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("socket 종료");
		userSessionMap.remove(currentUserName(session), session);
	}
	
	private String currentUserName(WebSocketSession session) {
		String mid = session.getPrincipal().getName();
		return mid;
	}
	
}
