package Servlet;

import GestorBD.GestorBDTipoHabitacion;
import Modelo.TipoHabitacion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletRegistrarTipoHabitacion", urlPatterns = {"/ServletRegistrarTipoHabitacion"})
public class ServletRegistrarTipoHabitacion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            if (request.getParameter("id") == null) {
                response.sendRedirect("/UTNMotel/registrarTipoHabitacion.jsp");
            } else {
                int id = Integer.parseInt(request.getParameter("id"));

                GestorBDTipoHabitacion gestorBDTipoHabitacion = new GestorBDTipoHabitacion();
                TipoHabitacion i = gestorBDTipoHabitacion.ObtenerTipoHabitacion(id);

                request.setAttribute("id", i.getIdTipoHabitacion());
                request.setAttribute("descripcion", i.getIdTipoHabitacion());
                request.setAttribute("capacidad", i.getCapacidad());
                request.setAttribute("precio", i.getPrecio());

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/registrarTipoHabitacion.jsp");
                rd.forward(request, response);
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

        try {
            int id;
            if (request.getParameter("txtId").equals("")) {
                id = -1;
            } else {
                id = Integer.parseInt(request.getParameter("txtId"));
            }

            String descripcion = request.getParameter("txtDescripcion");
            int capacidad = Integer.parseInt(request.getParameter("txtCapacidad"));
            float precio = Float.parseFloat(request.getParameter("txtPrecio"));

            TipoHabitacion i = new TipoHabitacion(id, descripcion, capacidad, precio);

            GestorBDTipoHabitacion gestorBDTipoHabitacion = new GestorBDTipoHabitacion();

            boolean exito;

            if (id == -1) {
                exito = gestorBDTipoHabitacion.AgregarTipoHabitacion(i);
            } else {
                exito = gestorBDTipoHabitacion.ModificarTipoHabitacion(i);
            }

            if (exito) {
                response.sendRedirect("/UTNMotel/ServletListadoTipoHabitacion");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
