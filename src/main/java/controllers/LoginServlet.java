package controllers;
import dao.DaoFactory;
import models.User;
import util.Password;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = DaoFactory.getUsersDao().getUserByUsername(username);

            boolean validAttempt = Password.check(password, user.getPassword());

            if (validAttempt) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("/profile");
            } else {
                response.sendRedirect("/login");
            }
        }
    }


