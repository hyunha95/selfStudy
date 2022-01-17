package com.kh.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.emp.model.dao.EmpDaoImpl;
import com.kh.emp.model.service.EmpService;
import com.kh.emp.model.service.EmpServiceImpl;
import com.kh.student.model.dao.IStudentDao;
import com.kh.student.model.dao.StudentDao;
import com.kh.student.model.service.IStudentService;
import com.kh.student.model.service.StudentService;

/**
 * servlet의 생명주기 : tomcat
 * 생성자호출 - init - service(doGet/doPost) - destroy
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, AbstractController> urlCommandMap = new HashMap<>(); 
       
    /**
     * url-controller를 연결하는 설정
     * - /student/selectList.do ---> com.kh.student.controller.StudentListController
     * - /student/studentEnroll.do ---> com.kh.student.controller.StudentEnrollController 
     */
    public DispatcherServlet() throws Exception {
    	// 0. 의존객체 준비
    	IStudentDao studentDao = new StudentDao();
    	IStudentService studentService = new StudentService(studentDao); // 의존 주입
    	
    	EmpService empService = new EmpServiceImpl(new EmpDaoImpl()); // 의존 주입
    	
        // 1. url-command.properties -> Properties객체
    	Properties prop = new Properties();
    	String filepath = DispatcherServlet.class.getResource("/url-command.properties").getPath();
    	prop.load(new FileReader(filepath));
    	
        // 2. Properties -> urlCommandMap
    	Set<String> urlSet = prop.stringPropertyNames();
    	for(String url : urlSet) {
    		String className = prop.getProperty(url); // controller class fullName
    		Class<?> clz = Class.forName(className);
    		
    		// reflection api
    		Class<?>[] param = new Class<?>[1];
    		Object[] args = new Object[1];
    		
    		if(url.startsWith("/student")) {
    			param[0] = IStudentService.class; // 생성자인자로 전달될 타입
    			args[0] = studentService; 		  // 생성자 호출 시 전달할 인자
    		}
    		else if(url.startsWith("/emp")) {
    			param[0] = EmpService.class;	  // 생성자인자로 전달될 타입
    			args[0] = empService;   		  // 생성자 호출 시 전달할 인자
    		}
    		
    		Constructor<?> constructor = clz.getDeclaredConstructor(param); // 생성자 가져오기 // 파라미터생성자 // // 여기에 null 값을 전달하면 기본생성자이다.
    		AbstractController controller = (AbstractController) constructor.newInstance(args); // 생성자 호출
    		urlCommandMap.put(url, controller);
    	}
    	System.out.println("[DispatcherServlet] urlCommandMap = " + urlCommandMap);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청주소
		String uri = request.getRequestURI(); // /mybatis/student/studentEnroll.do
		String url = uri.replace(request.getContextPath(), "");
		System.out.println("[DispatcherServlet.doGet] url = " + url);                                       
		
		AbstractController controller = urlCommandMap.get(url);
		if(controller == null)
			throw new ControllerNotFoundException(url + "에 매핑된 컨트롤러가 없습니다.");
		
		// 2. controller의 doGet/doPost를 호출
		String method = request.getMethod(); // GET / POST
		String viewName = null;
		switch(method) {
		case "GET" : viewName = controller.doGet(request, response); break;
		case "POST" : viewName = controller.doPost(request, response); break;
		default : throw new MethodNotAllowedException(method);
		}
		
		// 3. jsp forwarding(student/studentEnroll) | redirect(redirect:~) | pass(json처리)(null)
		if(viewName != null) {
			if(viewName.startsWith("redirect:")) {
				// redirect:/student/studentEnroll.do
				String location = request.getContextPath() + viewName.replace("redirect:", "");
				response.sendRedirect(location);
			}
			else {
				// forwarding student/studentEnroll
				String prefix = "/WEB-INF/views/";
				String suffix = ".jsp";
				request
					.getRequestDispatcher(prefix + viewName + suffix)
					.forward(request, response);
			}
		}
		else {
			// pass(json처리)
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
