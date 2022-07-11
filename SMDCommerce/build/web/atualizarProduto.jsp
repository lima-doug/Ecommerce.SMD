<%-- 
    Document   : login
    Created on : 19 de mai. de 2022, 23:58:15
    Author     : Douglas Lima
--%>
<%@page import="smdecommerce.categoria.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header-menu-admin.jsp"%>
<main>
    <%
    Produto p = (Produto) request.getAttribute("produto");
    if (p != null) {
    %>
    <div class="container">
        <a href="listarProduto.jsp">Voltar</a>
        <div class="row justify-content-center">
            <form class="col-sm-10 col-md-8 col-lg-6" action="AtualizarProduto" method="post">
                <input type="hidden" name="id" value="<%= p.getId() %>" />
                <h1 class="my-4">Atualizar Produto</h1>                    

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" autofocus id="txtDescricao" name="descricao" value="<%= p.getDescricao() %>">
                    <label for="txtDescricao">Descrição</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" autofocus id="txtPreco" name="preco" value="<%= p.getPreco() %>">
                    <label for="txtPreco">Preço</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" autofocus id="txtQuantidade" name="quantidade" value="<%= p.getQuantidade() %>">
                    <label for="txtQuantidade">Quantidade</label>                    
                </div>

                <div class="form-floating mb-3">
                    <div class="input-group">
                        <input type="text" class="form-control" autofocus id="txtCategoria" name="categoria_id" value="<%= p.getCategoria() %>">
                        <label for="txtCategoria">Digite o id da categoria</label>
                        <button type="button" class="bg-transparent btn" data-bs-toggle="modal" data-bs-target="#modalCategoria"><span class="iconify" data-icon="icon-park-solid:eyes" style="color: #6c757d; width: 24px; height: 24px;"></span></button>

                    </div>
                </div>

                <div class="mb-3 text-end">
                    <a class="btn btn-outline-danger" href="ListarProduto" role="button">Cancelar</a>
                    <input type="submit" value="Salvar" class="btn btn-danger">
                </div>
            </form>

            <!-- Modal Cat. -->
            <div class="modal fade" id="modalCategoria" tabindex="-1" aria-labelledby="modalCategoriaLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="categoriaModalLabel">Categorias</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    if (categorias != null && !categorias.isEmpty()) {
                            %>
                            <table>
                                <tr>
                                    <td><b>Id</b></td>
                                    <td><b>Categoria</b></td>
                                    <td>&nbsp;</td>
                                </tr>
                                <%
                                    for (Categoria c : categorias) {
                                %>
                                <tr>
                                    <td><%= c.getId() %></td>
                                    <td><%= c.getDescricao()%></td>
                                </tr>
                                <%
                                    }
                                %>
                            </table>
                            <%
                                } else {
                            %>
                            <div>Não foram encontradas categorias</div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>

            <%
} else {
            %>
            <div>Não foi encontrado o produto</div>
            <%
                }
            %>
        </div>
    </div>
</main>

<%@include file="footer.jsp" %>