package com.kh.ajax.csv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ajax.celeb.model.manager.CelebManager;
import com.kh.ajax.celeb.model.vo.Celeb;

/**
 * Servlet implementation class CelebListServlet
 */
@WebServlet("/csv/celebList.do")
public class CelebListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 업무로직
		List<Celeb> celebList = CelebManager.celebList;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < celebList.size(); i++) {
			Celeb celeb = celebList.get(i);
			sb.append(celeb.toString());  // toString() 안써도 자동으로 써짐
			if(i < celebList.size() - 1) {
				sb.append("\n");
			}
			System.out.println(sb);
			
		}
		// 2. 응답메세지에 바로 출력
		response.setContentType("text/csv; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append(sb);
		
	}

}
