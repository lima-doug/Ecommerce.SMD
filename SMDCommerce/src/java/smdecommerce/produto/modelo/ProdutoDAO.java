package smdecommerce.produto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas Lima
 * 
 * Classe que implementa o padrão DAO para entidade produto.
 */
public class ProdutoDAO {
    
    /**
     * Metodo utilizado para obter um usuario pelo id
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    
    public Produto obter(int id) throws Exception{
        Produto produto = null;
        
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, descricao, foto, preco, quantidade, categoria_id, admin_id FROM produto WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setFoto(resultSet.getString("foto"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setQuantidade(resultSet.getInt("quantidade"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if(produto == null){
            throw new Exception("Produto não econtrado");
        }
        return produto;
    }
    
  /**
     * Método utilizado para obter uma lista de produtos disponíveis em estoque
     *
     * @return
     * @throws Exception
     */
    public List<Produto> obterProdutosEmEstoque() throws Exception {
        List<Produto> produtos = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/smdecommerce", "postgres", "ufc123");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, quantidade, preco, foto FROM produto WHERE quantidade > 0");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setQuantidade(resultSet.getInt("quantidade"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setFoto(resultSet.getString("foto"));
            if (resultSet.wasNull()) {
                produto.setFoto(null);
            }
            produtos.add(produto);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return produtos;
    }
    
    /**
     * Método utilizado para inserir um produto.
     * 
     * @param descricao
     * 
     */
    
    
    public void inserir(String descricao, String foto, double preco, int quatidade)throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto(descricao, foto, preco, quantidade, categoria_id, admin_id) VALUES(?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, descricao);
        preparedStatement.setString(2, foto);
        preparedStatement.setDouble(3, preco);
        preparedStatement.setInt(4, quatidade);
        int resultado = preparedStatement.executeUpdate();
        
        if(resultado != 1){
            throw new Exception("Não foi possível inserir o produto");
        }  
    }
    
    
     /**
     * Método utilizado para deletar um produto.
     * 
     * @param descricao
     * 
     */
    public void delete(int id)throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produto WHERE id=?");
        preparedStatement.setInt(1, id);
        int resultado = preparedStatement.executeUpdate();        
    }
     /**
     * Método utilizado para atualizar um produto.
     * 
     * @param descricao
     * 
     */
    public void atualizar(int id, String descricao, String foto, double preco, int quatidade)throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET descricao=?, foto=?, preco=?, quantidade=?, categoria_id=?, admin_id=? WHERE id=?");
        preparedStatement.setString(1, descricao);
        preparedStatement.setString(2, foto);
        preparedStatement.setDouble(3, preco);
        preparedStatement.setInt(4, quatidade);
        preparedStatement.setInt(7, id);
        int resultado = preparedStatement.executeUpdate();
        
    }
}