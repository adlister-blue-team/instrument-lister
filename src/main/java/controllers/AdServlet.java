package controllers;

import dao.DaoFactory;
import dao.Instruments;
import models.Instrument;
import models.User;
import util.Password;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet(name = "AdServlet", urlPatterns = "/ViewInstrument")
public class AdServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));


        //inside Ads dao takes in id and return single ad, use that in here

      Instrument instrumentInfo= DaoFactory.getInstrumentsDao().getInstrumentById(id);
        //now send this to jsp

        request.setAttribute("SingleAd" , instrumentInfo);

        request.getRequestDispatcher("/WEB-INF/instruments/InstrumentPage.jsp").forward(request, response);

        //push it real good

        }

    }


