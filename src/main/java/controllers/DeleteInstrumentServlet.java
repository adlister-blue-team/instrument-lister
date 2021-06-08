package controllers;
import dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteInstrumentServlet", urlPatterns = "/deleteInstrument")
public class DeleteInstrumentServlet extends HttpServlet{
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id =  Long.parseLong(request.getParameter("id"));
        DaoFactory.getInstrumentsDao().deleteInstrument(id);
        request.getSession().setAttribute("instruments", DaoFactory.getInstrumentsDao().getAllInstruments());
    }
}
