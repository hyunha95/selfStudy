package com.kh.mvc.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Attachment;
import com.kh.mvc.board.model.vo.Board;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
	/**
	 * select * from board where no = ?
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값 처리
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 2. 업무로직
		Board board = boardService.selectOneBoard(no);
		System.out.println("board@BoardViewServlet = " + board);
//		List<Attachment> list = boardService.selectAllAttachment(no);
//		board.setAttachments(list);
		
		
		// 3. view단 처리
		request.setAttribute("board", board);
		request
			.getRequestDispatcher("/WEB-INF/views/board/boardView.jsp")
			.forward(request, response);
	}

}
