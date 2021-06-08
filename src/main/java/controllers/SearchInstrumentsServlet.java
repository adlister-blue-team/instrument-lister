package controllers;
import dao.DaoFactory;
import models.Instrument;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchInstrumentsServlet", urlPatterns = "/searchInstruments")
    public class SearchInstrumentsServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String name = request.getParameter("name");
            request.getSession().setAttribute("instruments", DaoFactory.getInstrumentsDao().searchInstrumentsByName(name));
            request.getRequestDispatcher("/WEB-INF/instruments/index.jsp").forward(request, response);
        }
    }

