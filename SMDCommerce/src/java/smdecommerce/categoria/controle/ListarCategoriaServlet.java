package smdecommerce.categoria.controle;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import smdecommerce.categoria.modelo.Categoria;
import smdecommerce.categoria.modelo.CategoriaDAO;

/**
 *
 * @author Leonardo Oliveira Moreira
 *
 * Classe que implementa a ação de listar todos as categorias
 */
public class ListarCategoriaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* processamento */
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = null;
        try {
            categorias = categoriaDAO.obterCategorias();
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        request.setAttribute("categorias", categorias);
        /* saída */
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listarCategorias.jsp");
        requestDispatcher.forward(request, response);
    }

}
