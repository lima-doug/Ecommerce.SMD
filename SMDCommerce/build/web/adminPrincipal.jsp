<%-- 
    Document   : principalCliente
    Created on : 21 de mai. de 2022, 13:39:51
    Author     : Douglas Lima
--%>


<%@include file="header-menu-admin.jsp" %>

<main>
    <div class="container my-4">
        <div class="row">

            <div class="row">
                <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                    <a class="btn" href="ListarCategoria">
                    <div class="card text-center bg-light">
                        <img class="card-img-top" src="./images/SM-placeholder.png" alt="">
                        <div class="card-header">
                            <h5 class="card-title">Atualizar e cadastrar Categoria</h5>
                        </div>
                    </div>
                        </a>
                </div>
                <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                    <a class="btn" href="ListarProduto">
                        <div class="card text-center bg-light">
                            <img class="card-img-top" src="./images/SM-placeholder.png" alt="">
                            <div class="card-header">
                                <h5 class="card-title">Atualizar e cadastrar Produto</h5>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                    <div class="card text-center bg-light">
                        <img class="card-img-top" src="./images/SM-placeholder.png" alt="">
                        <div class="card-header">
                            <h5 class="card-title">Registrar Vendas</h5>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                    <div class="card text-center bg-light">
                        <img class="card-img-top" src="./images/SM-placeholder.png" alt="">
                        <div class="card-header">
                            <h5 class="card-title">Relatórios e Dashboards</h5>
                        </div>
                    </div>
                </div>
                <hr class="mt-3">
            </div>
        </div>
</main>

<%@include file="footer.jsp" %>