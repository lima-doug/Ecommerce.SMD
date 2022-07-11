<%@page import="smdecommerce.produto.modelo.Produto"%>
<%@include file="header-menu-admin.jsp" %>

<div class="container">
    <div class="row">    
    <h3 class="col-9">Cadastro de Produtos</h3>
    <a class="btn btn-secondary text-white col-2 align-items-end" style="" href="cadastroProduto.jsp">Cadastrar Produto</a>
</div>
    <%
        List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
        if (produtos != null && !produtos.isEmpty()) {
%>
   
    <table>
        <tr>

            <td><b>Descrição</b></td>
            <td><b>Preço</b></td>
            <td><b>Quantidade</b></td>
            <td><b>Categoria</b></td>
            <td>&nbsp;</td>
        </tr>
        <%
            for (Produto p : produtos) {   
        %>
        <tr>

            <td><%= p.getDescricao() %></td>
            <td><%= p.getPreco() %></td>
            <td><%= p.getQuantidade() %></td>
            <td><%= p.getCategoria() %></td>
            <td><a class="btn btn-success" href="MostrarProduto?id=<%= p.getId()%>">Editar</a></td>
            <td><a class="btn col- btn-lg btn-outline-danger" href="DeletaProduto?id=<%= p.getId()%>">Excluir<a></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <div>Não foram encontrados produtos</div>
    <%
        }
    %>
</div>
<%@include file="footer.jsp" %>