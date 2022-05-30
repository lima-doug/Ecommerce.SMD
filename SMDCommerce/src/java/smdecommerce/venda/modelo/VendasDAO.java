package smdecommerce.venda.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Douglas Lima
 * 
 * Classe que implementa o padrão DAO para entidade categoria.
 */
public class VendasDAO {
    
    /**
     * Metodo utilizado para obter uma categoria pelo id
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    
    public Vendas obter(int id) throws Exception{
        Vendas venda = null;
        
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, userc_id, produto_id, quantidade FROM venda, venda_produto WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            venda = new Vendas();
            venda.setId(resultSet.getInt("id"));
            venda.setCliente(resultSet.getInt("userc_id"));
            venda.setProduto(resultSet.getInt("produto_id"));
            venda.setQuantidade(resultSet.getInt("quantidade"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if(venda == null){
            throw new Exception("Venda não concluida");
        }
        return venda;
    }
    
    
    /**
     * Método utilizado para inserir uma categoria.
     * 
     * @param descricao
     * 
     */
    
    public void inserir(int cliente, int produto, int quantidade)throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO venda(userc_id, produto_id, quantidade) VALUES(?, ?, ?)");
        preparedStatement.setInt(1, cliente);
        preparedStatement.setInt(2, produto);
        preparedStatement.setInt(3, quantidade);
        int resultado = preparedStatement.executeUpdate();
        
        if(resultado != 1){
            throw new Exception("Não concluir a venda");
        }  
    }
    
    public void delete(int id)throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM venda, venda_produto WHERE id=?");
        preparedStatement.setInt(1, id);
        int resultado = preparedStatement.executeUpdate();
        
    }
    
    public void atualizar(int id, int cliente, int produto, int quantidade)throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE venda, venda_produto SET cliente=?, produto=?, quantidade=? WHERE id=?");
        preparedStatement.setInt(1, cliente);
        preparedStatement.setInt(2, produto);
        preparedStatement.setInt(3, quantidade);
        preparedStatement.setInt(4, id);
        int resultado = preparedStatement.executeUpdate();
        
    }
}