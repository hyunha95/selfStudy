package com.kh.mvc.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.person.model.vo.Person;

/**
 * Servlet implementation class JstlCoreForEachServlet
 */
@WebServlet("/jstl/coreForEach.do")
public class JstlCoreForEachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> names = Arrays.asList("홍길동", "신사임당", "세종대왕", "윤봉준");
		Set<Integer> numbers = new HashSet<>(Arrays.asList(213,45,56,879));
		List<Person> persons = new ArrayList<>() {
			{
				// 초기화블럭
				this.add(new Person("고주몽", 'M', 34, true));
				this.add(new Person("고길동", 'M', 67, false));
				this.add(new Person("고아라", 'F', 23, false));
			}
		};
		Map<String, Object> map = new HashMap<>() {
			{
				this.put("item", "키보드");
				this.put("movie", "주토피아");
				this.put("book", "나미야 잡화점");
				this.put("now", System.currentTimeMillis());
			}
		};
		
		request.setAttribute("names", names);
		request.setAttribute("numbers", numbers);
		request.setAttribute("persons", persons);
		request.setAttribute("map", map);
		
		request
			.getRequestDispatcher("/jstl/coreForEach.jsp")
			.forward(request, response);
	}

}
