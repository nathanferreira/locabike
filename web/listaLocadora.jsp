<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Lokabike | Lista Locadoras</title>
    </head>
    <body>
    <%@include  file="menu.jsp" %>
    
    <div class="content">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Locadora</h2></caption>
            <tr>
                <th>CNPJ</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Cidade</th>
                <% if (role.equals("admin")) { %>
                <th>Senha</th>
                <th>Ações</th>
                <% } %>
            </tr>
            <c:forEach var="locadora" items="${listaLocadoras}">
                <tr>
                    <td><c:out value="${locadora.CNPJ}" /></td>
                    <td><c:out value="${locadora.name}" /></td>
                    <td><c:out value="${locadora.email}" /></td>
                    <td><c:out value="${locadora.city}" /></td>
                    <% if (role.equals("admin")) { %>
                    <td><c:out value="${locadora.password}" /></td>
                    
                    <td>
                        <a href="/locadora/edicao?email=<c:out value='${locadora.email}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/locadora/remocao?email=<c:out value='${locadora.email}' />"
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