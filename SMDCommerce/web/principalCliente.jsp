<%-- 
    Document   : principalCliente
    Created on : 21 de mai. de 2022, 13:39:51
    Author     : Douglas Lima
--%>

<% 
    Usuario usuario = (Usuario) session.getAttribute("usuario"); 
    if(usuario == null){
    request.setAttribute("mensagem", "Você não tem uma sessão válida de cliente");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
    requestDispatcher.forward(request, response);
    } else{
%>
<%@page import= "smdecommerce.usuario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">

    <head>
        <title>Bem vindo</title>
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
                            <li class="nav-item me-4">
                                <div class="dropdown">
                                    <button class="nav-link text-dark border-0 p-2 dropdown-toggle btn btn-sm"
                                            type="button" id="dropdownMenuButton1"data-bs-toggle="dropdown"
                                            aria-expanded="false">
                                        Olá <%= usuario.getNome()%>
                                    </button>
                                    <ul class="dropdown-menu list-style-none" aria-labelledby="dropdownMenuButton1">
                                        <li><a class="dropdown-item" href="configuracoes.jsp">Configurações</a></li>
                                        <li><a class="dropdown-item" href="#">Pedidos</a></li>
                                        <li><a class="dropdown-item" href="Logout">Sair</a></li>
                                    </ul>

                                </div>
                                </div>
                            </li>

                            <li style="list-style: none;" class="nav-item">
                                <a href="carrinhoCompra.html" class="nav-link text-dark">
                                    <img src="./icons/shopping--cart 1.png" alt="">
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

    <head>
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
        <div class="h-100 col-7" 
             style="background-color: #EFEFEF;">
            <h2 class="m-4">Lorem ipsum dolor si ame</h2>
        </div>
        <div class="h-100 col-5" 
             style="background-color: #EFEFEF;">
            <h3 class="m-4">Lorem ipsum dolor si ame</h3>
        </div>
    </div>

</head>

<main>
    <div class="container my-4">
        <div class="row">
            <div class="col-12 col-md-5">
                <form class="justify-content-center justify-content-md-start mb-3 mb-md-0">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" placeholder="Digite aqui o que procura...">
                        <button class="btn px-3" style="background-color: #EFEFEF;">
                            Buscar
                        </button>
                    </div>
                </form>
            </div>
            <div class="col-12 col-md-7">
                <div class="d-flex flex-row-reverse justify-content-center justify-content-md-start">
                    <form class="ml-3 d-inline-block">
                        <select class="form-select form-select-sm">
                            <option>Ordenar pelo nome</option>
                            <option>Ordenar pelo menor valor</option>
                            <option>Ordenar pelo maior preço</option>
                        </select>
                    </form>
                    <nav class="d-inline-block">
                        <ul class="pagination pagination-sm my-0">
                            <li class="page-item">
                                <button class="page-link">1</button>
                            </li>
                            <li class="page-item">
                                <button class="page-link">2</button>
                            </li>
                            <li class="page-item">
                                <button class="page-link">3</button>
                            </li>
                            <li class="page-item">
                                <button class="page-link">4</button>
                            </li>
                            <li class="page-item">
                                <button class="page-link">5</button>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <hr class="mt-3">

        <div class="row">
            <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                <div class="card text-center bg-light">
                    <a href="" class="position-absolute end-0 p-2 text-danger">
                        <svg class="bi" width="24" height="24" fill="currentColor">
                        <use xlink:href="./icons/bi.svg#suit-heart"></use>
                        </svg>
                    </a>
                    <img class="card-img-top" src="./images/SM-placeholder.png" alt="">
                    <div class="card-header">
                        R$ 40,00
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Item 1</h5>
                        <p>Placeholder de texto do item 1, em produção...</p>
                        <div class="card-footer">
                            <form class="d-block">
                                <button class="btn" style="font-size: 16; background:#EFEFEF;">
                                    Adicionar ao Carrinho
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                <div class="card text-center bg-light">
                    <a href="" class="position-absolute end-0 p-2 text-danger">
                        <svg class="bi" width="24" height="24" fill="currentColor">
                        <use xlink:href="./icons/bi.svg#suit-heart"></use>
                        </svg>
                    </a>
                    <img class="card-img-top" src="./images/SM-placeholder.png" alt="">
                    <div class="card-header">
                        R$ 40,00
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Item 2</h5>
                        <p>Placeholder de texto do item 1, em produção...</p>
                        <div class="card-footer">
                            <form class="d-block">
                                <button class="btn" style="font-size: 16; background:#EFEFEF;">
                                    Adicionar ao Carrinho
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                <div class="card text-center bg-light">
                    <a href="" class="position-absolute end-0 p-2 text-danger">
                        <svg class="bi" width="24" height="24" fill="currentColor">
                        <use xlink:href="./icons/bi.svg#suit-heart"></use>
                        </svg>
                    </a>
                    <img class="card-img-top" src="./images/SM-placeholder.png" alt="">
                    <div class="card-header">
                        R$ 40,00
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Item 3</h5>
                        <p>Placeholder de texto do item 1, em produção...</p>
                        <div class="card-footer">
                            <form class="d-block">
                                <button class="btn" style="font-size: 16; background:#EFEFEF;">
                                    Adicionar ao Carrinho
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                <div class="card text-center bg-light">
                    <a href="" class="position-absolute end-0 p-2 text-danger">
                        <svg class="bi" width="24" height="24" fill="currentColor">
                        <use xlink:href="./icons/bi.svg#suit-heart"></use>
                        </svg>
                    </a>
                    <img class="card-img-top" src="./images/SM-placeholder.png" alt="">
                    <div class="card-header">
                        R$ 40,00
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">Item 4</h5>
                        <p>Placeholder de texto do item 1, em produção...</p>
                        <div class="card-footer">
                            <form class="d-block">
                                <button class="btn btn-light disable" disabled style="font-size: 16; background:#EFEFEF;">
                                    <small class="text-danger"><b>Produto esgotado</b></small>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr class="mt-3">
        <div class="row pb-4">
            <div class="col-12">
                <div class="col-12 col-md-7">
                    <div class="d-flex flex-row-reverse justify-content-center justify-content-md-start">
                        <nav class="d-inline-block">
                            <ul class="pagination pagination-sm my-0">
                                <li class="page-item">
                                    <button class="page-link">1</button>
                                </li>
                                <li class="page-item">
                                    <button class="page-link">2</button>
                                </li>
                                <li class="page-item">
                                    <button class="page-link">3</button>
                                </li>
                                <li class="page-item">
                                    <button class="page-link">4</button>
                                </li>
                                <li class="page-item">
                                    <button class="page-link">5</button>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
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
</body>

</html>
<% } %>