package com.kh.mvc.chat.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.google.gson.Gson;
import com.kh.mvc.chat.ws.HelloWebSocket;

/**
 * Servlet implementation class ChatSendDmServlet
 */
@WebServlet("/chat/sendDm")
public class ChatSendDmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.사용자입력값
		String msg = request.getParameter("msg");
		Map<String, Object> map = new Gson().fromJson(msg, Map.class);
		System.out.println("[ChatSendDmServlet] map = " + map);

		// 2.업무로직 : clients에서 해당 reiciver 조회
		Map<String, Object> resultMap = new HashMap<>();
		String receiver = (String) map.get("receiver");
		Set<String> memberIdSet = HelloWebSocket.clients.keySet();

		if (memberIdSet.contains(receiver)) {
			Session sess = HelloWebSocket.clients.get(receiver);
			sess.getBasicRemote().sendText(msg); // json문자열로 전송
			resultMap.put("result", "성공적으로 DM을 전송했습니다.");
		} else {
			resultMap.put("result", "상대가 접속중이 아닙니다.");
		}

		// 3.응답작성
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(resultMap, response.getWriter());

	}
}