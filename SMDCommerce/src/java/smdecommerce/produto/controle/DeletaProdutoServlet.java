package smdecommerce.produto.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.produto.modelo.ProdutoDAO;


/**
 * Classe que implementa ação de atualizar novo usuário do tipo cliente
 * @author Douglas Lima
 */


public class DeletaProdutoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        boolean delete = false;
        String mensagem = null;
        
        try {
            produtoDAO.delete(id);
            delete = true;
            mensagem = "Categoria deletada com sucesso";
        } catch (Exception ex) {
            delete = false;
            mensagem = ex.getMessage();
        }
        
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProduto");
        requestDispatcher.forward(request, response);
    }
}
