package smdecommerce.venda.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.venda.modelo.VendasDAO;

public class ConcluirVendaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userc_id = Integer.parseInt(request.getParameter("userc_id"));
        int produto_id = Integer.parseInt(request.getParameter("produto_id"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        VendasDAO vendasDAO = new VendasDAO();
        boolean inseriu = false;
        String mensagem = null;
        try {
            vendasDAO.inserir(userc_id, produto_id, quantidade);
            inseriu = true;
            mensagem = "Venda concluida com sucesso";
        } catch (Exception ex) {
            inseriu = false;
            mensagem = ex.getMessage();
        }

        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("InicioClient");
        requestDispatcher.forward(request, response);
    }
}
