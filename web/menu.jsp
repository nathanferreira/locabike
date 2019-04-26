<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    body, html, ul{
        margin: 0;
        padding: 0;
    }
    #header{
        background-color: #333;
        padding: 10px;
        margin:0;
    }

    .titulo{
        font-size:20px;
        color:#fff;
    }
    .logado{
        color:#fff;
        position:absolute;
        top: 10px;
        right:15px;
    }
    #menu{
        width: 200px;
        height: 100%;
        background-color: #ccc;
        margin-right:30px;
        padding: 10px;
        float: left;
    }
    #menu li{
        list-style: none;
        padding: 5px;
    }
    #menu li a{
        font-style: none;
        color:#666;
    }
    #menu li a:hover{
        color:#000;
    }

    .content{
        padding: 0px;
    }
    table, td, th {  
        border: 2px solid #ccc;
        text-align: left;
    }

    table {
        border-collapse: collapse;
    }

    th, td {
        padding: 10px;
    }
    input{
        padding: 5px;
    }

</style>

<div id="header">
    <h1 class="titulo">Loca Bike</h1>

    <p class="logado">
        <%
            String role = "";
            if ((session.getAttribute("role") == null) || (session.getAttribute("role") == "")) {
                out.print("Você não está logado");
            } else {
                out.print("Logado como: " + session.getAttribute("role"));
                role = session.getAttribute("role").toString();
            }
        %>
    </p>
</div>

<div id="menu" >
    <ul>
        <li><a href="/locadora/lista">Lista de Locadoras</a></li>

        <% if (role.equals("admin")) { %>
        <li><a href="/cliente/cadastro">Adicione Novo Cliente</a></li>   
        <li><a href="/locadora/cadastro">Adicione Nova Locadora</a></li>
        <li><a href="/admin/cadastro">Adicione novo Usuario</a></li>
        <li><a href="/admin/lista">Lista de Usuarios</a></li>
        <li><a href="/cliente/lista">Lista de Clientes</a></li>
        <li><a href="/locacao/lista">Lista de Locacoes</a></li>
        <li><a href="/locacao/cadastro">Adicione nova Locacao</a></li>
            <% } else if (role.equals("cliente")) { %>
        <li><a href="/locacao/lista">Lista de Locacoes</a></li>
        <li><a href="/locacao/cadastro">Adicione nova Locacao</a></li>
            <% } else if (role.equals("locadora")) { %>
        <li><a href="/locacao/lista">Lista de Locacoes</a></li>
            <% }%>

        <% if (session.getAttribute("role") == null) { %>

        <li><a href="/index.jsp">Login</a></li>
            <% } else {%>
        <li><a href="/logout.jsp">Logout</a></li>
            <% }%>

    </ul>

    <div style="clear:both;"></div>
</div>
