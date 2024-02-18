<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    HttpSession session1 = request.getSession(false);

    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect("Login.jsp");
        return;
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="add" method="post" >
    <pre>product name:  <input type="text" name="product-name"> </pre>
    <pre>price:  <input type="text" name="price"> </pre>
    <input type="submit" value="Save">
</form>

</body>
</html>
