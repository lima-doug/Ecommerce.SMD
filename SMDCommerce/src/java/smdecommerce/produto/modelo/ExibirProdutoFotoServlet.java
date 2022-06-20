package smdecommerce.produto.modelo;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExibirProdutoFotoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = null;
        try {
            produto = produtoDAO.obter(id);
        } catch (Exception ex) {
            produto = null;
        }
        if (produto != null && produto.getFoto() != null && produto.getFoto().trim().length() > 0) {
            File arquivoFoto = new File(produto.getFoto());
            if (arquivoFoto.exists()) {
                ServletContext context = this.getServletContext();
                String mimeType = context.getMimeType(arquivoFoto.getAbsolutePath());
                if (mimeType == null) {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }
                response.setContentLengthLong(arquivoFoto.length());
                response.setContentType(mimeType);
                FileInputStream in = new FileInputStream(arquivoFoto);
                OutputStream out = response.getOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                in.close();
                out.close();
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
    }

}