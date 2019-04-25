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
        <c:if test="${locadora != null}">
            <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${locadora == null}">
                <form action="insercao" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${locadora != null}">
                                Edição
                            </c:if>
                            <c:if test="${locadora == null}">
                                Cadastro
                            </c:if>
                        </h2>
                    </caption>

                    <tr>
                        <th>CNPJ: </th>
                        <td>
                            <input type="text" name="CNPJ" size="45"
                                   value="<c:out value='${locadora.CNPJ}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Email: </th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${locadora.email}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="text" name="password" size="45"
                                   value="<c:out value='${locadora.password}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Cidade: </th>
                        <td>
                            <input type="text" name="city" size="5"
                                   value="<c:out value='${locadora.city}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="name" size="5"
                                   value="<c:out value='${locadora.name}' />"
                                   />
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