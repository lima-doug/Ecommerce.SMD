<%-- 
    Document   : principalCliente
    Created on : 21 de mai. de 2022, 13:39:51
    Author     : Douglas Lima
--%>

<%@page import="smdecommerce.compras.modelo.CarrinhoCompraItem"%>
<%@page import="java.util.List"%>
<%@page import="smdecommerce.produto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header-menu.jsp" %>

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
        <div class="h-100 col-7" 
             style="background-color: #EFEFEF;">
            <h2 class="m-4">Lorem ipsum dolor si ame</h2>
        </div>
        <div class="h-100 col-5" 
             style="background-color: #EFEFEF;">
            <h3 class="m-4">Lorem ipsum dolor si ame</h3>
        </div>
    </div>

</header>

<%@include file="productMain.jsp" %>

<%@include file="footer.jsp" %>