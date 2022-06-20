package smdecommerce.produto.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.produto.modelo.ProdutoDAO;

/**
 * Inserir novo produto
 *
 * @author Douglas Lima
 */
public class NovoProdutoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));

        ProdutoDAO produtoDAO = new ProdutoDAO();
        boolean inseriu = false;
        String mensagem = null;
        try {
            produtoDAO.inserir(descricao, preco, quantidade, categoria_id);
            inseriu = true;
            mensagem = "Cliente inserido com sucesso";
        } catch (Exception ex) {
            inseriu = false;
            mensagem = ex.getMessage();
        }

        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarProduto.jsp");
        requestDispatcher.forward(request, response);
    }
}
