<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Lokabike | Lista Locacao</title>
    </head>
    <body>
    <%@include  file="menu.jsp" %>
    
    <div class="content">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Locacao</h2></caption>
            <tr>
                <th>ID</th>
                <th>CNPJ</th>
                <th>CPF</th>
                <th>Data de Aluguel</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="locacao" items="${listaLocacaos}">
                <tr>
                    <td><c:out value="${locacao.ID}" /></td>
                    <td><c:out value="${locacao.CNPJ}" /></td>
                    <td><c:out value="${locacao.CPF}" /></td>
                    <td><c:out value="${locacao.rentDate}" /></td>

                    <td>
                        <a href="/locacao/edicao?ID=<c:out value='${locacao.ID}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/locacao/remocao?ID=<c:out value='${locacao.ID}' />"
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