<%-- 
    Document   : carrinhosCompra
    Created on : 21 de mai. de 2022, 16:31:18
    Author     : Douglas Lima
--%>

<%@page import="smdecommerce.compras.modelo.CarrinhoCompraItem"%>
<%@page import="java.util.List"%>
<%@page import="smdecommerce.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <nav class="navbar navbar-expand-lg navbar-dark border-bottom shadow-sm mb-3">
            <div class="container">
                <a class="navbar-brand text-dark" href="index.jsp"><strong>SMD Commerce</strong></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="navbar-collapse collapse text-dark">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item me-4">
                            <a href="./index.html" class="nav-link text-dark">Home</a>
                        </li>
                        <li class="nav-item me-4">
                            <a href="produtos.html" class="nav-link text-dark">Produtos</a>
                        </li>
                        <li class="nav-item me-4">
                            <a href="#" class="nav-link text-dark">Sobre</a>
                        </li>
                    </ul>

                    <div class="align-self-end">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a href="./login.html" class="text-dark btn btn-secondary text-white" role="button">Entrar</a>
                            </li>

                            <li class="nav-item">
                                <a href="./cadastro_c.html" class="text-dark btn  ">Criar conta</a>
                            </li>

                            <li class="nav-item">
                                <a href="./compras.html" class="nav-link text-dark">
                                    <img src="./icons/shopping--cart 1.png" alt="">
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>


        <main>
            <div class="container">
                <h1>Carrinho de compras</h1>
                <hr>

                <ul class="list-group mb-3">
                    <%
            List<CarrinhoCompraItem> carrinhoCompraItens = (List<CarrinhoCompraItem>) request.getAttribute("carrinhoCompraItens");
            if (carrinhoCompraItens == null || carrinhoCompraItens.size() == 0) {
                    %>
                    <li class="list-group-item py-3"><h4>Não existem produtos no seu carrinho de compra</h4></li>
                        <%
                        } else {
                            double total = 0;
                            for (int i = 0; i < carrinhoCompraItens.size(); i++) {
                                CarrinhoCompraItem carrinhoCompraItem = carrinhoCompraItens.get(i);                    
                        %>
                    <li class="list-group-item py-3">
                        <div class="row g-3">
                            <div class="col-4 col-md-3 col-lg-2">
                                <div class="img-thumbnail">
                                    <%= (carrinhoCompraItem.getProduto().getFoto() == null) ? "Sem Foto" : "<img src=\"ExibirProdutoFoto?id=" + carrinhoCompraItem.getProduto().getId() + "\" />" %>
                                </div>
                            </div>
                            <div class="col-8 col-md-9 col-lg-7 col-xl-8 text-left align-self-center">
                                <h4><a href="#" class="text-decoration-none text-dark"><%= carrinhoCompraItem.getProduto().getDescricao()%></a></h4>
                                <small><%= carrinhoCompraItem.getProduto().getPreco()%></small>
                            </div>
                            <div class="col-6 offset-6 col-sm-6 offset-sm-6
                                 col-md-4 offset-md-8 col-lg-3 offset-lg-0 col-xl-2 align-self-center mt-3">
                                <div class="input-group">
                                    <button type="button" class="btn btn-outline-dark btn-sm" onclick=" ">
                                        <svg class="bi" width="16" height="16" fill="currentColor">
                                        <use xlink:href="./icons/bi.svg#caret-down"/>
                                        </svg>
                                    </button>
                                        
                                    <input type="text" class="form-control text-center border-dark" value="<%=carrinhoCompraItem.getProduto().getQuantidade()%>">
                                    
                                    <button type="button" class="btn btn-outline-dark btn-sm" onclick=" ">
                                        <svg class="bi" width="16" height="16" fill="currentColor">
                                        <use xlink:href="./icons/bi.svg#caret-up"/>
                                        </svg>
                                    </button>
                                    <button type="button" class="btn btn-sm btn-outline-danger border-dark" onclick="RemoverProdutoCarrinhoCompra?produtoId = <%= carrinhoCompraItem.getProduto().getId()%>">
                                        <svg class="bi" width="16" height="16" fill="currentColor">
                                        <use xlink:href="./icons/bi.svg#trash"/>
                                        </svg>
                                    </button>
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
                            <a href="./index.html" class="btn btn-secondary btn-lg">Continuar comprando</a>
                            <button class="btn btn-lg btn-success" >Finalizar </button>
                        </div>
                    </li>
                </ul>
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