package smdecommerce.produto.modelo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostrarProdutoFotoServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        int id = Integer.parseInt(request.getParameter("id"));
        /* processamento */
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = null;
        try {
            produto = produtoDAO.obter(id);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.setAttribute("produto", produto);
        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("uploadProduto.jsp");
        requestDispatcher.forward(request, response);
    }

}
