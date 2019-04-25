<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Lokabike | Lista de Usuarios</title>
    </head>
    <body>
    <%@include  file="menu.html" %>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Usuarios</h2></caption>
            <tr>
                <th>Email</th>
                <th>Senha</th>
                <th>Papel</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="usuario" items="${listaUsuarios}">
                <tr>
                    <td><c:out value="${usuario.email}" /></td>
                    <td><c:out value="${usuario.password}" /></td>
                    <td><c:out value="${usuario.role}" /></td>
                    <td>
                        <a href="/<c:out value='${usuario.role}'/>/edicao?email=<c:out value='${usuario.email}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/<c:out value='${usuario.role}'/>/remocao?email=<c:out value='${usuario.email}' />"
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>