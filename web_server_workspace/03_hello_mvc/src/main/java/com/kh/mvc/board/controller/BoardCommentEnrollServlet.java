package com.kh.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.BoardComment;

/**
 * Servlet implementation class BoardCommentEnrollServlet
 */
@WebServlet("/board/boardCommentEnroll")
public class BoardCommentEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자입력값
		int boardNo = Integer.valueOf(request.getParameter("boardNo"));
		int commentLevel = Integer.valueOf(request.getParameter("commentLevel"));
		int commentRef = Integer.valueOf(request.getParameter("commentRef"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardComment bc = new BoardComment(0, commentLevel, writer, content, boardNo, commentRef, null);
		System.out.println("[BoardCommentEnrollServlet] bc = " + bc);
		
		// 2. 업무로직
		int result = boardService.insertBoardComment(bc);
		String msg = result > 0 ? "댓글 등록 성공!" : "댓글 등록 실패!";
		request.getSession().setAttribute("msg", msg);
		
		// 3. redirect: 게시글상세페이지 /board/boardView?no=
		String location = request.getContextPath() + "/board/boardView?no=" + boardNo;
		response.sendRedirect(location);
	}

}
