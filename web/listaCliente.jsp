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
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Cliente</h2></caption>
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Telefone</th>
                <th>Genero</th>
                <th>Senha</th>
                <th>Data de Nascimento</th>
                <% if (role.equals("admin")) { %>
                <th>Ações</th>
                <% } %>
            </tr>
            <c:forEach var="cliente" items="${listaClientes}">
                <tr>
                    <td><c:out value="${cliente.CPF}" /></td>
                    <td><c:out value="${cliente.name}" /></td>
                    <td><c:out value="${cliente.email}" /></td>
                    <td><c:out value="${cliente.phone}" /></td>
                    <td><c:out value="${cliente.gender}" /></td>
                    <td><c:out value="${cliente.password}" /></td>
                    <td><c:out value="${cliente.birthDate}" /></td>
                    <% if (role.equals("admin")) { %>
                    <td>
                        <a href="edicao?email=<c:out value='${cliente.email}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocao?email=<c:out value='${cliente.email}' />"
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a>
                    </td>
                    <% } %>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>