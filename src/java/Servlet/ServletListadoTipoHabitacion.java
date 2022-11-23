package Servlet;

import GestorBD.GestorBDTipoHabitacion;
import Modelo.TipoHabitacion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletListadoTipoHabitacion", urlPatterns = {"/ServletListadoTipoHabitacion"})
public class ServletListadoTipoHabitacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            GestorBDTipoHabitacion gestorBDTipoHabitacion = new GestorBDTipoHabitacion();

            ArrayList<TipoHabitacion> lista = gestorBDTipoHabitacion.ObtenerTodosLosTipoHabitacion();

            request.setAttribute("lista", lista);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoTipoHabitacion.jsp");
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
