package smdecommerce.compras.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.compras.modelo.CarrinhoCompra;

/**
 *
 * @author Douglas Lima
 */
public class RemoverProdutoCarrinhoCompraServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));
        Cookie cookie = CarrinhoCompra.obterCookie(request);
        String novoValor = CarrinhoCompra.removerItem(produtoId, cookie.getValue());
        cookie.setValue(novoValor);
        
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("CarrinhoCompraPage");
        requestDispatcher.forward(request, response);

    }

}
