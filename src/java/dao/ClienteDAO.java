package dao;

import model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public ClienteDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Locabike", "root", "root");
    }
    
    public void insert(Cliente cliente) {
        String sql = "INSERT INTO Cliente (email, password, CPF, name, gender, phone, birthDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getPassword());
            statement.setString(3, cliente.getCPF());
            statement.setString(4, cliente.getName());
            statement.setString(5, cliente.getGender());
            statement.setString(6, cliente.getPhone());
            statement.setString(7, cliente.getBirthDate());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(String email) {
        String sql = "DELETE FROM Cliente where email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void update(Cliente cliente) {
        String sql = "UPDATE Cliente SET email = ?, password = ?, CPF = ?, name = ?, gender = ?, phone = ?, birthDate = ? WHERE email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getEmail());
            statement.setString(2, cliente.getPassword());
            statement.setString(3, cliente.getCPF());
            statement.setString(4, cliente.getName());
            statement.setString(5, cliente.getGender());
            statement.setString(6, cliente.getPhone());
            statement.setString(7, cliente.getBirthDate());
            statement.setString(8, cliente.getEmail());
            
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Cliente get(String email) {
        Cliente cliente = null;
        String sql = "SELECT * FROM CLIENTE WHERE email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String CPF = resultSet.getString("CPF");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                String birthDate = resultSet.getString("birthDate");
                cliente = new Cliente(email, password, CPF, name, gender, phone,
                    birthDate);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
    
    public List<Cliente> getAll() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String CPF = resultSet.getString("CPF");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                String birthDate = resultSet.getString("birthDate");
        
                Cliente cliente = new Cliente(email, password, CPF, name, gender, phone, birthDate);
                listaClientes.add(cliente);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }
}
