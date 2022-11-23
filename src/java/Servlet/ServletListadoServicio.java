package Servlet;

import GestorBD.GestorBDServicio;
import Modelo.Servicio;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletListadoServicio", urlPatterns = {"/ServletListadoServicio"})
public class ServletListadoServicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            GestorBDServicio gestorBDServicio = new GestorBDServicio();
            ArrayList<Servicio> lista = gestorBDServicio.ObtenerTodosLosServicios();

            request.setAttribute("lista", lista);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoServicio.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
