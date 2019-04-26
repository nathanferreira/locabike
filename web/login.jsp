<%@ page import ="java.sql.*" %>
<%

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Locabike", "root", "root");

    String sql = "SELECT * FROM USUARIO WHERE email = ? and password = ?";

    try {
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            session.setAttribute("email", email);
            session.setAttribute("role", resultSet.getString("ROLE"));

            response.sendRedirect("/locadora/lista");
        } else {
            out.println("Senha invalida <a href='index.jsp'>Tente novamente</a>");
        }

        resultSet.close();
        statement.close();
        conn.close();
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    
%>
