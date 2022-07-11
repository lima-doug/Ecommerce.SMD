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


public class ListarVendasServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                VendasDAO vendasDAO = new VendasDAO();
                List<Vendas> vendas = null;
                try{
                    vendas = vendasDAO.obterVendas();
                } catch (Exception ex){
                    request.setAttribute("mensagem", ex.getMessage());
                }
                    request.setAttribute("vendas", vendas);
                    
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarVendas.jsp");
                    requestDispatcher.forward(request, response);
        }
    }

