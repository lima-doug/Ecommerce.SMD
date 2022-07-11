package smdecommerce.venda.controle;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.venda.modelo.VendasDAO;

/**
 *
 * @author Douglas Lima
 */
public class ExcluirVendaServlet extends HttpServlet {
@Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        VendasDAO vendasDAO = new VendasDAO();
        boolean delete = false;
        String mensagem = null;
        
        try {
            vendasDAO.delete(id);
            delete = true;
            mensagem = "Venda cancelada com sucesso";
        } catch (Exception ex) {
            delete = false;
            mensagem = ex.getMessage();
        }
        
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarVendas");
        requestDispatcher.forward(request, response);
    }
}
