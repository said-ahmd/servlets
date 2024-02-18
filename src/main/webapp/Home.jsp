<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Session Example</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession();

    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
        return;
    }

    String username = (String) session1.getAttribute("username");
%>

<h1>welcome to our small website <%= username %></h1>

<h2>use this button to go to the products</h2>
<form action="products" method="get">
    <input type="submit" name="products" value="goo!">
</form>
</body>
</html>
