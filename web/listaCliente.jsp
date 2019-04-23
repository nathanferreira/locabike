<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Lokabike | Lista Clientes</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento de Clientes</h1>
        <h2>
            <a href="/cliente/cadastro">Adicione Novo Cliente</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/cliente/lista">Lista de Clientes</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Cliente</h2></caption>
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Gender</th>
                <th>Password</th>
                <th>Birthdate</th>
                <th>Ações</th>
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

                    <td>
                        <a href="edicao?CPF=<c:out value='${cliente.CPF}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocao?CPF=<c:out value='${cliente.CPF}' />"
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