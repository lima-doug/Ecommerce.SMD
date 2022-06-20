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
    public Produto obter(int id) throws Exception {
        Produto produto = null;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, foto, preco, quantidade FROM produto WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setFoto(resultSet.getString("foto"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setQuantidade(resultSet.getInt("quantidade"));

            if (resultSet.wasNull()) {
                produto.setFoto(null);
            }
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (produto == null) {
            throw new Exception("Produto não encontrado");
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
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
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
     * Método utilizado para obter uma lista de todos os produtos
     *
     * @return
     * @throws Exception
     */
    public List<Produto> obterProdutos() throws Exception {
        List<Produto> produtos = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao, quantidade, preco, foto FROM produto");
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
     * Inserir produto
     *
     * @param descricao
     * @param foto
     * @param preco
     * @param quatidade
     * @param categoria_id
     * @throws Exception
     */
    public void inserir(String descricao, Double preco, Integer quatidade, Integer categoria_id) throws Exception {
        
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto(descricao, preco, quantidade, categoria_id) VALUES( ?, ?, ?, ?)");
        preparedStatement.setString(1, descricao);
        preparedStatement.setDouble(2, preco);
        preparedStatement.setInt(3, quatidade);
        preparedStatement.setInt(4, categoria_id);
        int resultado = preparedStatement.executeUpdate();

        if (resultado != 1) {
            throw new Exception("Não foi possível inserir o produto");
        }
    }

    /**
     * Deletar Produto
     *
     * @param id
     * @throws Exception
     */
    public void delete(int id) throws Exception {
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
    public void atualizar(int id, String descricao, String foto, Double preco, Integer quatidade, Integer categoria_id) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET descricao=?, foto=?, preco=?, quantidade=?, categoria_id=? WHERE id=?");
        preparedStatement.setString(1, descricao);
        preparedStatement.setString(2, foto);
        preparedStatement.setDouble(3, preco);
        preparedStatement.setInt(4, quatidade);
        preparedStatement.setInt(5, categoria_id);
        preparedStatement.setInt(6, id);
        int resultado = preparedStatement.executeUpdate();

    }
    
    /**
     * Método utilizado para armazenar o caminho da foto de um produto
     *
     * @param id
     * @param caminhoFoto
     * @throws Exception
     */
    public void atualizarFoto(int id, String caminhoFoto) throws Exception {
        boolean sucesso = false;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produto SET foto = ? WHERE id = ?");
        preparedStatement.setString(1, caminhoFoto);
        preparedStatement.setInt(2, id);
        sucesso = (preparedStatement.executeUpdate() == 1);
        preparedStatement.close();
        connection.close();
        if (!sucesso) {
            throw new Exception("Não foi possível atualizar a foto do produto");
        }
    }

}
