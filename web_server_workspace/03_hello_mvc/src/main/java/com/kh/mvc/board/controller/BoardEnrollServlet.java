package com.kh.mvc.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Attachment;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.common.MvcFileRenamePolicy;
import com.kh.mvc.common.MvcUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class BoardEnrollServlet
 */
@WebServlet("/board/boardEnroll")
public class BoardEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();

	/**
	 * DML -> redirect
	 * insert into board(title, writer, content) values(?, ?, ?)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// A. server computer에 사용자 업로드파일 저장
			String saveDirectory = getServletContext().getRealPath("/upload/board");
			System.out.println("[BoardEnrollServlet] saveDirectory = " + saveDirectory);
			
			int maxPostSize = 1024 * 1024 * 10; // 바이트단위 // 10MB // 업로드가능한 최대 용량. 넘어버리면 예외를 던져버림
			String encoding = "utf-8";
			
			// 파일명 재지정 정책 객체 : 
			// DefaultFileRenamePolicy 동일한 이름의 파일은 numbering을 통해 overwrite을 방지
//			FileRenamePolicy policy = new DefaultFileRenamePolicy();
			FileRenamePolicy policy = new MvcFileRenamePolicy();
			
			MultipartRequest multipartRequest = 
					new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
			
			// B. 업로드한 파일 정보를 db에 저장 : attachment테이블 파일하나당 1행 저장
			
			// 1. 사용자입력값 -> Board 객체
			// MultipartRequest객체 생성하는 경우, 기존 request가 아닌 MultipartRequest객체에서 가져와야 한다.
			String title = multipartRequest.getParameter("title");
			String writer = multipartRequest.getParameter("writer");
			String content = multipartRequest.getParameter("content");
			Board board = new Board(0, title, writer, content, 0, null);
			
			
			// 저장된 파일정보 -> Attachment객체 생성 -> List<Attachment>객체에 추가 -> Board객체에 추가
			File upFile1 = multipartRequest.getFile("upFile1");
			File upFile2 = multipartRequest.getFile("upFile2");
			if(upFile1 != null || upFile2 != null) {
				List<Attachment> attachments = new ArrayList<Attachment>();
				// 현재 fk인 boardNo필드값은 비어있다.
				if(upFile1 != null) {
					Attachment attach1 = MvcUtils.makeAttachment(multipartRequest, "upFile1");
					attachments.add(attach1);
				}
				if(upFile2 != null) {
					Attachment attach2 = MvcUtils.makeAttachment(multipartRequest, "upFile2");
					attachments.add(attach2);
				}
				board.setAttachments(attachments);
				System.out.println("[BoardEnrollServlet] attachments = " + attachments);
			}
			System.out.println("Board@BoardEnrollServlet = " + board);
			
			// 2. 업무로직
			int result = boardService.insertBoard(board);
			System.out.println("[BoardEnrollServlet] result = " + result);
			String msg = result > 0 ? "게시물 등록 성공!" : "게시물 등록 실패";
			
			// 3. redirect: DML은 redirect해서 url을 변경한다.
			// location: /mvc/board/boardList
			request.getSession().setAttribute("msg", msg);
			String location = request.getContextPath() + "/board/boardView?no=" + board.getNo();
			response.sendRedirect(location);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}