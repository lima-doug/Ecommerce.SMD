package smdecommerce.inicio.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import smdecommerce.compras.modelo.CarrinhoCompra;
import smdecommerce.compras.modelo.CarrinhoCompraItem;
import smdecommerce.produto.modelo.Produto;
import smdecommerce.produto.modelo.ProdutoDAO;

/**
 *
 * @author Douglas Lima
 */
public class InicioClientServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtosDisponiveis = null;
        try {
            produtosDisponiveis =produtoDAO.obterProdutosEmEstoque();
        } catch (Exception ex) {
            produtosDisponiveis = new ArrayList<>();
        }
        request.setAttribute("produtosDisponiveis", produtosDisponiveis);
        
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int i=0; cookies != null && i < cookies.length;  i++){
            if (cookies[i].getName().equals(CarrinhoCompra .CHAVE_COOKIE_CARRINHO_COMPRA)){
                cookie = cookies[i];
                break;
            }
        }
        if (cookie == null){
            cookie = new Cookie(CarrinhoCompra.CHAVE_COOKIE_CARRINHO_COMPRA, "");
        }
        
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
        List<CarrinhoCompraItem> carrinhoCompraItens = CarrinhoCompra.obterCarrinhoCompra(cookie.getValue());
        request.setAttribute("carrinhoCompraItens", carrinhoCompraItens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("principalCliente.jsp");
        requestDispatcher.forward(request, response);
    }
}