package smdecommerce.produto.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.produto.modelo.ProdutoDAO;

public class AtualizarProdutoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));

        ProdutoDAO produtoDAO = new ProdutoDAO();
        boolean atualizou = false;
        String mensagem = null;

        try {
            produtoDAO.atualizar(descricao, preco, quantidade, categoria_id, id);
            atualizou = true;
            mensagem = "Produto atualizado com sucesso";
        } catch (Exception ex) {
            atualizou = false;
            mensagem = ex.getMessage();
        }

        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarProduto");
        requestDispatcher.forward(request, response);
    }
}
