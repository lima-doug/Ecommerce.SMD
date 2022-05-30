package smdecommerce.usuario.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import smdecommerce.usuario.modelo.UsuarioDAO;


/**
 * Classe que implementa ação de inserir novo usuário do tipo cliente
 * @author Douglas Lima
 */


public class NovoClienteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean administrador = false;
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean inseriu = false;
        String mensagem = null;
        try {
            usuarioDAO.inserir(nome, endereco, email, login, senha, administrador);
            inseriu = true;
            mensagem = "Cliente inserido com sucesso";
        } catch (Exception ex) {
            inseriu = false;
            mensagem = ex.getMessage();
        }
    
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request, response);
    }
}
