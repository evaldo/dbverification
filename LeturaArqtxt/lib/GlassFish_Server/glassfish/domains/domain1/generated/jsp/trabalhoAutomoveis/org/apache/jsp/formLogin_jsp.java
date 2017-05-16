package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class formLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Acesso ao Sistema</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script language=\"JavaScript\">            \n");
      out.write("            function logar(){\n");
      out.write("                login = document.cadastro.login.value\n");
      out.write("                senha = document.cadastro.senha.value\n");
      out.write("                if((login==\"usuario1\" && senha ==\"u1\") || (login==\"usuario2\" && senha ==\"u2\" )|| (login==\"usuario3\" && senha ==\"u3\")) {\n");
      out.write("                    return true\n");
      out.write("                }\n");
      out.write("                else if(login ==\"\" || senha ==\"\"){\n");
      out.write("                    document.getElementById(\"msgsenha\").innerHTML=\"<font color='Red'> FAVOR PREENCHER OS CAMPOS OBRIGATÓRIOS!</font>\";\n");
      out.write("                    return false\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    document.getElementById(\"msgsenha\").innerHTML=\"<font color='Red'> Senha Incorreta!</font>\";\n");
      out.write("                    return false\n");
      out.write("                }\n");
      out.write("            }  \n");
      out.write("           \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("            <h1>Autenticação</h1>\n");
      out.write("        <form name=\"cadastro\" action=\"index.jsp\" method=\"post\" onSubmit=\"return logar()\">\n");
      out.write("            \n");
      out.write("            Login: <input type=\"text\" name=\"login\" size=\"20\"> <p>     \n");
      out.write("            Senha: <input type=\"password\" name=\"senha\" size=\"20\"><p>   \n");
      out.write("            <input type=\"submit\" value=\"Enviar\">\n");
      out.write("           </form>\n");
      out.write("            \n");
      out.write("            <div id=\"msgsenha\"></div> \n");
      out.write("            </center>\n");
      out.write("    </body>\n");
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
