package com.kh.ajax.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutocompleteServlet
 */
@WebServlet("/csv/autocomplete.do")
public class AutocompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> classmates = 
			Arrays.asList("고정현","김미래","김미림","김유정","김재경","김형진","김혜원","노현하","백시윤","서원영","서진교","신중규","양소영","유법용","이송이","이혜미","장희연","전예성","전혜린","정한별","조정우","한태우");
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.사용자입력값 확인
		String term = request.getParameter("term");
		System.out.println("[AutocompleteServlet] term = " + term);
		
		// 2.이름목록에서 일치하는 이름으로 csv만들기
		List<String> resultList = new ArrayList<>();
		for(String name : classmates) {
			if(name.contains(term)) 
				resultList.add(name);
			
		}
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < resultList.size(); i++) {
			sb.append(resultList.get(i));
			if(i < resultList.size() - 1)
				sb.append(",");
		}
		
		// 3.응답메시지 출력
		response.setContentType("text/csv; charset=utf-8");
		response.getWriter().append(sb);
		
		
	}

}
