
<%@page import="smdecommerce.compras.modelo.CarrinhoCompraItem"%>
<%@page import="java.util.List"%>
<%@page import="smdecommerce.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header-menu.jsp" %>

<main>
    <div class="container">
        <h1>Carrinho de Compras</h1>
        <hr>
        <form action="ConcluirVenda" method="post">
            <ul class="list-group mb-3">
                <%
                    List<CarrinhoCompraItem> carrinhoCompraItens = (List<CarrinhoCompraItem>) request.getAttribute("carrinhoCompraItens");
                    if (carrinhoCompraItens == null || carrinhoCompraItens.size() == 0) {
                %>
                <li class="list-group-item py-3 h4">Não existem produtos no seu carrinho de compras</li>
                    <%
                    } else {
                        double total = 0;
                        for (int i = 0; i < carrinhoCompraItens.size(); i++) {
                            CarrinhoCompraItem carrinhoCompraItem = carrinhoCompraItens.get(i);
                    %>
                <li class="list-group-item py-3">
                    <div class="row g-3">
                        <div class="col-8 col-md-9 col-lg-7 col-xl-8 text-left align-self-center">
                            <div class="h4 text-dark"><%= carrinhoCompraItem.getProduto().getDescricao()%></div>
                            <small><%= carrinhoCompraItem.getProduto().getPreco()%></small>
                        </div>
                        <div class="col-6 offset-6 col-sm-6 offset-sm-6
                             col-md-4 offset-md-8 col-lg-3 offset-lg-0 col-xl-2 align-self-center mt-3">
                            <div class="input-group">
                                <a href="AdicionarCompra?produtoId=<%= carrinhoCompraItem.getProduto().getId()%>">
                                    <span class="iconify" data-icon="mdi:plus" style="color: #6c757d; width: 24px; height: 24px;"></span>
                                </a>
                                <div class="h5">Quantidade: <%= carrinhoCompraItem.getQuantidade()%></div>
                                <a class="color-outline-danger" href="RemoverProdutoCarrinhoCompra?produtoId=<%= carrinhoCompraItem.getProduto().getId()%>">
                                    <span class="iconify" data-icon="gridicons:trash" style="color: red; width: 24px; height: 24px;"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </li>
                <%
                total += carrinhoCompraItem.getProduto().getPreco() * carrinhoCompraItem.getQuantidade();
                if (i < carrinhoCompraItens.size() - 1) {
                    out.println("<br/>");
                }
            }
                %>
                <li class="list-group-item py-3">
                    <div class="text-right">
                        <h4 class="text-dark mb-3">Valor Total: R$ <%= total%></h4>
                    </div>
                </li>
                <%
        }
                %>
                <li class="list-group-item py-3">
                    <div class="text-right">
                        <a href="Inicio" class="btn btn-secondary btn-lg">Continuar comprando</a>
                        <button type="submit" class="btn btn-lg btn-success" >Finalizar </button>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</main>

<%@include file="footer.jsp" %>