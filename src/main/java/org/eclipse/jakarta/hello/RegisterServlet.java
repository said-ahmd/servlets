package org.eclipse.jakarta.hello;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public static Map<String, String> userDatabase;

    @Override
    public void init() throws ServletException {
        userDatabase = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher addProductPage = request.getRequestDispatcher("Register.jsp");
        addProductPage.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("user-name");
        String password = request.getParameter("password");

        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {

            if (userDatabase.containsKey(username)) {
                response.getWriter().println("The user exist.");
            } else {
                userDatabase.put(username, password);

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("The user created successfully");
                response.sendRedirect("login");
            }
        }
    }
}
