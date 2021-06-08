package controllers;

import dao.DaoFactory;
import dao.MySQLUsersDao;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/deleteUser/*")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String deleteUser = request.getPathInfo(); //grabbing the path that the servlet is set to
        String getUsername = (deleteUser.substring(1)); //gets the username from the url
        DaoFactory.getUsersDao().deleteUser(getUsername); //access the DAO methods
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();

        response.sendRedirect("/welcome");

    }
}

