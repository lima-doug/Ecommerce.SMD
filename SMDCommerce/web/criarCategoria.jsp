<%-- 
    Document   : login
    Created on : 19 de mai. de 2022, 23:58:15
    Author     : Douglas Lima
--%>

    <%@include file="header-menu-admin.jsp" %>
    <main>
        <div class="container">
            <div class="row justify-content-center">
                <form class="col-sm-10 col-md-8 col-lg-6" action="NovaCategoria" method="post">
                    <h1 class="my-4">Nova Categoria</h1>                    
                    <hr>
                    <% if(request.getAttribute("mensagem") != null) { %>
                    <div><%= request.getAttribute("mensagem")%></div>
                    <% } %>
                    
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" autofocus id="txtDescricao" placeholder=" " name="descricao">
                        <label for="txtDescricao">Descricao</label>
                    </div>
                    <div class="mb-3 text-end">
                    <input type="submit" value="Salvar" class="btn btn-danger">
                </div>
                </form>
            </div>
                    
    </main>

                    <%@include file="footer.jsp" %>
