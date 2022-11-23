package Servlet;

import GestorBD.GestorBDUsuario;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

@WebServlet(name = "ServletRegistrarse", urlPatterns = {"/ServletRegistrarse"})
public class ServletRegistrarse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correoElectronico = request.getParameter("txtUsuario");
        String contraseña = request.getParameter("txtPass");

        GestorBDUsuario gestorDBUsuario = new GestorBDUsuario();
        Usuario usuario = new Usuario(correoElectronico, contraseña);

        gestorDBUsuario.NuevoUsuario(usuario);

        request.getSession().setAttribute("usuario", usuario);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioCorrecto.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
