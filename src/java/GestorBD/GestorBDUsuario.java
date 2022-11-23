package GestorBD;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GestorBDUsuario {

    GestorBDConexion gestorBDConexion = new GestorBDConexion();

    public boolean ExisteUsuario(Usuario usuario) {
        boolean existe = false;
        try {
            gestorBDConexion.AbrirConexion();
            String sql = "select * from Usuario WHERE correoElectronico = ? AND contrasena = ?";
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement(sql);
            stmt.setString(1, usuario.getCorreoElectronico());
            stmt.setString(2, usuario.getContraseña());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                existe = true;
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }

        return existe;
    }

    public void NuevoUsuario(Usuario usuario) {
        try {
            gestorBDConexion.AbrirConexion();

            String sql = "insert into Usuario (correoElectronico, contrasena) values (?,?)";

            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement(sql);
            stmt.setString(1, usuario.getCorreoElectronico());
            stmt.setString(2, usuario.getContraseña());
            ResultSet rs = stmt.executeQuery();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }
    }
}
