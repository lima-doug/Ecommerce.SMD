<%-- 
    Document   : novoCliente
    Created on : 20 de mai. de 2022, 22:53:01
    Author     : Douglas Lima
--%>
<%@page import="smdecommerce.categoria.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header-menu-admin.jsp"%>

<main>
    <div class="container">
        <h1>Cadastre um novo produto</h1>
        <hr>
        <form action="NovoProduto" method="post">
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <fieldset class="row">
                        <legend>Informações do Produto</legend>
                        <div class="mb-3">
                            <label for="txtDescricao" class="form-label">Descrição</label>
                            <input type="text" class="form-control" id="txtDescricao" name="descricao">
                        </div>
                        <div class="mb-3 col-md-8 col-xl-6">
                            <label for="txtPreco" class="form-label">Preço</label>
                            <input type="text" class="form-control" id="txtPreco" name="preco">
                        </div>
                        <div class="mb-3 col-md-8 col-xl-6">
                            <label for="txtQntd" class="form-label">Quantidade</label>
                            <input type="text" class="form-control" id="txtQntd" name="quantidade">
                        </div>
                        <div class="mb-3 col-md-8 col-xl-6">
                            <label for="txtCategoria">Digite o id da categoria</label>
                            <input type="text" class="form-control" autofocus id="txtCategoria" name="categoria_id">
                        </div>
                    </fieldset>
                </div>

            </div>
            <hr>
            <div class="mb-3 text-end">
                <a class="btn btn-outline-danger" href="ListarProduto" role="button">Cancelar</a>
                <input type="submit" value="Adicionar Produto" class="btn btn-danger">
            </div>
        </form>
    </div>
    <br>
</main>
<%@include file="footer.jsp" %>