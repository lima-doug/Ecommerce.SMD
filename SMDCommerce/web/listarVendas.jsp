<%@page import="smdecommerce.venda.modelo.Vendas"%>
<%@include file="header-menu-admin.jsp" %>

<div class="container">
    <div class="row">    
    <h3 class="col-9">Relatorio de Vendas</h3>
</div>
    <%
        List<Vendas> vendas = (List<Vendas>) request.getAttribute("vendas");
        if (vendas != null && !vendas.isEmpty()) {
%>
   
    <table>
        <tr>
            <td><b>Identificação Venda</b></td>
            <td><b>Usuario</b></td>
            <td><b>Produto</b></td>
            <td><b>Quantidade</b></td>
            <td><b>Preço</b></td>
            <td><b>Valor Total</b></td>
            <td>&nbsp;</td>
        </tr>
        <%
            for (Vendas v : vendas) {   
        %>
        <tr>
            <td><%= v.getId()%></td>
            <td><%= v.getNome_usuario()%></td>
            <td><%= v.getNome_produto() %></td>
            <td><%= v.getQuantidade() %></td>
            <td><%= v.getPreco()%></td>
            <td><%= v.getPreco()*v.getQuantidade()%></td>
            <td><a class="btn col- btn-lg btn-outline-danger" href="ExcluirVenda?id=<%= v.getId()%>">Excluir<a></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <div>Não foram feitas vendas</div>
    <%
        }
    %>
</div>
<%@include file="footer.jsp" %>