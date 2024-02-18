
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session1 = request.getSession(false);

    System.out.println(session1+" "+session1.getAttribute("username"));

    if (session1 == null || session1.getAttribute("username") == null) {
    response.sendRedirect(request.getContextPath() + "/Login.jsp");
    return;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
    <form action="update" method="post">
        <pre> New name: <input type="text" name="new-name"></pre>
        <pre> New price: <input type="text" name="new-price"></pre>
        <pre> <input type="submit" value="update"></pre>
    </form>
</body>
</html>
