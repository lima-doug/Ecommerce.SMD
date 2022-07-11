package smdecommerce.venda.modelo;

import java.io.Serializable;

public class Vendas implements Serializable {
    private Integer id;
    private Integer userc_id;
    private Integer produto_id;
    private Integer quantidade;
    private String nome_usuario;
    private String nome_produto;
    private Double preco;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserc_id() {
        return userc_id;
    }

    public void setUserc_id(Integer userc_id) {
        this.userc_id = userc_id;
    }

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
}

