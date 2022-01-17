/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2022-01-14 12:00:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.menu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("메뉴 REST", request.getCharacterEncoding()), out, false);
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("	<div id=\"menu-container\" class=\"text-center\">\r\n");
      out.write("			<!-- 1. GET /menus-->\r\n");
      out.write("	        <div class=\"menu-test\">\r\n");
      out.write("	            <h4>전체메뉴조회(GET)</h4>\r\n");
      out.write("	            <input type=\"button\" class=\"btn btn-block btn-outline-success btn-send\" id=\"btn-menus\" value=\"전송\" />\r\n");
      out.write("	        </div>\r\n");
      out.write("	        <div class=\"result\" id=\"menus-result\"></div>\r\n");
      out.write("	        <script>\r\n");
      out.write("	        const MENU_REST_SERVER = \"http://localhost:10000/springboot\";\r\n");
      out.write("	        \r\n");
      out.write("	        $(\"#btn-menus\").click((e) => {\r\n");
      out.write("	        	\r\n");
      out.write("	        	$.ajax({\r\n");
      out.write("	        		url: `${MENU_REST_SERVER}/menus`,\r\n");
      out.write("	        		method: \"GET\",\r\n");
      out.write("	        		success(resp){\r\n");
      out.write("	        			console.log(resp);\r\n");
      out.write("	        			\r\n");
      out.write("	        			displayTable(\"#menus-result\", resp);\r\n");
      out.write("	        		},\r\n");
      out.write("	        		error: console.log\r\n");
      out.write("	        	});\r\n");
      out.write("	        });\r\n");
      out.write("	        \r\n");
      out.write("	        const displayTable = (selector, data) => {\r\n");
      out.write("	        	const $target = $(selector);\r\n");
      out.write("	        	let table = `<table class='table'>\r\n");
      out.write("	        		<tr>\r\n");
      out.write("	        			<th>번호</th>\r\n");
      out.write("	        			<th>음식점</th>\r\n");
      out.write("	        			<th>메뉴명</th>\r\n");
      out.write("	        			<th>가격</th>\r\n");
      out.write("	        			<th>타입</th>\r\n");
      out.write("	        			<th>맛</th>\r\n");
      out.write("	        		</tr>`;\r\n");
      out.write("	        		\r\n");
      out.write("	        		if(data.length) {\r\n");
      out.write("	        			$(data).each((i, menu) => {\r\n");
      out.write("	        				console.log(i, menu);\r\n");
      out.write("	        				const {id, restaurant, name, price, type, taste} = menu;\r\n");
      out.write("	        				table += `<tr>\r\n");
      out.write("	        					<td>${id}</td>\r\n");
      out.write("	        					<td>${restaurant}</td>\r\n");
      out.write("	        					<td>${name}</td>\r\n");
      out.write("	        					<td>￦${price.toLocaleString()}</td>\r\n");
      out.write("	        					<td>${type}</td>\r\n");
      out.write("	        					<td>${taste}</td>\r\n");
      out.write("	        				<tr>`;\r\n");
      out.write("	        			});\r\n");
      out.write("	        		}\r\n");
      out.write("	        		else {\r\n");
      out.write("	        			table += `<tr><td colspan='6'>검색된 결과가 없습니다.</td></tr>`;\r\n");
      out.write("	        		}\r\n");
      out.write("	        		\r\n");
      out.write("	        		table += `</table>`;\r\n");
      out.write("	        		\r\n");
      out.write("	        		$target.html(table);\r\n");
      out.write("	        };\r\n");
      out.write("	        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			<div class=\"menu-test\">\r\n");
      out.write("				<h4>추천메뉴(GET)</h4>\r\n");
      out.write("				<form id=\"menuRecommendationFrm\">\r\n");
      out.write("					<div class=\"form-check form-check-inline\">\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"get-no-type\" value=\"all\" checked>\r\n");
      out.write("						<label for=\"get-no-type\" class=\"form-check-label\">모두</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"get-kr\" value=\"kr\">\r\n");
      out.write("						<label for=\"get-kr\" class=\"form-check-label\">한식</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"get-ch\" value=\"ch\">\r\n");
      out.write("						<label for=\"get-ch\" class=\"form-check-label\">중식</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"get-jp\" value=\"jp\">\r\n");
      out.write("						<label for=\"get-jp\" class=\"form-check-label\">일식</label>&nbsp;\r\n");
      out.write("					</div>\r\n");
      out.write("					<br />\r\n");
      out.write("					<div class=\"form-check form-check-inline\">\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"taste\" id=\"get-no-taste\" value=\"all\" checked>\r\n");
      out.write("						<label for=\"get-no-taste\" class=\"form-check-label\">모두</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"taste\" id=\"get-hot\" value=\"hot\" checked>\r\n");
      out.write("						<label for=\"get-hot\" class=\"form-check-label\">매운맛</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"taste\" id=\"get-mild\" value=\"mild\">\r\n");
      out.write("						<label for=\"get-mild\" class=\"form-check-label\">순한맛</label>\r\n");
      out.write("					</div>\r\n");
      out.write("					<br />\r\n");
      out.write("					<input type=\"submit\" class=\"btn btn-block btn-outline-success btn-send\" value=\"전송\" >\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"result\" id=\"menuRecommendation-result\"></div>\r\n");
      out.write("			<script>\r\n");
      out.write("			$(menuRecommendationFrm).submit((e) => {\r\n");
      out.write("				e.preventDefault();\r\n");
      out.write("				\r\n");
      out.write("				const type = $(e.target).find(\"[name=type]:checked\").val();\r\n");
      out.write("				const taste = $(e.target).find(\"[name=taste]:checked\").val();\r\n");
      out.write("				console.log(type);\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: `${MENU_REST_SERVER}/menus/${type}/${taste}`,\r\n");
      out.write("					method: \"GET\",\r\n");
      out.write("					success(resp){\r\n");
      out.write("						console.log(resp);\r\n");
      out.write("						displayTable(\"#menuRecommendation-result\", resp);\r\n");
      out.write("					},\r\n");
      out.write("					error: console.log\r\n");
      out.write("				});\r\n");
      out.write("			});\r\n");
      out.write("			</script>\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			<!-- 2.POST /menu -->\r\n");
      out.write("			<div class=\"menu-test\">\r\n");
      out.write("				<h4>메뉴 등록하기(POST)</h4>\r\n");
      out.write("				<form id=\"menuEnrollFrm\">\r\n");
      out.write("					<input type=\"text\" name=\"restaurant\" placeholder=\"음식점\" class=\"form-control\" value=\"맘스터치\"/>\r\n");
      out.write("					<br />\r\n");
      out.write("					<input type=\"text\" name=\"name\" placeholder=\"메뉴\" class=\"form-control\" value=\"할라피뇨버거세트\" />\r\n");
      out.write("					<br />\r\n");
      out.write("					<input type=\"number\" name=\"price\" placeholder=\"가격\" class=\"form-control\" value=\"8500\" />\r\n");
      out.write("					<br />\r\n");
      out.write("					<div class=\"form-check form-check-inline\">\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"post-kr\" value=\"kr\" checked>\r\n");
      out.write("						<label for=\"post-kr\" class=\"form-check-label\">한식</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"post-ch\" value=\"ch\">\r\n");
      out.write("						<label for=\"post-ch\" class=\"form-check-label\">중식</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"post-jp\" value=\"jp\">\r\n");
      out.write("						<label for=\"post-jp\" class=\"form-check-label\">일식</label>&nbsp;\r\n");
      out.write("					</div>\r\n");
      out.write("					<br />\r\n");
      out.write("					<div class=\"form-check form-check-inline\">\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"taste\" id=\"post-hot\" value=\"hot\" checked>\r\n");
      out.write("						<label for=\"post-hot\" class=\"form-check-label\">매운맛</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"taste\" id=\"post-mild\" value=\"mild\">\r\n");
      out.write("						<label for=\"post-mild\" class=\"form-check-label\">순한맛</label>\r\n");
      out.write("					</div>\r\n");
      out.write("					<br />\r\n");
      out.write("					<input type=\"submit\" class=\"btn btn-block btn-outline-success btn-send\" value=\"등록\" >\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("			<script>\r\n");
      out.write("			$(menuEnrollFrm).submit((e) => {\r\n");
      out.write("				e.preventDefault();\r\n");
      out.write("				\r\n");
      out.write("				const obj = {\r\n");
      out.write("					restaurant : $(\"[name=restaurant]\", e.target).val(),\r\n");
      out.write("					name : $(\"[name=name]\", e.target).val(),\r\n");
      out.write("					price : $(\"[name=price]\", e.target).val(),\r\n");
      out.write("					type : $(\"[name=type]:checked\", e.target).val(),\r\n");
      out.write("					taste : $(\"[name=taste]:checked\", e.target).val()\r\n");
      out.write("				};\r\n");
      out.write("				\r\n");
      out.write("				console.log(obj); // javascript 객체\r\n");
      out.write("				const jsonStr = JSON.stringify(obj);\r\n");
      out.write("				console.log(jsonStr); // json문자열\r\n");
      out.write("				\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: `${MENU_REST_SERVER}/menu`,\r\n");
      out.write("					method: \"POST\",\r\n");
      out.write("					data: jsonStr,\r\n");
      out.write("					contentType: \"application/json; charset=utf-8\",\r\n");
      out.write("					success(resp){\r\n");
      out.write("						console.log(resp);\r\n");
      out.write("						alert(resp.msg);\r\n");
      out.write("					},\r\n");
      out.write("					error: console.log\r\n");
      out.write("				});\r\n");
      out.write("			});\r\n");
      out.write("			</script>\r\n");
      out.write("			\r\n");
      out.write("			<!-- #3.PUT -->\r\n");
      out.write("			<div class=\"menu-test\">\r\n");
      out.write("				<h4>메뉴 수정하기(PUT)</h4>\r\n");
      out.write("				<p>메뉴번호를 사용해 해당메뉴정보를 수정함.</p>\r\n");
      out.write("				<form id=\"menuSearchFrm\">\r\n");
      out.write("					<input type=\"text\" name=\"id\" placeholder=\"메뉴번호\" class=\"form-control\" /><br />\r\n");
      out.write("					<input type=\"submit\" class=\"btn btn-block btn-outline-primary btn-send\" value=\"검색\" >\r\n");
      out.write("				</form>\r\n");
      out.write("			\r\n");
      out.write("				<hr />\r\n");
      out.write("				<form id=\"menuUpdateFrm\">\r\n");
      out.write("					<!-- where조건절에 사용할 id를 담아둠 -->\r\n");
      out.write("					<input type=\"hidden\" name=\"id\" />\r\n");
      out.write("					<input type=\"text\" name=\"restaurant\" placeholder=\"음식점\" class=\"form-control\" />\r\n");
      out.write("					<br />\r\n");
      out.write("					<input type=\"text\" name=\"name\" placeholder=\"메뉴\" class=\"form-control\" />\r\n");
      out.write("					<br />\r\n");
      out.write("					<input type=\"number\" name=\"price\" placeholder=\"가격\" step=\"1000\" class=\"form-control\" />\r\n");
      out.write("					<br />\r\n");
      out.write("					<div class=\"form-check form-check-inline\">\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"put-kr\" value=\"kr\" checked>\r\n");
      out.write("						<label for=\"put-kr\" class=\"form-check-label\">한식</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"put-ch\" value=\"ch\">\r\n");
      out.write("						<label for=\"put-ch\" class=\"form-check-label\">중식</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"type\" id=\"put-jp\" value=\"jp\">\r\n");
      out.write("						<label for=\"put-jp\" class=\"form-check-label\">일식</label>&nbsp;\r\n");
      out.write("					</div>\r\n");
      out.write("					<br />\r\n");
      out.write("					<div class=\"form-check form-check-inline\">\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"taste\" id=\"put-hot\" value=\"hot\" checked>\r\n");
      out.write("						<label for=\"put-hot\" class=\"form-check-label\">매운맛</label>&nbsp;\r\n");
      out.write("						<input type=\"radio\" class=\"form-check-input\" name=\"taste\" id=\"put-mild\" value=\"mild\">\r\n");
      out.write("						<label for=\"put-mild\" class=\"form-check-label\">순한맛</label>\r\n");
      out.write("					</div>\r\n");
      out.write("					<br />\r\n");
      out.write("					<input type=\"submit\" class=\"btn btn-block btn-outline-success btn-send\" value=\"수정\" >\r\n");
      out.write("				</form>\r\n");
      out.write("			</div>\r\n");
      out.write("			<script>\r\n");
      out.write("			$(menuSearchFrm).submit((e) => {\r\n");
      out.write("				e.preventDefault();\r\n");
      out.write("				const id = $(\"[name=id]\", e.target).val();\r\n");
      out.write("				console.log(id);	\r\n");
      out.write("				\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: `${MENU_REST_SERVER}/menu/${id}`,\r\n");
      out.write("					method: \"GET\",\r\n");
      out.write("					success(resp){\r\n");
      out.write("						console.log(resp);\r\n");
      out.write("						const {id, restaurant, name, price, type, taste} = resp;\r\n");
      out.write("						const $frm = $(menuUpdateFrm);\r\n");
      out.write("						$frm.find(\"[name=id]\").val(id);\r\n");
      out.write("						$frm.find(\"[name=restaurant]\").val(restaurant);\r\n");
      out.write("						$frm.find(\"[name=name]\").val(name);\r\n");
      out.write("						$frm.find(\"[name=price]\").val(price);\r\n");
      out.write("						\r\n");
      out.write("						$frm.find(`[name=type][value=${type}]`).prop(\"checked\", true);\r\n");
      out.write("						$frm.find(`[name=taste][value=${taste}]`).prop(\"checked\", true);\r\n");
      out.write("						\r\n");
      out.write("					},\r\n");
      out.write("					error(xhr, textStatus, err){\r\n");
      out.write("						if(xhr.status == 404)\r\n");
      out.write("							alert(\"조회한 메뉴는 존재하지 않습니다.\");\r\n");
      out.write("						else\r\n");
      out.write("							console.log(xhr, textStatus, err);\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			$(menuUpdateFrm).submit((e) => {\r\n");
      out.write("				e.preventDefault();\r\n");
      out.write("				\r\n");
      out.write("				const obj = {\r\n");
      out.write("						id: $(\"[name=id]\", e.target).val(),\r\n");
      out.write("						restaurant: $(\"[name=restaurant]\", e.target).val(),\r\n");
      out.write("						name: $(\"[name=name]\", e.target).val(),\r\n");
      out.write("						price: $(\"[name=price]\", e.target).val(),\r\n");
      out.write("						type: $(\"[name=type]:checked\", e.target).val(),\r\n");
      out.write("						taste: $(\"[name=taste]:checked\", e.target).val()\r\n");
      out.write("				};\r\n");
      out.write("				const jsonStr = JSON.stringify(obj);\r\n");
      out.write("				\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: `${MENU_REST_SERVER}/menu`,\r\n");
      out.write("					method: \"PUT\",\r\n");
      out.write("					data: jsonStr,\r\n");
      out.write("					contentType: \"application/json; charset=utf-8\",\r\n");
      out.write("					success(resp){\r\n");
      out.write("						console.log(resp);\r\n");
      out.write("						alert(resp.msg);\r\n");
      out.write("					},\r\n");
      out.write("					error: console.log,\r\n");
      out.write("					complete(){\r\n");
      out.write("						// #menuUpdateFrm.reset()\r\n");
      out.write("						$(e.target)[0].reset();\r\n");
      out.write("						$(menuSearchFrm)[0].reset();\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			});\r\n");
      out.write("			</script>\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"menu-test\">\r\n");
      out.write("		    	<h4>메뉴 삭제하기(DELETE)</h4>\r\n");
      out.write("		    	<p>메뉴번호를 사용해 해당메뉴정보를 삭제함.</p>\r\n");
      out.write("		    	<form id=\"menuDeleteFrm\">\r\n");
      out.write("		    		<input type=\"text\" name=\"id\" placeholder=\"메뉴번호\" class=\"form-control\" /><br />\r\n");
      out.write("		    		<input type=\"submit\" class=\"btn btn-block btn-outline-danger btn-send\" value=\"삭제\" >\r\n");
      out.write("		    	</form>\r\n");
      out.write("		    </div>\r\n");
      out.write("			<script>\r\n");
      out.write("			$(menuDeleteFrm).submit((e) => {\r\n");
      out.write("				e.preventDefault();\r\n");
      out.write("				\r\n");
      out.write("				const id = $(e.target).find(\"[name=id]\").val();\r\n");
      out.write("				\r\n");
      out.write("				$.ajax({\r\n");
      out.write("					url: `${MENU_REST_SERVER}/menu/${id}`,\r\n");
      out.write("					method: \"DELETE\",\r\n");
      out.write("					success(resp){\r\n");
      out.write("						console.log(resp);\r\n");
      out.write("						alert(resp.msg);\r\n");
      out.write("					},\r\n");
      out.write("					error(xhr, statusText, err){\r\n");
      out.write("						switch(xhr.status){\r\n");
      out.write("						case 404: alert(\"해당 메뉴가 존재하지 않습니다.\"); break;\r\n");
      out.write("						default: console.log(xhr,statusText,err);\r\n");
      out.write("						}\r\n");
      out.write("					}\r\n");
      out.write("				});\r\n");
      out.write("			});\r\n");
      out.write("			</script>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
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