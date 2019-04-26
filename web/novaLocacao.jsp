<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>LOCABIKE</title>
    </head>
    <body>
        
    <%@include  file="menu.jsp" %>
    
    <div class="content">
        <c:if test="${locacao != null}">
            <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${locacao == null}">
                <form action="insercao" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${locacao != null}">
                                Edição
                            </c:if>
                            <c:if test="${locacao == null}">
                                Cadastro
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${locacao != null}">
                        <input type="hidden" name="ID" value="<c:out value='${locacao.ID}' />" />
                    </c:if>
                    <tr>
                        <th>CNPJ: </th>
                        <td>
                            <input type="text" name="CNPJ" size="45"
                                   value="<c:out value='${locacao.CNPJ}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>CPF: </th>
                        <td>
                            <input type="text" name="CPF" size="45"
                                   value="<c:out value='${locacao.CPF}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Data de Aluguel: </th>
                        <td>
                            <input type="text" name="rentDate" size="45"
                                   value="<c:out value='${locacao.rentDate}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Salva" />
                        </td>
                    </tr>
                </table>
            </form>
    </div>
</body>
</html>