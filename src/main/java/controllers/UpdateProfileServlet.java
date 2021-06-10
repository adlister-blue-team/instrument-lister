package controllers;

import dao.DaoFactory;
import models.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "UpdateProfileServlet", urlPatterns = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtain submitted form data
        User updatedUser = (User) req.getSession().getAttribute("user");
        User userInDB = DaoFactory.getUsersDao().getUserById(updatedUser.getId());
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password =req.getParameter("password");

        userInDB.setFirstName(firstName);
        userInDB.setLastName(lastName);
        userInDB.setUsername(username);
        userInDB.setEmail(email);
        //if password not null and not empty string set password to current password.
//        userInDB.setPassword(password);
//        String usernameSession = (String) req.getSession().getAttribute("username");
        req.getSession().setAttribute("user",DaoFactory.getUsersDao().updateUser( userInDB));

        resp.sendRedirect("/profile");

  }
}
