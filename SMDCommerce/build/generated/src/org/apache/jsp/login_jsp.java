package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"pt-br\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title>Login</title>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\n");
      out.write("        integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"min-width:372px;\">\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark border-bottom shadow-sm mb-3\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <a class=\"navbar-brand text-dark\" href=\"/\"><strong>SMD Commerce</strong></a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"navbar-collapse collapse text-dark\">\n");
      out.write("                <ul class=\"navbar-nav flex-grow-1\">\n");
      out.write("                    <li class=\"nav-item me-4\">\n");
      out.write("                        <a href=\"./index.html\" class=\"nav-link text-dark\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item me-4\">\n");
      out.write("                        <a href=\"produtos.html\" class=\"nav-link text-dark\">Produtos</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item me-4\">\n");
      out.write("                        <a href=\"#\" class=\"nav-link text-dark\">Sobre</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("                <div class=\"align-self-end\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a href=\"./login.html\" class=\"text-dark btn btn-secondary text-white\" role=\"button\">Entrar</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a href=\"./cadastro_c.html\" class=\"text-dark btn  \">Criar conta</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a href=\"./compras.html\" class=\"nav-link text-dark\">\n");
      out.write("                                <img src=\"./icons/shopping--cart 1.png\" alt=\"\">\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <main>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <form class=\"col-sm-10 col-md-8 col-lg-6\" action=\"LoginClient\" method=\"post\">\n");
      out.write("                    <h1 class=\"my-4\">Login</h1>                    \n");
      out.write("                    <hr>\n");
      out.write("                    ");
 if(request.getAttribute("mensagem") != null) {
      out.write("\n");
      out.write("                    <div>");
 request.getAttribute("mensagem");
      out.write("</div>\n");
      out.write("                    \n");
      out.write("                    ");
 }; 
      out.write("\n");
      out.write("                    <div class=\"form-floating mb-3\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" autofocus id=\"txtEmail\" placeholder=\" \" name=\"login\">\n");
      out.write("                        <label for=\"txtEmail\">E-mail</label>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-floating mb-3\">\n");
      out.write("                        <input type=\"password\" class=\"form-control\" autofocus id=\"psswd\" placeholder=\" \" name=\"senha\">\n");
      out.write("                        <label for=\"psswd\">Senha</label>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"form-check mb-3\">\n");
      out.write("                        <input type=\"checkbox\" class=\"form-check-input\" value=\"\" id=\"chkLembrar\"\n");
      out.write("                        <label> for=\"chkLembrar\" class=\"form-check-input\">Lembrar de mim</label>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <button class=\"btn btn-lg start-100\" type=\"button\" style=\"background: #EFEFEF;\"><a href=\"./loginuser.html\">Entrar</a></button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("                    \n");
      out.write("                    <h3>Não é cadastrado? <a href=\"#\">Cadastre-se agora</a></h3>\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("    <footer class=\"mt-10 border-top fixed-bottom text-muted bg-light\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row py-3\">\n");
      out.write("                <div class=\"col-12 col-md-4 text-center text-md-left\">\n");
      out.write("                    &copy; 2022 - SMD Commerce: By Douglas Lima\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"\n");
      out.write("        integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js\"\n");
      out.write("        integrity=\"sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF\"\n");
      out.write("        crossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
