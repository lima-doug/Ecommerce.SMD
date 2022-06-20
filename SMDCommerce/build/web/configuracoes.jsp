<%-- 
    Document   : configuracoes
    Created on : 21 de mai. de 2022, 16:31:54
    Author     : Douglas Lima
--%>

<%@include file="header-menu.jsp" %>

<%
    if (usuario != null) {
%>
<main>
    <div class="container">
        <h3>Configurações de conta</h3>
        <hr>
        <form action="AtualizarUsuario" method="post">
            <input type="hidden" name="id" value="<%= usuario.getId() %>" />
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <fieldset class="row">
                        <legend>Dados Pessoais</legend>
                        <div class="mb-3">
                            <label for="txtNome" class="form-label">Nome</label>
                            <input type="text" class="form-control" id="txtNome" name="nome" value="<jsp:getProperty name="usuario" property="nome"/>">
                        </div>
                        <div class="mb-3 col-md-8 col-xl-6">
                            <label for="txtLogin" class="form-label">Login</label>
                            <input type="text" class="form-control" id="txtLogin" name="login" value="<jsp:getProperty name="usuario" property="login"/>">
                        </div>

                    </fieldset>
                    <fieldset>
                        <legend>Contatos</legend>
                        <div class="mb-3">
                            <label for="txtEmail" class="form-label">E-mail</label>
                            <input type="email" class="form-control" name="email" id="txtEmail" value="<jsp:getProperty name="usuario" property="email"/>" >
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Senha de Acesso</legend>
                        <div class="mb-3">
                            <label for="txtPass" class="form-label">Senha</label>
                            <input type="password" class="form-control" id="txtPass" name="senha" value="<jsp:getProperty name="usuario" property="senha"/>">
                        </div>
                    </fieldset>
                </div>

                <div class="col-sm-12 col-md-6">
                    <fieldset class="row">
                        <legend>Endereço</legend>
                        <div class="mb-3">
                            <label for="txtNome" class="form-label">Endereço</label>
                            <input type="text" class="form-control" name="endereco" id="txtNome" value="<jsp:getProperty name="usuario" property="endereco"/>">
                        </div>
                    </fieldset>
                    <br>
                </div>
            </div>
            <hr>
            <div class="mb-3 text-end">
                <a class="btn col-2 btn-lg btn-outline-danger" href="DeleteUsuario?id=<%= usuario.getId()%>">Excluir conta<a>
                <input type="submit" class="btn btn-lg btn-success" value="Salvar"/>
            <br>
            </div>
        </form>
    </div>
</main>
<%
} else {
%>
<div>Usuário inválido.</div>
<%
    }
%>

<%@include file="footer.jsp" %>