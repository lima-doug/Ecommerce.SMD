package smdecommerce.compras.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import smdecommerce.compras.modelo.CarrinhoCompra;

/**
 *
 * @author Douglas Lima
 */
public class AdicionarProdutoCarrinhoCompraServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));
        Cookie cookie = CarrinhoCompra.obterCookie(request);
        String novoValor = null;
        try {
            novoValor = CarrinhoCompra.adicionarItem(produtoId, 1, cookie.getValue());
        } catch (Exception ex) {
            Logger.getLogger(AdicionarProdutoCarrinhoCompraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        cookie.setValue(novoValor);
        
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Início");
        requestDispatcher.forward(request, response);

    }
}
