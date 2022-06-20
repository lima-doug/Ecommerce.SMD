package smdecommerce.categoria.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import smdecommerce.categoria.modelo.CategoriaDAO;

/**
 *
 * @author Douglas Lima
 */
public class NovaCategoriaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        boolean inseriu = false;
        String mensagem = null;
        try {
            categoriaDAO.inserir(descricao);
            inseriu = true;
            mensagem = "Categorias inserida com sucesso";
        } catch (Exception ex) {
            inseriu = false;
            mensagem = ex.getMessage();
        }
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarCategorias.jsp");
        requestDispatcher.forward(request, response);
    }

}
