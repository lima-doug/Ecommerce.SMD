package smdecommerce.usuario.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import smdecommerce.usuario.modelo.Usuario;
import smdecommerce.usuario.modelo.UsuarioDAO;

/**
 *
 * @author Douglas Lima
 */
public class LoginClienteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = null;
        boolean sucesso = false;
        String mensagem = null;
        try {
            usuario = usuarioDAO.obter(login);
            if (usuario.getSenha().equals(senha)) {
                sucesso = true;
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
            } else {
                mensagem = "Login ou senha inválida";
                sucesso = false;
            }
        } catch (Exception ex) {
            sucesso = false;
            mensagem = ex.getMessage();
        }
        if (sucesso && usuario.getAdministrador() == false) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("InicioClient");
            requestDispatcher.forward(request, response);
        }else if(sucesso && usuario.getAdministrador() == true){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminPrincipal.jsp");
            requestDispatcher.forward(request, response);
        } 
        else {
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
