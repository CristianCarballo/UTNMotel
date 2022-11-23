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
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("cerrar")) {
            HttpSession sesion = request.getSession();
            sesion.removeAttribute("usuario");

            sesion.invalidate();

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

        if (accion != null && accion.equals("ingresar")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correoElectronico = request.getParameter("txtUsuario");
        String contraseña = request.getParameter("txtPass");

        GestorBDUsuario gestorDBUsuario = new GestorBDUsuario();

        Usuario usuario = new Usuario(correoElectronico, contraseña);

        boolean existe = gestorDBUsuario.ExisteUsuario(usuario);

        if (existe) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            
            sesion.setMaxInactiveInterval(600);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/inicioCorrecto.jsp");
            rd.forward(request, response);

        } else {
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
