<%@page import="smdecommerce.venda.modelo.Vendas"%>
<%@include file="header-menu.jsp" %>

<div class="container">
    <div class="row">    
    <h3 class="col-9">Minhas Compras</h3>
    
</div>
    <%
        List<Vendas> compras = (List<Vendas>) request.getAttribute("compras");
        if (compras != null && !compras.isEmpty()) {
%>

    <table>
        <tr>
            <td><b>Número de pedido</b></td>
            <td><b>Produto</b></td>
            <td><b>Preço</b></td>
            <td><b>Quantidade</b></td>
            <td><b>Valor Total</b></td>
            <td>&nbsp;</td>
        </tr>
        <%
            for (Vendas cc : compras) {   
        %>
        <tr>
            
            <td><%= cc.getId()%></td>
            <td><%= cc.getNome_produto()%></td>
            <td><%= cc.getPreco()%></td>
            <td><%= cc.getQuantidade()%></td>
            <td><%= cc.getPreco()*cc.getQuantidade()%></td>

        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
    <div>Não foram feitas compras</div>
    <%
        }
    %>
</div>
<%@include file="footer.jsp" %>