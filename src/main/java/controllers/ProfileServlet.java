package controllers;
import dao.DaoFactory;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User userSession = (User)request.getSession().getAttribute("user");
        userSession.setInstruments(DaoFactory.getUsersDao().getUserInstruments(userSession.getId()));
        request.getSession().setAttribute("user", userSession);
        if ( userSession != null) {
              request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request,response);
        }
        else { response.sendRedirect("/login"); }
    }
}
