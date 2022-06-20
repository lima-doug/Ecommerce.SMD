package smdecommerce.categoria.modelo;

/**
 *
 * @author Douglas Lima
 */
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
 * Classe que implementa o padrão DAO para entidade categoria.
 */
public class CategoriaDAO {
    
    /**
     * Metodo utilizado para obter uma categoria pelo id
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    
    public Categoria obter(int id) throws Exception{
        Categoria categoria = null;
        
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, descricao FROM categoria WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            categoria = new Categoria();
            categoria.setId(resultSet.getInt("id"));
            categoria.setDescricao(resultSet.getString("descricao"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if(categoria == null){
            throw new Exception("Categoria não econtrada");
        }
        return categoria;
    }
    
    public List<Categoria> obterCategorias() throws Exception {
        List<Categoria> categorias = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM categoria");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(resultSet.getInt("id"));
            categoria.setDescricao(resultSet.getString("descricao"));
            categorias.add(categoria);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return categorias;
    }
    
    
    /**
     * Método utilizado para inserir uma categoria.
     * 
     * @param descricao
     * 
     */
    
    public void inserir(String descricao)throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categoria(descricao) VALUES(?)");
        preparedStatement.setString(1, descricao);
        int resultado = preparedStatement.executeUpdate();
        
        if(resultado != 1){
            throw new Exception("Não foi possível inserir a categoria");
        }  
    }
    
     /**
     * Método utilizado para deletar uma categoria.
     * 
     * @param descricao
     * 
     */
    
    
     public void delete(int id) throws Exception {
        boolean sucesso = false;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categoria WHERE id=?");
        preparedStatement.setInt(1, id);
        
        sucesso = (preparedStatement.executeUpdate() == 1);
        preparedStatement.close();
        connection.close();
        if (!sucesso) {
            throw new Exception("Não foi possível deletar a categoria");
        }
    }
     /**
     * Método utilizado para atualizar uma categoria.
     * 
     * @param descricao
     * 
     */
    
    public void atualizar(String descricao, int id) throws Exception {
        boolean sucesso = false;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categoria SET descricao=? WHERE id=?;");
        preparedStatement.setString(1, descricao);
        preparedStatement.setInt(2, id);

        sucesso = (preparedStatement.executeUpdate() == 1);
        preparedStatement.close();
        connection.close();
        if (!sucesso) {
            throw new Exception("Não foi possível atualizar a categoria");
        }
    }
}

