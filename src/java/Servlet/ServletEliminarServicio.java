package Servlet;

import GestorBD.GestorBDServicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEliminarServicio", urlPatterns = {"/ServletEliminarServicio"})
public class ServletEliminarServicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            GestorBDServicio gestorBDServicio = new GestorBDServicio();

            boolean exito = gestorBDServicio.EliminarServicio(id);

            if (exito) {
                response.sendRedirect("/UTNMotel/ServletListadoServicio");
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
