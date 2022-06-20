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
public class InicioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
        request.setAttribute("Produtos disponíveis", produtosDisponiveis);
        
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
        List<CarrinhoCompraItem> carrinhoCompraItens = CarrinhoCompra.obterCarrinhoCompras(cookie.getValue());
        request.setAttribute("carrinhoCompraItens", carrinhoCompraItens);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}