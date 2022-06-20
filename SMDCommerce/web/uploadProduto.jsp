<%-- 
    Document   : novoCliente
    Created on : 20 de mai. de 2022, 22:53:01
    Author     : Douglas Lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header-menu.jsp" %>
    <main>
        <div class="container">
            <h1>Atualizar produto</h1>
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
    <%@include file="footer.jsp" %>