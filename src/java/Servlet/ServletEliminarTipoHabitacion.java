package Servlet;

import GestorBD.GestorBDTipoHabitacion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEliminarTipoHabitacion", urlPatterns = {"/ServletEliminarTipoHabitacion"})
public class ServletEliminarTipoHabitacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            GestorBDTipoHabitacion gestorBDTipoHabitacion = new GestorBDTipoHabitacion();

            boolean exito = gestorBDTipoHabitacion.EliminarTipoHabitacion(id);

            if (exito) {
                response.sendRedirect("/UTNMotel/ServletListadoTipoHabitacion");
            }

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
