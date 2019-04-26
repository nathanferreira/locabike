<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Lokabike | Lista Clientes</title>
    </head>
    <body>
        <%@include  file="menu.jsp" %>

        <div class="content">
            <form method="post" action="login.jsp">
                <p>
                    <input type="text" name="email" class="form-control" placeholder="Email" required autofocus>
                </p>
                <p>
                <input type="password" name="password" placeholder="Password" required>
                </p>
                <button type="submit">Entrar</button>
            </form>
        </div>
    </body>
</html>