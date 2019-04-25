<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>LOCABIKE</title>
    </head>
    <body>
        
    <%@include  file="menu.html" %>
    
    <div align="center">
        <c:if test="${usuario != null}">
            <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${usuario == null}">
                <form action="insercao" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${usuario != null}">
                                Edição
                            </c:if>
                            <c:if test="${usuario == null}">
                                Cadastro
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${usuario != null}">
                        <input type="hidden" name="email" value="<c:out value='${usuario.email}' />" />
                    </c:if>
                    <c:if test="${usuario == null}">
                    <tr>
                        <th>Email: </th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${usuario.email}' />"/>
                        </td>
                    </tr>
                    </c:if>
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="text" name="password" size="45"
                                   value="<c:out value='${usuario.password}' />"/>
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