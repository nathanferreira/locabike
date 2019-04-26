package dao;

import model.Locacao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Locacao;

public class LocacaoDAO {

    public LocacaoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Locabike", "root", "root");
    }

    public void insert(Locacao locacao) {
        String sql = "INSERT INTO Locacao (CNPJ, CPF, rentDate) VALUES (?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getCNPJ());
            statement.setString(2, locacao.getCPF());
            statement.setString(3, locacao.getRentDate());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String ID) {
        String sql = "DELETE FROM Locacao where ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ID);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locacao locacao) {
        String sql = "UPDATE Locacao SET CNPJ = ?, CPF = ?, rentDate = ?";
        sql += " WHERE ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(2, locacao.getCPF());
            statement.setString(3, locacao.getRentDate());
            statement.setString(1, locacao.getCNPJ());
            statement.setString(4, locacao.getID());

            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locacao get(String ID) {
        Locacao locacao = null;
        String sql = "SELECT * FROM Locacao WHERE ID = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String CNPJ = resultSet.getString("CNPJ");
                String CPF = resultSet.getString("CPF");
                String rentDate = resultSet.getString("rentDate");
                locacao = new Locacao(ID, CNPJ, CPF, rentDate);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacao;
    }
    
    public List<Locacao> getbyCliente(String email) {
        List<Locacao> listaLocacaos = new ArrayList<>();
        
        String sql = "SELECT * FROM Locacao INNER JOIN Cliente ON locacao.CPF = Cliente.CPF WHERE Cliente.email = ?";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String ID = resultSet.getString("ID");
                String CNPJ = resultSet.getString("CNPJ");
                String CPF = resultSet.getString("CPF");
                String rentDate = resultSet.getString("rentDate");

                Locacao locacao = new Locacao(ID, CNPJ, CPF, rentDate);
                listaLocacaos.add(locacao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacaos;
    }
    
    public List<Locacao> getbyLocadora(String email) {
        List<Locacao> listaLocacaos = new ArrayList<>();
        
        String sql = "SELECT * FROM Locacao INNER JOIN Locadora ON locacao.CNPJ = Locadora.CNPJ WHERE Locadora.email = ?";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String ID = resultSet.getString("ID");
                String CNPJ = resultSet.getString("CNPJ");
                String CPF = resultSet.getString("CPF");
                String rentDate = resultSet.getString("rentDate");

                Locacao locacao = new Locacao(ID, CNPJ, CPF, rentDate);
                listaLocacaos.add(locacao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacaos;
    }
    

    public List<Locacao> getAll() {
        List<Locacao> listaLocacaos = new ArrayList<>();
        String sql = "SELECT * FROM Locacao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                String ID = resultSet.getString("ID");
                String CNPJ = resultSet.getString("CNPJ");
                String CPF = resultSet.getString("CPF");
                String rentDate = resultSet.getString("rentDate");

                Locacao locacao = new Locacao(ID, CNPJ, CPF, rentDate);
                listaLocacaos.add(locacao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacaos;
    }
}
