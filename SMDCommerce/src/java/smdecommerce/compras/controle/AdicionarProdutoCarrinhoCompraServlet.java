package smdecommerce.compras.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.compras.modelo.CarrinhoCompra;


public class AdicionarProdutoCarrinhoCompraServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));
        /* processamento */
        Cookie cookie = CarrinhoCompra.obterCookie(request);
        String novoValor = CarrinhoCompra.adicionarItem(produtoId, 1, cookie.getValue());
        cookie.setValue(novoValor);
        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("CarrinhoCompraPage");
        requestDispatcher.forward(request, response);
    }

}
    
