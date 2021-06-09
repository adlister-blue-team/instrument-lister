package controllers;

import dao.DaoFactory;
import models.Instrument;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "controllers.CreateInstrumentServlet", urlPatterns = "/instruments/create")
public class CreateInstrumentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        }
        else {
            request.getRequestDispatcher("/WEB-INF/instruments/create.jsp")
                    .forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        user.setId(DaoFactory.getUsersDao().getUserId(user.getUsername()));
        Instrument instrument = new Instrument(
                request.getParameter("name"),
                request.getParameter("description"),
                user,
                Float.parseFloat(request.getParameter("price")),
                request.getParameter("shippingMethod"),
                request.getParameter("paymentType"),
                new ArrayList<>(Arrays.asList(request.getParameter("types")))
        );
        DaoFactory.getInstrumentsDao().insertInstrument(instrument);
        response.sendRedirect("/instruments");
    }
}
