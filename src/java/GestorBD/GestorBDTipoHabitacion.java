package GestorBD;

import Modelo.TipoHabitacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorBDTipoHabitacion {

    GestorBDConexion gestorBDConexion = new GestorBDConexion();

    public ArrayList<TipoHabitacion> ObtenerTodosLosTipoHabitacion() throws SQLException {
        ArrayList<TipoHabitacion> listaTipoHabitacion = new ArrayList<>();
        TipoHabitacion tipoHabitacion = null;
        try {
            gestorBDConexion.AbrirConexion();

            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("SELECT * FROM TipoHabitacion");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idTipoHabitacion = rs.getInt("idTipoHabitacion");
                String descripcion = rs.getString("descripcion");
                int capacidad = rs.getInt("capacidad");
                float precio = rs.getFloat("precio");

                tipoHabitacion = new TipoHabitacion(idTipoHabitacion, descripcion, capacidad, precio);
                listaTipoHabitacion.add(tipoHabitacion);
            }

            rs.close();
            stmt.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }

        return listaTipoHabitacion;
    }

    public boolean EliminarTipoHabitacion(int id) throws SQLException {
        int result = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("DELETE FROM TipoHabitacion WHERE idTipoHabitacion = ?");
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

    public TipoHabitacion ObtenerTipoHabitacion(int id) throws SQLException {
        TipoHabitacion i = null;

        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("SELECT * FROM TipoHabitacion WHERE idTipoHabitacion = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int capacidad = rs.getInt("capacidad");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");

                i = new TipoHabitacion(id, descripcion, capacidad, precio);
            }
            rs.close();
            stmt.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }

        return i;
    }

    public boolean AgregarTipoHabitacion(TipoHabitacion i) {
        boolean b = false;
        int filasAfectadas = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("INSERT INTO TipoHabitacion(descripcion, capacidad, precio) VALUES (?, ?, ?)");
            stmt.setString(1, i.getDescripcion());
            stmt.setInt(2, i.getCapacidad());
            stmt.setFloat(3, i.getPrecio());

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

    public boolean ModificarTipoHabitacion(TipoHabitacion i) throws SQLException {
        int filasAfectadas = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("UPDATE TipoHabitacion SET capacidad=?, precio=? where idTipoHabitacion=?");
            stmt.setInt(1, i.getCapacidad());
            stmt.setFloat(2, i.getPrecio());
            stmt.setInt(3, i.getIdTipoHabitacion());

            filasAfectadas = stmt.executeUpdate();
            stmt.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }

        if (filasAfectadas > 0) {
            return true;
        } else {
            return false;
        }
    }
}
