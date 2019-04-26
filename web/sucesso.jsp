<%
    if ((session.getAttribute("email") == null) || (session.getAttribute("email") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Por favor, se logue</a>
<%} else {
%>
Welcome <%=session.getAttribute("email")%>
Você esta logado como <%=session.getAttribute("role")%>
<a href='logout.jsp'>Log out</a>
<%
    }
%>