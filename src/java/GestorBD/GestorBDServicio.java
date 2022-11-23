package GestorBD;

import Modelo.Servicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorBDServicio {

    GestorBDConexion gestorBDConexion = new GestorBDConexion();

    public ArrayList<Servicio> ObtenerTodosLosServicios() throws SQLException {
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        Servicio servicio = null;
        try {
            gestorBDConexion.AbrirConexion();

            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("SELECT * FROM Servicio");
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idServicio = rs.getInt("idServicio");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");

                servicio = new Servicio(idServicio, descripcion, precio);
                listaServicios.add(servicio);
            }

            rs.close();
            stmt.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }

        return listaServicios;
    }

    public boolean EliminarServicio(int id) throws SQLException {
        int result = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("DELETE FROM Servicio WHERE idServicio = ?");
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

    public Servicio ObtenerServicio(int id) throws SQLException {
        Servicio i = null;

        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("SELECT * FROM Servicio WHERE idServicio = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");

                i = new Servicio(id, descripcion, precio);
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

    public boolean AgregarServicio(Servicio i) {
        boolean b = false;
        int filasAfectadas = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("INSERT INTO Servicio(descripcion, precio) VALUES (?, ?)");
            stmt.setString(1, i.getDescripcion());
            stmt.setFloat(2, i.getPrecio());

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

    public boolean ModificarServicio(Servicio i) throws SQLException {
        int filasAfectadas = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("UPDATE Servicio SET descripcion=?, precio=? where idServicio=?");
            stmt.setString(1, i.getDescripcion());
            stmt.setFloat(2, i.getPrecio());
            stmt.setInt(3, i.getIdServicio());

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
