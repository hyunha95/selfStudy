/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2021-12-06 11:25:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.mvc.board.model.vo.Attachment;
import java.util.List;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

public final class boardUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1638522380484L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1635750570227L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.mvc.member.model.vo.Member");
    _jspx_imports_classes.add("com.kh.mvc.board.model.vo.Attachment");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.kh.mvc.member.model.service.MemberService");
    _jspx_imports_classes.add("com.kh.mvc.board.model.vo.Board");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");

	String msg = (String) session.getAttribute("msg");
	if(msg != null) session.removeAttribute("msg");
	
	Member loginMember = (Member) session.getAttribute("loginMember");
	
	// 쿠키처리
	Cookie[] cookies = request.getCookies();
	String saveMemberId = null;
	if(cookies != null){
		for(Cookie cookie : cookies){
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println(name + " = " + value);
			if("saveId".equals(name)){
				saveMemberId = value;
			}
		}
	}
	System.out.println("saveMemberId@header.jsp = " + saveMemberId);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Hello MVC</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style.css\" />\r\n");
      out.write("<script src=\"");
      out.print( request.getContextPath() );
      out.write("/js/jquery-3.6.0.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$(() => {\r\n");
      out.write("\r\n");
 if(msg != null){ 
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	alert(\"");
      out.print( msg );
      out.write("\");\r\n");
      out.write("\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
 if(loginMember == null) { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    /**\r\n");
      out.write("	 * 로그인폼 유효성 검사\r\n");
      out.write("	 */\r\n");
      out.write("	$(loginFrm).submit((e) => {\r\n");
      out.write("		const $memberId = $(memberId);\r\n");
      out.write("		const $password = $(password);\r\n");
      out.write("		\r\n");
      out.write("		if(!/^\\w{4,}$/.test($memberId.val())){\r\n");
      out.write("			alert(\"유효한 아이디를 입력하세요.\");\r\n");
      out.write("			$memberId.select();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(!/^.{4,}$/.test($password.val())){\r\n");
      out.write("			alert(\"유효한 비밀번호를 입력하세요.\");\r\n");
      out.write("			$password.select();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("	});\r\n");
      out.write("\r\n");
 } 
      out.write("\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div id=\"container\">\r\n");
      out.write("		<header>\r\n");
      out.write("			<h1>Hello MVC</h1>\r\n");
      out.write("				<div class=\"login-container\">\r\n");
 if(loginMember == null){ 
      out.write("\r\n");
      out.write("					<!-- 로그인폼 시작 -->\r\n");
      out.write("					<form \r\n");
      out.write("						id=\"loginFrm\" \r\n");
      out.write("						action=\"");
      out.print( request.getContextPath() );
      out.write("/member/login\"\r\n");
      out.write("						method=\"POST\">\r\n");
      out.write("						<table>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td><input type=\"text\" name=\"memberId\" id=\"memberId\" placeholder=\"아이디\" tabindex=\"1\" value=\"");
      out.print( saveMemberId != null ? saveMemberId : "" );
      out.write("\"></td>\r\n");
      out.write("								<td><input type=\"submit\" value=\"로그인\" tabindex=\"3\"></td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td><input type=\"password\" name=\"password\" id=\"password\" placeholder=\"비밀번호\" tabindex=\"2\"></td>\r\n");
      out.write("								<td></td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td colspan=\"2\">\r\n");
      out.write("									<input type=\"checkbox\" name=\"saveId\" id=\"saveId\" ");
      out.print( saveMemberId != null ? "checked" : "" );
      out.write("/>\r\n");
      out.write("									<label for=\"saveId\">아이디저장</label>&nbsp;&nbsp;\r\n");
      out.write("									<input \r\n");
      out.write("										type=\"button\" \r\n");
      out.write("										value=\"회원가입\" \r\n");
      out.write("										onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/member/memberEnroll';\">\r\n");
      out.write("									<input \r\n");
      out.write("										type=\"button\" \r\n");
      out.write("										value=\"비밀번호 찾기\" \r\n");
      out.write("										onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/member/emailSendAction';\">\r\n");
      out.write("								</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("						</table>\r\n");
      out.write("					</form>\r\n");
      out.write("					<!-- 로그인폼 끝-->\r\n");
 } else { 
      out.write("\r\n");
      out.write("					<table id=\"login\">\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>");
      out.print( loginMember.getMemberName() );
      out.write("님, 안녕하세요.</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>\r\n");
      out.write("								<input type=\"button\" value=\"내정보보기\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/member/memberView';\">\r\n");
      out.write("								<input type=\"button\" value=\"로그아웃\" onclick=\"location.href=`");
      out.print( request.getContextPath() );
      out.write("/member/logout`;\">\r\n");
      out.write("							</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</table>\r\n");
 } 
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("				<!-- 메인메뉴 시작 -->\r\n");
      out.write("				<nav>\r\n");
      out.write("					<ul class=\"main-nav\">\r\n");
      out.write("						<li class=\"home\"><a href=\"");
      out.print( request.getContextPath() );
      out.write("\">Home</a></li>\r\n");
      out.write("						<li class=\"notice\"><a href=\"#\">공지사항</a></li>\r\n");
      out.write("						<li class=\"board\"><a href=\"");
      out.print( request.getContextPath() );
      out.write("/board/boardList\">게시판</a></li>\r\n");
      out.write("						<li class=\"photo\"><a href=\"");
      out.print( request.getContextPath() );
      out.write("/photo/photoList\">사진게시판</a></li>\r\n");
      out.write("						<li class=\"chat\"><a href=\"");
      out.print( request.getContextPath() );
      out.write("/chat/chatroom\">채팅</a></li>\r\n");
 if(loginMember != null && MemberService.ADMIN_ROLE.equals(loginMember.getMemberRole())){ 
      out.write("						\r\n");
      out.write("						<li class=\"admin\"><a href=\"");
      out.print( request.getContextPath() );
      out.write("/admin/memberList\">회원관리</a></li>\r\n");
 } 
      out.write("				\r\n");
      out.write("					</ul>\r\n");
      out.write("				</nav>\r\n");
      out.write("				<!-- 메인메뉴 끝-->\r\n");
      out.write("						\r\n");
      out.write("		</header>\r\n");
      out.write("		\r\n");
      out.write("		<section id=\"content\">");
      out.write("    \r\n");

	Board board = (Board) request.getAttribute("board");

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/board.css\" />\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("/**\r\n");
      out.write("* boardUpdateFrm 유효성 검사\r\n");
      out.write("*/\r\n");
      out.write("function boardValidate(){\r\n");
      out.write("	const $title = $(\"[name=title]\");\r\n");
      out.write("	const $content = $(\"[name=content]\");\r\n");
      out.write("	//제목을 작성하지 않은 경우 폼제출할 수 없음.\r\n");
      out.write("	if(/^.+$/.test($title.val())){\r\n");
      out.write("		alert(\"제못을 입력하세요.\");\r\n");
      out.write("		return false;\r\n");
      out.write("	}					   \r\n");
      out.write("	//내용을 작성하지 않은 경우 폼제출할 수 없음.\r\n");
      out.write("	// \\n는 .에 포함되지 않는다.\r\n");
      out.write("	if(/^(.|\\n)+$/.test($title.val())){\r\n");
      out.write("		alert(\"내용을 입력하세요.\");\r\n");
      out.write("		return false;\r\n");
      out.write("	}	\r\n");
      out.write("	return true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(document.boardUpdateFrm).submit(boardValidate); // 함수 자체를 전달해야함 ()붙이면 리턴값을 전달한다.\r\n");
      out.write("</script>\r\n");
      out.write("<section id=\"board-container\">\r\n");
      out.write("<h2>게시판 수정</h2>\r\n");
      out.write("<form\r\n");
      out.write("	name=\"boardUpdateFrm\"\r\n");
      out.write("	action=\"");
      out.print(request.getContextPath() );
      out.write("/board/boardUpdate\" \r\n");
      out.write("	method=\"post\"\r\n");
      out.write("	enctype=\"multipart/form-data\"> <!-- 이게 있어야 브라우저가 쓰기 작업을 해준다. -->\r\n");
      out.write("	<input type=\"hidden\" name=\"no\" value=\"");
      out.print( board.getNo() );
      out.write("\" />\r\n");
      out.write("	<table id=\"tbl-board-view\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>제 목</th>\r\n");
      out.write("		<td><input type=\"text\" name=\"title\" value=\"");
      out.print( board.getTitle() );
      out.write("\" required></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>작성자</th>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type=\"text\" name=\"writer\" value=\"");
      out.print( board.getWriter() );
      out.write("\" readonly/>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");

	List<Attachment> attachments = board.getAttachments();
	if(attachments != null && !attachments.isEmpty()){

      out.write("\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>기존 첨부파일</th>\r\n");
      out.write("		<td>\r\n");

		for(Attachment attach : attachments){		

      out.write("\r\n");
      out.write("		<div style=\"padding:0; margin:3px;\">\r\n");
      out.write("			<img src=\"");
      out.print( request.getContextPath() );
      out.write("/images/file.png\" width=\"16px\" />\r\n");
      out.write("			");
      out.print( attach.getOriginalFilename() );
      out.write("\r\n");
      out.write("			<label for=\"delFile");
      out.print( attach.getNo() );
      out.write("\">제거</label>\r\n");
      out.write("			<input \r\n");
      out.write("				type=\"checkbox\" \r\n");
      out.write("				name=\"delFile\" \r\n");
      out.write("				id=\"delFile");
      out.print( attach.getNo() );
      out.write("\" \r\n");
      out.write("				value=\"");
      out.print( attach.getNo() );
      out.write("\" />		\r\n");
      out.write("		</div>\r\n");

		}

      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");

	}

      out.write("	\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>첨부파일</th>\r\n");
      out.write("		<td>			\r\n");
      out.write("			<input type=\"file\" name=\"upFile1\">\r\n");
      out.write("			<br>\r\n");
      out.write("			<input type=\"file\" name=\"upFile2\">\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>내 용</th>\r\n");
      out.write("		<td><textarea rows=\"5\" cols=\"40\" name=\"content\">");
      out.print( board.getContent() );
      out.write("</textarea></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th colspan=\"2\">\r\n");
      out.write("			<input type=\"submit\" value=\"수정하기\">\r\n");
      out.write("		</th>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("		</section>\r\n");
      out.write("\r\n");
      out.write("		<footer>\r\n");
      out.write("			<p>&lt;Copyright 1998-2021 <strong>KH정보교육원</strong>. All rights reserved.&gt;</p>\r\n");
      out.write("		</footer>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
