<%-- 
    Document   : paginaProduto
    Created on : 21 de mai. de 2022, 16:33:00
    Author     : Douglas Lima
--%>

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
            <a class="navbar-brand text-dark" href="/"><strong>SMD Commerce</strong></a>
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

    <br><br>
    <head >
        <div class="row bg-transparent mx-4 gap-4 justify-content-center align-items-center" >
            <div class="col-5 ">
                <img class="img-fluid card-img d-block d-md-block" src="./images/SM-placeholder.png" alt="">
            </div>
            <div class="card col-5 text-end border-0">
                <div class="card-header bg-transparent">
                    <h2 class="card-title">Lorem ipsum dolor si ame</h2>
                </div>
                <div class="card-body align-items-end">
                    <h3 class="mt-2">R$ 30,00</h3>
                    <p> Item description</p>
                </div>
                <div class="card-footer bg-transparent">
                    <form class="d-block">
                        <button class="btn" style="font-size: 16; background:#EFEFEF;">
                            Adicionar ao Carrinho
                        </button>
                    </form>
                </div>
            </div>  
        </div>
    </head>

    <footer class="mt-10 border-top text-muted position-absolute fixed-bottom bg-light">
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
</body>

</html>
