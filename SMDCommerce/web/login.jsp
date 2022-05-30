<%-- 
    Document   : login
    Created on : 19 de mai. de 2022, 23:58:15
    Author     : Douglas Lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">

<head>
    <title>Login</title>
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
                            <a href="login.jsp" class="text-dark btn btn-secondary text-white" role="button">Entrar</a>
                        </li>

                        <li class="nav-item">
                            <a href="novoCliente.jsp" class="text-dark btn  ">Criar conta</a>
                        </li>

                        <li class="nav-item">
                            <a href="carrinhoCompra.jsp" class="nav-link text-dark">
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
            <div class="row justify-content-center">
                <form class="col-sm-10 col-md-8 col-lg-6" action="LoginCliente" method="post">
                    <h1 class="my-4">Login</h1>                    
                    <hr>
                    <% if(request.getAttribute("mensagem") != null) { %>
                    <div><%= request.getAttribute("mensagem")%></div>
                    <% } %>
                    
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" autofocus id="txtEmail" placeholder=" " name="login">
                        <label for="txtEmail">E-mail</label>
                    </div>

                    <div class="form-floating mb-3">
                        <input type="password" class="form-control" autofocus id="psswd" placeholder=" " name="senha">
                        <label for="psswd">Senha</label>
                    </div>

                    <div class="form-check mb-3">
                        <input type="checkbox" class="form-check-input" value="" id="chkLembrar"
                        <label for="chkLembrar" class="form-check-input">Lembrar de mim</label>
                    </div>
                    <div class="mb-3 text-end">
                    <input type="submit" value="entrar" class="btn btn-danger">
                </div>
                </form>
            </div>
                    
                </div>
                    <div class="mt-4 row justify-content-center">
                        <div class="col-sm-10 col-md-8 col-lg-6" style="text-align: center;">
                    <span>Não é cadastrado? <a href="novoCliente.jsp">Cadastre-se agora</a></span>
                    </div>
                    </div>
    </main>

    <footer class="mt-10 border-top fixed-bottom text-muted bg-light">
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
