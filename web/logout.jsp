<%
session.setAttribute("email", null);
session.setAttribute("role", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>