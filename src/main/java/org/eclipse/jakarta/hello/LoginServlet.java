package org.eclipse.jakarta.hello;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("here");
        RequestDispatcher loginPage = request.getRequestDispatcher("Login.jsp");
        loginPage.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String username = request.getParameter("user-name");
        String password = request.getParameter("password");
        System.out.println(username + password);

        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            if (RegisterServlet.userDatabase.containsKey(username)) {
                String storedPassword = RegisterServlet.userDatabase.get(username);
                if (password.equals(storedPassword)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username",username);

                    RequestDispatcher homePage = request.getRequestDispatcher("home");
                    homePage.forward(request, response);
                    return;
                }
            }
        }
        out.println("Login failed. Please check your username and password.");
    }
}
