package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.DaoFactory;
import models.User;
import util.Password;


@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = Password.hash(request.getParameter("password"));
        String confirmPassword = request.getParameter("confirm-password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");

        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || !Password.check(confirmPassword, password) || first_name.isEmpty() || last_name.isEmpty() ) {
            response.sendRedirect("/register");
        }
        else {
            User registeredUser = new User(username, email, password,first_name,last_name);
            DaoFactory.getUsersDao().insertUser(registeredUser);
            //verify hash passwords here and in login jsp
            request.getSession().setAttribute("user", registeredUser);
            response.sendRedirect("/profile");
        }
    }
}
