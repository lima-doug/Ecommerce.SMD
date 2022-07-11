package smdecommerce.venda.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import smdecommerce.venda.modelo.VendasDAO;
import smdecommerce.venda.modelo.Vendas;

public class ListarComprasClienteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
        
        VendasDAO vendasDAO = new VendasDAO();
        List<Vendas> compras = null;
        try {
            compras = vendasDAO.obterCompras(usuarioId);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.setAttribute("compras", compras);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarCompras.jsp");
        requestDispatcher.forward(request, response);

    }
}
