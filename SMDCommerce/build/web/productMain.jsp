<main>
    <div class="container my-4">
        <div class="row">
            <div class="col-12 col-md-5">
                <form class="justify-content-center justify-content-md-start mb-3 mb-md-0">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" placeholder="Digite aqui o que procura..." />
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
            <%
                List<Produto> produtosDisponiveis = (List<Produto>) request.getAttribute("produtosDisponiveis");
                if (produtosDisponiveis == null || produtosDisponiveis.size() == 0) {
            %>
            <div>Não existem produtos disponíveis</div>
            <%
            } else {
                for (int i = 0; i < produtosDisponiveis.size(); i++) {
                    Produto p = produtosDisponiveis.get(i);
            %>
            <div class="col-xl-3 col-lg-4 col-md-5 col-sm- d-flex align-items-stretch">
                <div class="card text-center bg-light">

                    <div class="card-header">R$ <%= p.getPreco()%></div>
                    <div class="card-body">
                        <h5 class="card-title"><%= p.getDescricao()%></h5>
                        <div class="card-footer">
                                <a href="AdicionarCompra?produtoId=<%= p.getId()%>" class="btn" style="font-size: 16; background:#EFEFEF;">
                                    Adicionar ao Carrinho
                                </a>
                        </div>
                    </div>
                </div>
            </div>
            <%
                    if (i < produtosDisponiveis.size() - 1) {
                        out.println("<br/>");
                    }
                }
            }
            %>
        </div>
    </div>
</main>

