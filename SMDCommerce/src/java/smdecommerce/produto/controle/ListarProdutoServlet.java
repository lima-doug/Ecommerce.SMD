package smdecommerce.produto.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import smdecommerce.produto.modelo.Produto;
import smdecommerce.produto.modelo.ProdutoDAO;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe que implementa a ação de listar todos os produtos
 */
public class ListarProdutoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* processamento */
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = null;
        try {
            produtos = produtoDAO.obterProdutos();
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.setAttribute("produtos", produtos);
        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarProduto.jsp");
        requestDispatcher.forward(request, response);
    }

}
