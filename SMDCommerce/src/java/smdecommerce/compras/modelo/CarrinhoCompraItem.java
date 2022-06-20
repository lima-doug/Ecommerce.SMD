package smdecommerce.compras.modelo;

import smdecommerce.produto.modelo.Produto;

/**
 *
 * @author Douglas Lima
 */
public class CarrinhoCompraItem {
    
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
