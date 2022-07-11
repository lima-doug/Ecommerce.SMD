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

                <a class="btn p-2" href="ListarCategoria">
                    <div class="card text-center bg-light">       
                        <h5 class="p-2 card-title">Atualizar e cadastrar Categoria</h5>
                    </div>
                </a>

                <a class="btn p-2" href="ListarProduto">
                    <div class="card text-center bg-light">
                        <h5 class="p-2 card-title">Atualizar e cadastrar Produto</h5>
                    </div>
                </a>

                <a class="btn p-2" href="ListarVendas" style='height:72px;'>
                    <div class="card text-center bg-light">
                        <h5 class="p-2 card-title">Relatório</h5>
                    </div>
                </a>

            </div>
            <hr class="mt-3">
        </div>
    </div>
</main>

<%@include file="footer.jsp" %>