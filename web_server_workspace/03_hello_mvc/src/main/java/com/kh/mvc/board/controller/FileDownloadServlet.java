package com.kh.mvc.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Attachment;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/board/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.사용자입력값 처리
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 2.업무로직 
		// a.attachment정보 가져오기
		Attachment attach = boardService.selectOneAttachment(no);
		System.out.println("[FileDownloadServlet] attach = " + attach);
		
		// b.응답메세지에 파일출력 : ServletOutputStream 가져오기
		// 파일입력스트림
		String saveDirectory = getServletContext().getRealPath("/upload/board");
		File downFile = new File(saveDirectory, attach.getRenamedFilename());
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downFile));
		
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos= new BufferedOutputStream(sos);
		
		// 헤더정보 작성
		response.setContentType("application/octet-stream"); // 이진데이터를 가리키는 MIME타입
		// 기본인코딩 iso-8859-1 처리
		String originalFilename = new String(attach.getOriginalFilename().getBytes("utf-8"), "iso-8859-1");
		System.out.println("[FileDownloadServlet] originalFilename = " + originalFilename);
		response.setHeader("Content-Disposition", "attachment; filename=" + originalFilename);
		
		// 출력
		int data = -1;
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		
		// 자원반납(필수)
		bos.close();
		bis.close();
	}

}

























