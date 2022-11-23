package GestorBD;

import Modelo.Foto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorBDFoto {

    GestorBDConexion gestorBDConexion = new GestorBDConexion();

    public boolean EliminarFoto(int id) throws SQLException {
        int result = 0;
        try {
            gestorBDConexion.AbrirConexion();

//          PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("EXEC sp_del_Servicio (?)");
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("DELETE FROM Foto WHERE idFoto = ?");
            stmt.setInt(1, id);

            result = stmt.executeUpdate();
            stmt.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean AgregarFoto(Foto i) {
        boolean b = false;
        int filasAfectadas = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("INSERT INTO Foto(descripcion, idHabitacion) VALUES (?, ?)");
            stmt.setString(1, i.getDescripcion());
            stmt.setInt(2, i.getIdHabitacion());

            filasAfectadas = stmt.executeUpdate();
            stmt.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }

        if (filasAfectadas > 0) {
            return b = true;
        } else {
            return b;
        }
    }

    public ArrayList<Foto> ObtenerFotos() throws SQLException {
        ArrayList<Foto> fotos = new ArrayList<>();
        Foto foto = null;
        try {
            gestorBDConexion.AbrirConexion();

            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("select idFoto, descripcion, idHabitacion from foto");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idFoto = rs.getInt("idFoto");
                String descripcionFoto = rs.getString("descripcion");
                int idHabitacion = rs.getInt("idHabitacion");

                foto = new Foto(idFoto, descripcionFoto, idHabitacion);

                fotos.add(foto);
            }

            rs.close();
            stmt.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }
        return fotos;
    }

    public ArrayList<Foto> ObtenerFotos(int id) throws SQLException {
        ArrayList<Foto> fotos = new ArrayList<>();
        Foto foto = null;
        try {
            gestorBDConexion.AbrirConexion();

            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("select idFoto, descripcion, idHabitacion from foto where idHabitacion = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idFoto = rs.getInt("idFoto");
                String descripcionFoto = rs.getString("descripcion");
                int idHabitacion = rs.getInt("idHabitacion");

                foto = new Foto(idFoto, descripcionFoto, idHabitacion);

                fotos.add(foto);
            }

            rs.close();
            stmt.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }
        return fotos;
    }
}
