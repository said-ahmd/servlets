<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.eclipse.jakarta.hello.dao.ProductDao" %>
<%@ page import="org.eclipse.jakarta.hello.Entity.Product" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    System.out.println("send redirect to me");
%>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    <%-- Iterate over the list of products and display each product --%>
    <% for (Product product : products) { %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getProductName() %></td>
        <td>$<%= product.getPrice() %></td>
        <td>
            <form action="delete" method="post" style="display: inline;">
                <input type="hidden" name="productId" value="<%= product.getId() %>">
                <input type="submit" value="Delete">
            </form>
            <form action="update" method="get" style="display: inline;">
                <input type="hidden" name="productId" value="<%= product.getId() %>">
                <input type="submit" value="Update">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<br>
<a href="add">Add New Product</a>
</body>
</html>
