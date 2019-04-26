<%
session.setAttribute("email", "");
session.setAttribute("role", "");
session.invalidate();
response.sendRedirect("index.jsp");
%>