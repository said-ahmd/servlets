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
import java.util.List;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("productId");
        RequestDispatcher updatePage = request.getRequestDispatcher("UpdateProductPage.jsp");
        updatePage.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int productId = Integer.parseInt(id);

        String newName = request.getParameter("new-name");
        String price = request.getParameter("new-price");
        Double newPrice = Double.parseDouble(price);


//        ProductDao productDao = new ProductDaoImpl();

        ProductDao productDao = ProductSingleton.getInstance();
        productDao.updateProduct(productId,newName,newPrice);

        response.sendRedirect("/products");

    }
}
