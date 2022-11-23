package Servlet;

import GestorBD.GestorBDInquilino;
import Modelo.Inquilino;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletRegistrarInquilino", urlPatterns = {"/ServletRegistrarInquilino"})
public class ServletRegistrarInquilino extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            if (request.getParameter("id") == null) {
                response.sendRedirect("/UTNMotel/registrarInquilino.jsp");
            } else {
                int id = Integer.parseInt(request.getParameter("id"));

                GestorBDInquilino gestorBDInquilino = new GestorBDInquilino();
                Inquilino i = gestorBDInquilino.ObtenerInquilino(id);

                request.setAttribute("id", i.getIdInquilino());
                request.setAttribute("nombre", i.getNombre());
                request.setAttribute("apellido", i.getApellido());
                request.setAttribute("dni", i.getDni());
                request.setAttribute("domicilio", i.getDomicilio());
                request.setAttribute("telefono", i.getTelefono());

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/registrarInquilino.jsp");
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
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String dni = request.getParameter("txtDni");
            String domicilio = request.getParameter("txtDomicilio");
            String telefono = request.getParameter("txtTelefono");

            Inquilino i = new Inquilino(id, nombre, apellido, dni, domicilio, telefono);
            GestorBDInquilino gestorBDInquilino = new GestorBDInquilino();

            boolean exito;

            if (id == -1) {
                exito = gestorBDInquilino.AgregarInquilino(i);
            } else {
                exito = gestorBDInquilino.ModificarInquilino(i);
            }

            if (exito) {
                response.sendRedirect("/UTNMotel/ServletListadoInquilino");
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
