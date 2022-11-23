package Servlet;

import GestorBD.GestorBDFoto;
import GestorBD.GestorBDHabitacion;
import Modelo.Foto;
import Modelo.Habitacion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletListadoHabitacion", urlPatterns = {"/ServletListadoHabitacion"})
public class ServletListadoHabitacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            GestorBDHabitacion gestorBDHabitacion = new GestorBDHabitacion();

            ArrayList<Habitacion> lista = gestorBDHabitacion.ObtenerTodasLasHabitaciones();
            request.setAttribute("lista", lista);

            GestorBDFoto gestorBDFoto = new GestorBDFoto();
            ArrayList<Foto> fotos = gestorBDFoto.ObtenerFotos();
            request.setAttribute("fotos", fotos);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoHabitacion.jsp");
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
