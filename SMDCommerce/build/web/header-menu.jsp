<%-- 
    Document   : header-menu
    Created on : 5 de jun. de 2022, 21:39:02
    Author     : Douglas Lima
--%>

<jsp:useBean id='usuario' class="smdecommerce.usuario.modelo.Usuario" scope="session"/>
<%
    if (usuario == null || usuario.getId() == null) {
        request.setAttribute("mensagem", "Você não tem uma sessão válida de usuário do tipo cliente");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    } else {
%>
<%@page import= "smdecommerce.usuario.modelo.Usuario"%>
<%@page import="java.util.List"%>
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
                <a class="navbar-brand text-dark" href="InicioClient"><strong>SMD Commerce</strong></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="navbar-collapse collapse text-dark">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item me-4">
                            <a href="InicioClient" class="nav-link text-dark">Home</a>
                        </li>
                        <li class="nav-item me-4">
                            <a href="ProductClient" class="nav-link text-dark">Produtos</a>
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
                                            type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
                                            aria-expanded="false">
                                        Olá <%= usuario.getNome()%>
                                    </button>
                                    <ul class="dropdown-menu list-style-none" aria-labelledby="dropdownMenuButton1">
                                        <li><a class="dropdown-item" href="configuracoes.jsp">Configurações</a></li>
                                        <li><a class="dropdown-item" href="ListarComprasCliente?usuarioId=<%= usuario.getId()%>">Pedidos</a></li>
                                        <li><a class="dropdown-item" href="Logout">Sair</a></li>
                                    </ul>
                            </li>
                            <li class="nav-item">
                                <a href="CarrinhoCompraPage" class="nav-link text-dark">
                                    <span class="iconify" data-icon="bi:cart-fill" style="color: #6c757d; width: 24px; height: 24px;"></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>