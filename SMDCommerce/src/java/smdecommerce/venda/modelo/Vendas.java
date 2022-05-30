package smdecommerce.venda.modelo;

/**
 *
 * @author Douglas Lima
 */

public class Vendas {
    private Integer id;
    private Integer produto;
    private Integer cliente;
    private Integer quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}

