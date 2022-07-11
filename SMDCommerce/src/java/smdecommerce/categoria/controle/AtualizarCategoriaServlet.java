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


public class AtualizarCategoriaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        boolean atualizou = false;
        String mensagem = null;
        
        try {
            categoriaDAO.atualizar(descricao, id);
            atualizou = true;
            mensagem = "Categoria atualizada com sucesso";
        } catch (Exception ex) {
            atualizou = false;
            mensagem = ex.getMessage();
        }
        
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarCategoria");
        requestDispatcher.forward(request, response);
    }
}
