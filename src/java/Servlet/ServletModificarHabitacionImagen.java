package Servlet;

import GestorBD.GestorBDFoto;
import Modelo.Foto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "ServletModificarHabitacionImagen", urlPatterns = {"/ServletModificarHabitacionImagen"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5,
        location = "C:\\Users\\barto\\Google Drive\\@UTN\\TP DAyBD y Lab\\2W1_110218\\UTNMotel\\web\\ImagenesHabitaciones")

public class ServletModificarHabitacionImagen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        try {
            ArrayList<Foto> lista = new ArrayList<>();

            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("id", id);

            GestorBDFoto gestorBDFoto = new GestorBDFoto();
            lista = gestorBDFoto.ObtenerFotos(id);
            request.setAttribute("lista", lista);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarHabitacionImagen.jsp");
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

        for (Part part : request.getParts()) {
            String fileName = getFileName(part);
            if (!fileName.isEmpty()) {
                part.write(fileName);

                String descripcion = "ImagenesHabitaciones/" + fileName;
                int idHabitacion = Integer.parseInt(request.getParameter("txtIdHabitacion"));
                
                Foto foto = new Foto(descripcion, idHabitacion);
                GestorBDFoto gestorBDFoto = new GestorBDFoto();

                gestorBDFoto.AgregarFoto(foto);

                response.sendRedirect("/UTNMotel/ServletListadoHabitacion");
            }
        }
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
