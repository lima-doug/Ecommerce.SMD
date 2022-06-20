<%-- 
    Document   : login
    Created on : 19 de mai. de 2022, 23:58:15
    Author     : Douglas Lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header-menu-admin.jsp"%>
<main>
    <div class="container">
        <div class="row justify-content-center">
            <form class="col-sm-10 col-md-8 col-lg-6" action="NovaCategoria" method="post">
                <h1 class="my-4">Nova categoria</h1>                    

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" autofocus id="txtCategoria" placeholder=" " name="descricao">
                    <label for="txtCategoria">Nova categoria</label>
                </div>
                <div class="mb-3 text-end">
                    <input type="submit" value="Salvar" class="btn btn-danger">
                </div>
            </form>
        </div>
    </div>
</main>

<%@include file="footer.jsp" %>