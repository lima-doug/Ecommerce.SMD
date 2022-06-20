package smdecommerce.usuario.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.usuario.modelo.UsuarioDAO;


/**
 * Classe que implementa ação de atualizar novo usuário do tipo cliente
 * @author Douglas Lima
 */


public class DeleteUsuarioServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean delete = false;
        String mensagem = null;
        
        try {
            usuarioDAO.delete(id);
            delete = true;
            mensagem = "Usuario deletado com sucesso";
        } catch (Exception ex) {
            delete = false;
            mensagem = ex.getMessage();
        }
        
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }
}
