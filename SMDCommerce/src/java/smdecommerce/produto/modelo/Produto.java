package smdecommerce.produto.modelo;

/**
 *
 * @author Douglas Lima
 * 
 */

import java.io.Serializable;

/**
 *
 * @author Douglas Lima
 *
 * Classe que representa a entidade usuário
 */
public class Produto implements Serializable {
    
    private Integer id;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private Integer categoria_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCategoria() {
        return categoria_id;
    }

    public void setCategoria(Integer categoria_id) {
        this.categoria_id = categoria_id;
    }

    
    
}