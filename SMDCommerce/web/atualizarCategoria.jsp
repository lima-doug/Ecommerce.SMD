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
    Categoria c = (Categoria) request.getAttribute("categoria");
    if (c != null) {
%>
    <div class="container">
        <a href="listarCategorias.jsp">Voltar</a>
        <div class="row justify-content-center">
            <form class="col-sm-10 col-md-8 col-lg-6" action="AtualizarCategoria" method="post">
                <input type="hidden" name="id" value="<%= c.getId() %>" />
                <h1 class="my-4">Atualizar categoria</h1>                    

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" autofocus id="txtCategoria" name="descricao" value="<%= c.getDescricao() %>">
                    <label for="txtCategoria">Nova categoria</label>
                </div>
                <div class="mb-3 text-end">
                    <a class="btn btn-outline-danger" href="ListarCategoria" role="button">Cancelar</a>
                    <input type="submit" value="Salvar" class="btn btn-danger">
                </div>
            </form>
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