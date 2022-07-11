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


public class AtualizarUsuarioServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean atualizou = false;
        String mensagem = null;
        
        try {
            usuarioDAO.atualizar(nome, endereco, email, login, senha, id);
            atualizou = true;
            mensagem = "Cliente atualizado com sucesso";
        } catch (Exception ex) {
            atualizou = false;
            mensagem = ex.getMessage();
        }
        
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Inicio");
        requestDispatcher.forward(request, response);
    }
}
