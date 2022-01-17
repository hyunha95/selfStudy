package com.kh.mvc.chat.ws;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import com.kh.mvc.member.model.vo.Member;

public class HelloWebSocketConfig extends Configurator {

	/**
	 * HandshakeRequest request
	 * HandshakeResponse response
	 */
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		HttpSession httpSession = (HttpSession) request.getHttpSession();
		Member loginMember = (Member) httpSession.getAttribute("loginMember");
		
		Map<String, Object> userProp = sec.getUserProperties();
		userProp.put("memberId", loginMember.getMemberId());
		
		
	}
	
	
}
