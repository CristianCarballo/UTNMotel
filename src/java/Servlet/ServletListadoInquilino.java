package Servlet;

import GestorBD.GestorBDInquilino;
import Modelo.Inquilino;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletListadoInquilino", urlPatterns = {"/ServletListadoInquilino"})
public class ServletListadoInquilino extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            GestorBDInquilino gestorBDInquilino = new GestorBDInquilino();
            ArrayList<Inquilino> lista = gestorBDInquilino.ObtenerTodosLosInquilinos();

            request.setAttribute("lista", lista);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoInquilino.jsp");
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
