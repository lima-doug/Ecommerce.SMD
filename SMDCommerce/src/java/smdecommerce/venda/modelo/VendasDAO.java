package smdecommerce.venda.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import smdecommerce.usuario.modelo.Usuario;


public class VendasDAO {
    
    public Vendas obter(int id) throws Exception{
        Vendas venda = null;
        
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, userc_id, produto_id, quantidade FROM venda WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            venda = new Vendas();
            venda.setId(resultSet.getInt("id"));
            venda.setUserc_id((resultSet.getInt("userc_id")));
            venda.setProduto_id(resultSet.getInt("produto_id"));
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
    
    public List<Vendas> obterVendas() throws Exception {
        List<Vendas> vendas = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT venda.id AS id, usuario.nome AS nome, produto.descricao AS produto, produto.preco AS preco, venda.quantidade AS quantidade\n" +
            "FROM venda\n" +
            "INNER JOIN usuario ON venda.userc_id = usuario.id\n" +
            "INNER JOIN produto ON venda.produto_id = produto.id");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Vendas venda = new Vendas();
            
            venda.setId(resultSet.getInt("id"));
            venda.setNome_usuario(resultSet.getString("nome"));
            venda.setNome_produto(resultSet.getString("produto"));
            venda.setPreco(resultSet.getDouble("preco"));
            venda.setQuantidade(resultSet.getInt("quantidade"));
            vendas.add(venda);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return vendas;
    }
    
    public List<Vendas> obterCompras(int userc_id) throws Exception {
        List<Vendas> compras = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT venda.id AS id, produto.descricao AS produto, produto.preco AS preco, venda.quantidade AS quantidade\n" +
            "FROM venda\n" +
            "INNER JOIN usuario ON venda.userc_id = usuario.id\n" +
            "INNER JOIN produto ON venda.produto_id = produto.id\n" +
            "WHERE venda.userc_id=?");
        preparedStatement.setInt(1, userc_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Vendas compra = new Vendas();
            compra.setId(resultSet.getInt("id"));
            compra.setNome_produto(resultSet.getString("produto"));
            compra.setPreco(resultSet.getDouble("preco"));
            compra.setQuantidade(resultSet.getInt("quantidade"));
            compras.add(compra);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return compras;
    }
    
    public void inserir(int userc_id, int produto_id, int quantidade)throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO venda(userc_id, produto_id, quantidade) VALUES(?, ?, ?)");
        preparedStatement.setInt(1, userc_id);
        preparedStatement.setInt(2, produto_id);
        preparedStatement.setInt(3, quantidade);
        int resultado = preparedStatement.executeUpdate();
        
        if(resultado != 1){
            throw new Exception("Não concluir a venda");
        }  
    }
    
     public void delete(int id) throws Exception {
        boolean sucesso = false;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM venda WHERE id=?");
        preparedStatement.setInt(1, id);
        sucesso = (preparedStatement.executeUpdate() == 1);
        preparedStatement.close();
        connection.close();
        if (!sucesso) {
            throw new Exception("Não foi possível deletar a categoria");
        }
    }
}