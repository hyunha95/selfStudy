package com.kh.ajax.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.celeb.model.manager.CelebManager;
import com.kh.ajax.celeb.model.vo.Celeb;

/**
 * Servlet implementation class JsonCelebListServlet
 */
@WebServlet("/json/celebList.do")
public class JsonCelebListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.업무로직 : celeb목록조회
		List<Celeb> celebList = CelebManager.celebList;
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(celebList);
		System.out.println("[JsonCelebListServlet] jsonStr = " + jsonStr);
		
		// 2.응답메세지에 직접 출력 : json형식 
		// null | {} | []
		// {}
		// 	- {}의 속성은 항상 쌍따옴표로 감싸야 하고, {}의 속성값 중 문자열은 쌍따옴표로 감싸야한다. 
		// 	- 숫자, boolean, {}, []이 올 수 있다.
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().append(jsonStr);
		
		
	}

}
