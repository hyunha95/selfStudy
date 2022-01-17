/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2021-12-07 08:37:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

public final class chatroom_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1638866230598L));
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
    _jspx_imports_classes.add("com.kh.mvc.member.model.service.MemberService");
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

      out.write('\r');
      out.write('\n');
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
      out.write("  \r\n");
      out.write("<script>\r\n");
      out.write("const host = location.host; \r\n");
      out.write("const ws = new WebSocket(`ws://${host}");
      out.print( request.getContextPath() );
      out.write("/chat/websocket`);\r\n");
      out.write("ws.onopen = (e) => {\r\n");
      out.write("	console.log(\"open\", e);\r\n");
      out.write("};\r\n");
      out.write("ws.onmessage = (e) => {\r\n");
      out.write("	console.log(\"message\", e);\r\n");
      out.write("	const {data} = e;\r\n");
      out.write("	const {type, msg, sender, time} = JSON.parse(data);\r\n");
      out.write("	console.log(type, msg, sender, time);\r\n");
      out.write("	\r\n");
      out.write("	let html = \"\";\r\n");
      out.write("	switch(type){\r\n");
      out.write("	case \"welcome\":\r\n");
      out.write("	case \"bye\": html = `<li class=\"center\"><span class=\"badge\">${sender}</span>${msg}</li>`; break;\r\n");
      out.write("	case \"msg\": html = `<li><span class=\"badge\">${sender}</span>${msg}</li>`; break;\r\n");
      out.write("	case \"dm\" : alert(`${sender} 님으로부터의 DM\r\n");
      out.write("----------------------------------------\r\n");
      out.write("${msg}\r\n");
      out.write("----------------------------------------`); break;\r\n");
      out.write("	}\r\n");
      out.write("	$(\"#msg-container ul\").append(html);\r\n");
      out.write("	\r\n");
      out.write("	// 스크롤처리\r\n");
      out.write("	const $msgContainer = $(\"#msg-container\");\r\n");
      out.write("	const scrollHeight = $msgContainer.prop(\"scrollHeight\");\r\n");
      out.write("	$msgContainer.scrollTop(scrollHeight);\r\n");
      out.write("};\r\n");
      out.write("ws.onerror = (e) => {\r\n");
      out.write("	console.log(\"error\", e);\r\n");
      out.write("};\r\n");
      out.write("ws.onclose = (e) => {\r\n");
      out.write("	console.log(\"close\", e);\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("$(() => {\r\n");
      out.write("	/**\r\n");
      out.write("	 * websocket message 전송\r\n");
      out.write("	 */\r\n");
      out.write("	$(send).click((e) => {\r\n");
      out.write("		const o = {\r\n");
      out.write("			type: \"msg\",\r\n");
      out.write("			sender: \"");
      out.print( loginMember.getMemberId() );
      out.write("\",\r\n");
      out.write("			msg: $(msg).val(),\r\n");
      out.write("			time: Date.now()\r\n");
      out.write("		};\r\n");
      out.write("		\r\n");
      out.write("		// 메세지 전송\r\n");
      out.write("		ws.send(JSON.stringify(o));\r\n");
      out.write("		\r\n");
      out.write("		// #msg 초기화\r\n");
      out.write("		$(msg).val('').focus();\r\n");
      out.write("		\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(msg).keyup((e) => {\r\n");
      out.write("		if(e.key === 'Enter')\r\n");
      out.write("			$(send).trigger(\"click\");\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"#dm-client\").mouseover((e) => {\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: \"");
      out.print( request.getContextPath() );
      out.write("/chat/memberList\",\r\n");
      out.write("			success(data){\r\n");
      out.write("				console.log(data);\r\n");
      out.write("				$(e.target).empty();\r\n");
      out.write("				$(data).each((i, memberId) => {\r\n");
      out.write("					$(e.target).append(`<option value=\"${memberId}\">${memberId}</option>`);\r\n");
      out.write("				});\r\n");
      out.write("			},\r\n");
      out.write("			error: console.log\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	$(\"#dm-send\").click((e) => {\r\n");
      out.write("		const o = {\r\n");
      out.write("			type: \"dm\",\r\n");
      out.write("			sender: \"");
      out.print( loginMember.getMemberId() );
      out.write("\",\r\n");
      out.write("			receiver: $(\"dm-client\").val(),\r\n");
      out.write("			msg: $(\"#dm-msg\").val(),\r\n");
      out.write("			time: Date.now()\r\n");
      out.write("		};\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: \"");
      out.print( request.getContextPath() );
      out.write("/chat/sendDm\",\r\n");
      out.write("			data: {\r\n");
      out.write("				msg: JSON.stringify(o)\r\n");
      out.write("			},\r\n");
      out.write("			success(data){\r\n");
      out.write("				console.log(data);\r\n");
      out.write("			},\r\n");
      out.write("			error: console.log\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/chat.css\" />\r\n");
      out.write("	<section id=\"chat-container\">	\r\n");
      out.write("		<h2>채팅</h2>\r\n");
      out.write("		<button type=\"button\" id=\"btn-userList\">현재사용자확인</button>\r\n");
      out.write("		<div id=\"msg-container\">\r\n");
      out.write("			<ul></ul>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div id=\"msg-editor\" class=\"editor\">\r\n");
      out.write("			<textarea name=\"\" id=\"msg\" cols=\"30\" rows=\"2\"></textarea>\r\n");
      out.write("			<button type=\"button\" id=\"send\">Send</button>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<hr style=\"margin:20px 0\" />\r\n");
      out.write("\r\n");
      out.write("		<!-- dm관련 섹션 -->		\r\n");
      out.write("		<div id=\"dm-container\" >\r\n");
      out.write("			<label for=\"dm-client\">DM</label>\r\n");
      out.write("			<select class=\"custom-select\" id=\"dm-client\">\r\n");
      out.write("				<option value=\"\" disabled selected>접속자 목록</option>\r\n");
      out.write("			</select>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div id=\"dm-editor\" class=\"editor\">\r\n");
      out.write("			<textarea id=\"dm-msg\" cols=\"30\" rows=\"2\"></textarea>\r\n");
      out.write("			<button type=\"button\" id=\"dm-send\">Send</button>\r\n");
      out.write("		</div>\r\n");
      out.write("	</section>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("		</section>\r\n");
      out.write("\r\n");
      out.write("		<footer>\r\n");
      out.write("			<p>&lt;Copyright 1998-2021 <strong>KH정보교육원</strong>. All rights reserved.&gt;</p>\r\n");
      out.write("		</footer>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write(' ');
      out.write(' ');
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