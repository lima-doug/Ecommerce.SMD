package smdecommerce.usuario.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Douglas Lima
 *
 * Classe que implementa o padrão DAO para entidade usuário.
 */
public class UsuarioDAO {

    /**
     * Metodo utilizado para obter um usuario pelo id
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Usuario obter(int id) throws Exception {
        Usuario usuario = null;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, endereco, email, login, senha, administrador FROM usuario WHERE id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEndereco(resultSet.getString("endereco"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setLogin(resultSet.getString("login"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setAdministrador(resultSet.getBoolean("administrador"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (usuario == null) {
            throw new Exception("Usuário não econtrado");
        }
        return usuario;
    }

    /**
     * Metodo utilizado para obter um usuario pelo id
     *
     * @param login
     * @return
     * @throws Exception
     */
    public Usuario obter(String login) throws Exception {
        Usuario usuario = null;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nome, endereco, email, login, senha, administrador FROM usuario WHERE login=?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEndereco(resultSet.getString("endereco"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setLogin(resultSet.getString("login"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setAdministrador(resultSet.getBoolean("administrador"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        if (usuario == null) {
            throw new Exception("Usuário não econtrado");
        }
        return usuario;
    }

    /**
     * Método utilizado para inserir um novo usuário.
     *
     * @param nome
     * @param endereco
     * @param email
     * @param senha
     * @param administrador
     * @throws Exception
     */
    public void inserir(String nome, String endereco, String email, String login, String senha, boolean administrador) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO usuario(nome, endereco, email, login, senha, administrador) VALUES(?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, endereco);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, login);
        preparedStatement.setString(5, senha);
        preparedStatement.setBoolean(6, administrador);
        int resultado = preparedStatement.executeUpdate();

        if (resultado != 1) {
            throw new Exception("Não foi possível inserir o usuário");
        }
    }

    public void atualizar(String nome, String endereco, String email, String login, String senha, int id) throws Exception {
        boolean sucesso = false;

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE usuario SET nome=?, endereco=?, email=?, login=?, senha=? WHERE id=?;");
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, endereco);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, login);
        preparedStatement.setString(5, senha);
        preparedStatement.setInt(6, id);

        sucesso = (preparedStatement.executeUpdate() == 1);
        preparedStatement.close();
        connection.close();
        if (!sucesso) {
            throw new Exception("Não foi possível atualizar o usuario");
        }
    }

    public void delete(int id) throws Exception {
        boolean sucesso = false;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SMDECommerce", "postgres", "ufc1234");
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM usuario WHERE id=?");
        preparedStatement.setInt(1, id);
        
        sucesso = (preparedStatement.executeUpdate() == 1);
        preparedStatement.close();
        connection.close();
        if (!sucesso) {
            throw new Exception("Não foi possível deletar o usuario");
        }
    }
}
