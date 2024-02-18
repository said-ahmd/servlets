package org.eclipse.jakarta.hello;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jakarta.hello.dao.ProductDao;
import org.eclipse.jakarta.hello.dao.ProductDaoImpl;
import org.eclipse.jakarta.hello.Entity.Product;
import org.eclipse.jakarta.hello.dao.ProductSingleton;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    private ProductDao productDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productDao = ProductSingleton.getInstance();

        List<Product> products = productDao.getProducts();

        req.setAttribute("products", products);
        RequestDispatcher productsPage = req.getRequestDispatcher("Products.jsp");
        productsPage.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
