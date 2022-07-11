package smdecommerce.compras.modelo;

import java.io.Serializable;
import smdecommerce.produto.modelo.Produto;

public class CarrinhoCompraItem implements Serializable {
    
    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
