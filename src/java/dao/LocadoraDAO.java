package dao;

import model.Locadora;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Locadora;

public class LocadoraDAO {

    public LocadoraDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Locabike", "root", "root");
    }

    public void insert(Locadora locadora) {
        String sql = "INSERT INTO Locadora (email, password, CNPJ, name, city) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getEmail());
            statement.setString(2, locadora.getPassword());
            statement.setString(3, locadora.getCNPJ());
            statement.setString(4, locadora.getName());
            statement.setString(5, locadora.getCity());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String CNPJ) {
        String sql = "DELETE FROM Locadora where CNPJ = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, CNPJ);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locadora locadora) {
        String sql = "UPDATE Locadora SET email = ?, password = ?, CNPJ = ?, name = ?, city = ?";
        sql += " WHERE CNPJ = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getEmail());
            statement.setString(2, locadora.getPassword());
            statement.setString(3, locadora.getCNPJ());
            statement.setString(4, locadora.getName());
            statement.setString(5, locadora.getCity());
            statement.setString(6, locadora.getCNPJ());

            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locadora get(String CNPJ) {
        Locadora locadora = null;
        String sql = "SELECT * FROM Locadora WHERE CNPJ = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, CNPJ);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                locadora = new Locadora(email, password, CNPJ, name, city);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
    
    public List<Locadora> getAll() {
        List<Locadora> listaLocadoras = new ArrayList<>();
        String sql = "SELECT * FROM Locadora";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String CNPJ = resultSet.getString("CNPJ");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
        
                Locadora locadora = new Locadora(email, password, CNPJ, name, city);
                listaLocadoras.add(locadora);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
    }
}
