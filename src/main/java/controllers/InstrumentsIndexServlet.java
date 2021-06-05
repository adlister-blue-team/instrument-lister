package controllers;


import dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.InstrumentsIndexServlet", urlPatterns = "/instruments")
public class InstrumentsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("instruments", DaoFactory.getInstrumentsDao().getAllInstruments());
        request.getRequestDispatcher("/WEB-INF/instruments/index.jsp").forward(request, response);
    }
}