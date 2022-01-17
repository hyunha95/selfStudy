package com.kh.mvc.chat.controller;

import java.io.IOException;
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
 * Servlet implementation class ChatMemberListServlet
 */
@WebServlet("/chat/memberList")
public class ChatMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Session> clients = HelloWebSocket.clients;
		Set<String> memberIdSet = clients.keySet();
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(memberIdSet, response.getWriter());
		
	}

}
