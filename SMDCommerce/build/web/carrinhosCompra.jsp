
<%@page import="smdecommerce.compras.modelo.CarrinhoCompraItem"%>
<%@page import="java.util.List"%>
<%@page import="smdecommerce.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="smdecommerce.usuario.modelo.Usuario"%>

<jsp:useBean id='usuario' class="smdecommerce.usuario.modelo.Usuario" scope="session"/>

<!doctype html>
<html lang="pt-br">

    <head>
        <title>Carrinho de Compras</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body style="min-width:372px;">
        <% 
            if(usuario == null || usuario.getId() == null){
        %>
        <div class="container h3">
            <div class="input-group">
                <span class="iconify" data-icon="topcoat:back"></span>
                <a class="btn bg-transparent" href="Inicio" style="font-size: 24px;">Voltar</a>
            </div>
        </div>
        <%
            }else{
        %>
        <div class="container">
            <a class=" btn bg-transparent align-items-center" href="InicioClient" style="font-size: 24px;"><span class="iconify" data-icon="topcoat:back"></span>Voltar</a>
        </div>
        <%
            }
        %>

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
                            <input type="hidden" name="userc_id" value="<%= usuario.getId()%>">
                            <input type="hidden" name="produto_id" value="<%= carrinhoCompraItem.getProduto().getId()%>">
                            <input type="hidden" name="quantidade" value="<%= carrinhoCompraItem.getQuantidade()%>">
                            
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
                                <% 
                                if(usuario == null || usuario.getId() == null){
                                %>
                                <a href="login.jsp" class="btn btn-lg btn-success" >Continuar </a>
                                <%
                                    }else{
                                %>
                                <input type="submit" class="btn btn-lg btn-success" value="Finalizar">
                                <%
                                    }
                                %>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </main>

        <footer class="mt-10 border-top text-muted bg-light">
            <div class="container">
                <div class="row py-3">
                    <div class="col-12 col-md-4 text-center text-md-left">
                        &copy; 2022 - SMD Commerce: By Douglas Lima
                    </div>
                </div>
            </div>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
                integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
                integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
        <script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>
    </body>

</html>