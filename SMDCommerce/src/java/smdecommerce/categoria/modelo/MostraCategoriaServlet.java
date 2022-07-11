package smdecommerce.categoria.modelo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MostraCategoriaServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* entrada */
        int id = Integer.parseInt(request.getParameter("id"));
        /* processamento */
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = null;
        try {
            categoria = categoriaDAO.obter(id);
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.setAttribute("categoria", categoria);
        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("atualizarCategoria.jsp");
        requestDispatcher.forward(request, response);
    }

}
