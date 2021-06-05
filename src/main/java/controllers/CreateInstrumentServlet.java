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

@WebServlet(name = "controllers.CreateInstrumentServlet", urlPatterns = "/instruments/create")
public class CreateInstrumentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Instrument instrument = new Instrument(
                user.getId(),
                request.getParameter("name"),
                request.getParameter("description"),
                Long.parseLong(request.getParameter("ownedId")),
                Float.parseFloat(request.getParameter("price")),
                request.getParameter("shippingMethod"),
                request.getParameter("paymentType")
        );
        DaoFactory.getInstrumentsDao().insertInstrument(instrument);
        response.sendRedirect("/ads");

    }
}
