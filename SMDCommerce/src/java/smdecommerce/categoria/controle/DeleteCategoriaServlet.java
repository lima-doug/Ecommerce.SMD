package smdecommerce.categoria.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.categoria.modelo.CategoriaDAO;


/**
 * Classe que implementa ação de atualizar novo usuário do tipo cliente
 * @author Douglas Lima
 */


public class DeleteCategoriaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        boolean delete = false;
        String mensagem = null;
        
        try {
            categoriaDAO.delete(id);
            delete = true;
            mensagem = "Categoria deletada com sucesso";
        } catch (Exception ex) {
            delete = false;
            mensagem = ex.getMessage();
        }
        
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarCategorias.jsp");
        requestDispatcher.forward(request, response);
    }
}
