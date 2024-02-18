package org.eclipse.jakarta.hello;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jakarta.hello.dao.ProductDao;
import org.eclipse.jakarta.hello.dao.ProductDaoImpl;
import org.eclipse.jakarta.hello.dao.ProductSingleton;

import java.io.IOException;

@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
    private ProductDao productDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher addProductPage = request.getRequestDispatcher("AddProductPage.jsp");
        addProductPage.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("product-name");
        double price = Double.parseDouble(request.getParameter("price"));
        productDao = ProductSingleton.getInstance();
        productDao.addProduct(productName, price);

        response.sendRedirect("/products");
    }
}

