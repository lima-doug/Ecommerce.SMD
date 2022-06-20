<%@page import="smdecommerce.categoria.modelo.Categoria"%>
<%@include file="header-menu-admin.jsp" %>

<div class="container">
<div class="row">    
    <h3 class="col-9">Cadastro de Categoria</h3>
    <a class="btn btn-secondary text-white col-2 align-items-end" style="" href="criarCategoria.jsp">Criar Categoria</a>
</div>
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
        <td><a class="btn btn-success" href="MostraCategoria?id=<%= c.getId()%>">Editar</a></td>
        <td><a class="btn col- btn-lg btn-outline-danger" href="DeleteCategoria?id=<%= c.getId()%>">Excluir<a></td>
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

<%@include file="footer.jsp" %>
