package Servlet;

import GestorBD.GestorBDServicio;
import Modelo.Servicio;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletRegistrarServicio", urlPatterns = {"/ServletRegistrarServicio"})
public class ServletRegistrarServicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            if (request.getParameter("id") == null) {
                response.sendRedirect("/UTNMotel/registrarServicio.jsp");
            } else {
                int id = Integer.parseInt(request.getParameter("id"));

                GestorBDServicio gestorBDServicio = new GestorBDServicio();
                Servicio i = gestorBDServicio.ObtenerServicio(id);

                request.setAttribute("id", i.getIdServicio());
                request.setAttribute("descripcion", i.getDescripcion());
                request.setAttribute("precio", i.getPrecio());

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/registrarServicio.jsp");
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
            Float precio = Float.parseFloat(request.getParameter("txtPrecio"));

            Servicio i = new Servicio(id, descripcion, precio);
            GestorBDServicio gestorBDServicio = new GestorBDServicio();

            boolean exito;

            if (id == -1) {
                exito = gestorBDServicio.AgregarServicio(i);
            } else {
                exito = gestorBDServicio.ModificarServicio(i);
            }

            if (exito) {
                response.sendRedirect("/UTNMotel/ServletListadoServicio");
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
