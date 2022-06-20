<%-- 
    Document   : novoCliente
    Created on : 20 de mai. de 2022, 22:53:01
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
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

    <main>
        <div class="container">
            <h1>Infome seus Dados, por favor</h1>
            <hr>
            <form action="NovoCliente" method="post">
                <div class="row">
                    <div class="col-sm-12 col-md-6">
                        <fieldset class="row">
                            <legend>Dados Pessoais</legend>
                            <div class="mb-3">
                                <label for="txtNome" class="form-label">Nome</label>
                                <input type="text" class="form-control" id="txtNome" name="nome">
                            </div>
                            <div class="mb-3 col-md-8 col-xl-6">
                                <label for="txtLogin" class="form-label">Login</label>
                                <input type="text" class="form-control" id="txtLogin" name="login">
                            </div>
                       
                        </fieldset>
                        <fieldset>
                            <legend>Contatos</legend>
                            <div class="mb-3">
                                <label for="txtEmail" class="form-label">E-mail</label>
                                <input type="email" class="form-control" name="email" id="txtEmail">
                            </div>
                        </fieldset>
                        <fieldset>
                            <legend>Senha de Acesso</legend>
                            <div class="mb-3">
                                <label for="txtPass" class="form-label">Senha</label>
                                <input type="password" class="form-control" id="txtPass" name="senha">
                            </div>
                            <!--
                            <div class="mb-3">
                                <label for="txtConfSenha" class="form-label">Confirmação da Senha</label>
                                <input type="text" class="form-control" id="txtConfSenha">
                            </div>
                            -->
                        </fieldset>
                    </div>

                    <div class="col-sm-12 col-md-6">
                        <fieldset class="row">
                            <legend>Endereço</legend>
                            <div class="mb-3">
                                <label for="txtNome" class="form-label">Endereço</label>
                                <input type="text" class="form-control" name="endereco" id="txtNome">
                            </div>
                        </fieldset>
                        <br>
                        <div class="form-check mb-3">
                            <input type="checkbox" class="form-check-input" value=" " id="chkPromocoes">
                            <label for="chkPromocoes" class="form-check-label">Desejo receber informações sobre promoções.</label>
                        </div>
   
                    </div>
                </div>
                <hr>
                
                <div class="mb-3 text-end">
                    <a class="btn btn-outline-danger" href="./index.html" role="button">Cancelar</a>
                    <input type="submit" value="Criar meu cadastro" class="btn btn-danger">
                </div>
            </form>
        </div>
        <br>
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
</body>

</html>