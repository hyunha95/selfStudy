/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2022-01-14 13:53:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1640329561927L));
    _jspx_dependants.put("jar:file:/C:/Workspaces/bookit/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/C:/Workspaces/bookit/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/C:/Workspaces/bookit/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fmt.tld", Long.valueOf(1425946270000L));
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Title -->\r\n");
      out.write("    <title>Bookit - Book Rental & Resale</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Favicon --> \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Stylesheet -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/roberto/style.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- Preloader -->\r\n");
      out.write("    <div id=\"preloader\">\r\n");
      out.write("        <div class=\"loader\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /Preloader -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Header Area Start -->\r\n");
      out.write("    <header class=\"header-area\">\r\n");
      out.write("        <!-- Search Form -->\r\n");
      out.write("        <div class=\"search-form d-flex align-items-center\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <form action=\"index.html\" method=\"get\">\r\n");
      out.write("                    <input type=\"search\" name=\"search-form-input\" id=\"searchFormInput\" placeholder=\"Type your keyword ...\">\r\n");
      out.write("                    <button type=\"submit\"><i class=\"icon_search\"></i></button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Top Header Area Start -->\r\n");
      out.write("        <!-- <div class=\"top-header-area\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <div class=\"top-header-content\">\r\n");
      out.write("                            <a href=\"#\"><i class=\"icon_phone\"></i> <span>(123) 456-789-1230</span></a>\r\n");
      out.write("                            <a href=\"#\"><i class=\"icon_mail\"></i> <span>info.colorlib@gmail.com</span></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <div class=\"top-header-content\">\r\n");
      out.write("                            Top Social Area\r\n");
      out.write("                            <div class=\"top-social-area ml-auto\">\r\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-tripadvisor\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div> -->\r\n");
      out.write("        <!-- Top Header Area End -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Main Header Start -->\r\n");
      out.write("        <div class=\"main-header-area\">\r\n");
      out.write("            <div class=\"classy-nav-container breakpoint-off\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <!-- Classy Menu -->\r\n");
      out.write("                    <nav class=\"classy-navbar justify-content-between\" id=\"robertoNav\">\r\n");
      out.write("\r\n");
      out.write("                        <!-- Logo -->\r\n");
      out.write("                        <a class=\"nav-brand\" href=\"index.jsp\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/img/bookit_logo.png\" alt=\"\"></a>\r\n");
      out.write("\r\n");
      out.write("                        <!-- Navbar Toggler -->\r\n");
      out.write("                        <div class=\"classy-navbar-toggler\">\r\n");
      out.write("                            <span class=\"navbarToggler\"><span></span><span></span><span></span></span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- Menu -->\r\n");
      out.write("                        <div class=\"classy-menu\">\r\n");
      out.write("                            <!-- Menu Close Button -->\r\n");
      out.write("                            <div class=\"classycloseIcon\">\r\n");
      out.write("                                <div class=\"cross-wrap\"><span class=\"top\"></span><span class=\"bottom\"></span></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- Nav Start -->\r\n");
      out.write("                            <div class=\"classynav\">\r\n");
      out.write("                                <ul id=\"nav\">\r\n");
      out.write("                                    \r\n");
      out.write("                                    <li><a href=\"#\">중고거래</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">커뮤니티</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">도서요청</a>\r\n");
      out.write("                                        <!-- <ul class=\"dropdown\">\r\n");
      out.write("                                            <li><a href=\"./index.html\">- Home</a></li>\r\n");
      out.write("                                            <li><a href=\"./room.html\">- Rooms</a></li>\r\n");
      out.write("                                            <li><a href=\"./single-room.html\">- Single Rooms</a></li>\r\n");
      out.write("                                            <li><a href=\"./about.html\">- About Us</a></li>\r\n");
      out.write("                                            <li><a href=\"./blog.html\">- Blog</a></li>\r\n");
      out.write("                                            <li><a href=\"./single-blog.html\">- Single Blog</a></li>\r\n");
      out.write("                                            <li><a href=\"./contact.html\">- Contact</a></li>\r\n");
      out.write("                                            <li><a href=\"#\">- Dropdown</a>\r\n");
      out.write("                                                <ul class=\"dropdown\">\r\n");
      out.write("                                                    <li><a href=\"#\">- Dropdown Item</a></li>\r\n");
      out.write("                                                    <li><a href=\"#\">- Dropdown Item</a></li>\r\n");
      out.write("                                                    <li><a href=\"#\">- Dropdown Item</a></li>\r\n");
      out.write("                                                    <li><a href=\"#\">- Dropdown Item</a></li>\r\n");
      out.write("                                                </ul>\r\n");
      out.write("                                            </li>\r\n");
      out.write("                                        </ul> -->\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li><a href=\"#\">컬렉션</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">관리자</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("\r\n");
      out.write("                                <!-- Search -->\r\n");
      out.write("                                <div class=\"search-btn ml-4\">\r\n");
      out.write("                                    <i class=\"fa fa-search\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <!-- Book Now -->\r\n");
      out.write("                                <div class=\"book-now-btn ml-3 ml-lg-5\">\r\n");
      out.write("                                    <a href=\"#\">로그인/회원가입<i class=\"fa fa-long-arrow-right\" aria-hidden=\"true\"></i></a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- Nav End -->\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- Header Area End -->");
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
