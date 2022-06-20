<%@page import="smdecommerce.produto.modelo.Produto"%>

<%@include file="header-menu-admin.jsp" %>

<div class="container">
    <h3>Cadastro de Produtos</h3>
    <%
        List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
        if (produtos != null && !produtos.isEmpty()) {
    %>
    <table>
        <tr>
            <td><b>Foto</b></td>
            <td><b>Descrição</b></td>
            <td><b>Preço</b></td>
            <td><b>Quantidade</b></td>
            <td>&nbsp;</td>
        </tr>
        <%
            for (Produto p : produtos) {
        %>
        <tr>
            <td><%= (p.getFoto() == null) ? "Sem Foto" : "<img src=\"ExibirProdutoFoto?id=" + p.getId() + "\" />" %></td>
            <td><%= p.getDescricao() %></td>
            <td><%= p.getPreco() %></td>
            <td><%= p.getQuantidade() %></td>
            <td><a href="MostrarProdutoFoto?id=<%= p.getId() %>">Atualizar Foto</a></td>
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