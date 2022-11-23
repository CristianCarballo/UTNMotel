package Servlet;

import GestorBD.GestorBDInquilino;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEliminarInquilino", urlPatterns = {"/ServletEliminarInquilino"})
public class ServletEliminarInquilino extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            GestorBDInquilino gestorBDInquilino = new GestorBDInquilino();
            boolean exito = gestorBDInquilino.EliminarInquilino(id);

            if (exito) {
                response.sendRedirect("/UTNMotel/ServletListadoInquilino");
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
