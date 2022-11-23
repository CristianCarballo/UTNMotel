package Servlet;

import GestorBD.GestorBDFoto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletEliminarHabitacionImagen", urlPatterns = {"/ServletEliminarHabitacionImagen"})
public class ServletEliminarHabitacionImagen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            GestorBDFoto gestorBDFoto = new GestorBDFoto();
            int id = Integer.parseInt(request.getParameter("id"));
            String descripcion = request.getParameter("descripcion");

//          **********************************AQUÍ********************************************
            Path imagesPath = Paths.get("C:\\Users\\barto\\Google Drive\\@UTN\\TP DAyBD y Lab\\2W1_110218\\UTNMotel\\web\\" + descripcion);

            Files.delete(imagesPath);

            System.out.println(id);

            boolean exito = gestorBDFoto.EliminarFoto(id);

            if (exito) {
                response.sendRedirect("/UTNMotel/ServletListadoHabitacion");
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
