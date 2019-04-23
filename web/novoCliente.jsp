<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>LOCABIKE</title>
    </head>
    <body>
    <center>
        <h1>Gerenciamento de Clientes</h1>
        <h2>
            <a href="new">Adicione Novo Cliente</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lista">Lista de Clientes</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${cliente != null}">
            <form action="atualizacao" method="post">
            </c:if>
            <c:if test="${cliente == null}">
                <form action="insercao" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${cliente != null}">
                                Edição
                            </c:if>
                            <c:if test="${cliente == null}">
                                Cadastro
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${cliente != null}">
                        <input type="hidden" name="CPF" value="<c:out value='${cliente.CPF}' />" />
                    </c:if>
                    <tr>
                        <th>Email: </th>
                        <td>
                            <input type="text" name="email" size="45"
                                   value="<c:out value='${cliente.email}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Senha: </th>
                        <td>
                            <input type="text" name="password" size="45"
                                   value="<c:out value='${cliente.password}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Gênero: </th>
                        <td>
                            <input type="text" name="gender" size="5"
                                   value="<c:out value='${cliente.gender}' />"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Telefone: </th>
                        <td>
                            <input type="text" name="phone" size="5"
                                   value="<c:out value='${cliente.phone}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Nome: </th>
                        <td>
                            <input type="text" name="name" size="5"
                                   value="<c:out value='${cliente.name}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Data de Nascimento: </th>
                        <td>
                            <input type="text" name="birthDate" size="5"
                                   value="<c:out value='${cliente.birthDate}' />"
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