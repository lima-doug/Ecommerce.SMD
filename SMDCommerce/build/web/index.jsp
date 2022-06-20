<%-- 
    Document   : index
    Created on : 20 de mai. de 2022, 23:15:19
    Author     : Douglas Lima
--%>

<%@page import="smdecommerce.compras.modelo.CarrinhoCompraItem"%>
<%@page import="java.util.List"%>
<%@page import="smdecommerce.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">

<head>
    <title>SMD Commerce</title>
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
                            <a href="index.jsp" class="nav-link text-dark">Home</a>
                        </li>
                        <li class="nav-item me-4">
                            <a href="produtos.jsp" class="nav-link text-dark">Produtos</a>
                        </li>
                        <li class="nav-item me-4">
                            <a href="#" class="nav-link text-dark">Sobre</a>
                        </li>
                    </ul>

                    <div class="align-self-end">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a href="login.jsp" class="btn btn-secondary text-white" role="button">Entrar</a>
                            </li>

                            <li class="nav-item">
                                <a href="novoCliente.jsp" class="text-dark btn  ">Criar conta</a>
                            </li>

                            <li class="nav-item">
                                <a href="carrinhosCompra.jsp" class="nav-link text-dark">
                                    <span class="iconify" data-icon="bi:cart-fill" style="color: #6c757d; width: 24px; height: 24px;"></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

    <br><br>
        <header>

            <div class="container border-0 card h-400 flex-row col-12 justify-content-center align-items-center"
                 style="height: 400px; background-color: blueviolet;">
                <div class="card-body col-5">
                    <h2 class="card-title">Lorem ipsum dolor si ame</h2>
                </div>
                <div class="card-body col-7 ">
                    <img class="img-fluid card-img d-block d-md-block" src="./images/SM-placeholder.png" alt="">
                </div>
            </div>

            <div class="container card mt-2 p-0 border-0 card h-300 flex-row col-12 justify-content-center gap-1 "
                 style="height: 300px;">
                <div class="h-100 col-7" style="background-color: #EFEFEF;">
                    <h2 class="m-4">Lorem ipsum dolor si ame</h2>
                </div>
                <div class="h-100 col-5" style="background-color: #EFEFEF;">
                    <h3 class="m-4">Lorem ipsum dolor si ame</h3>
                </div>
            </div>

        </header>

    <%@include file="productMain.jsp" %>
    
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
