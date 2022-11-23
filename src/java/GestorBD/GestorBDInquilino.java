package GestorBD;

import Modelo.Inquilino;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorBDInquilino {

    GestorBDConexion gestorBDConexion = new GestorBDConexion();

    public ArrayList<Inquilino> ObtenerTodosLosInquilinos() throws SQLException {
        ArrayList<Inquilino> lista = new ArrayList<>();
        Inquilino i = null;
        try {
            gestorBDConexion.AbrirConexion();

            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("SELECT * FROM Inquilino");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idInquilino");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String domicilio = rs.getString("domicilio");
                String telefono = rs.getString("telefono");

                i = new Inquilino(id, nombre, apellido, dni, domicilio, telefono);
                lista.add(i);
            }

            rs.close();
            stmt.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            gestorBDConexion.CerrarConexion();
        }

        return lista;
    }

    public boolean EliminarInquilino(int id) throws SQLException {
        int result = 0;
        try {
            gestorBDConexion.AbrirConexion();

//            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("EXEC sp_del_Servicio (?)");
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("DELETE FROM Inquilino WHERE idInquilino = ?");
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

    public Inquilino ObtenerInquilino(int id) throws SQLException {
        Inquilino i = null;

        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("SELECT * FROM Inquilino WHERE idInquilino = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String domicilio = rs.getString("domicilio");
                String telefono = rs.getString("telefono");

                i = new Inquilino(id, nombre, apellido, dni, domicilio, telefono);
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

    public boolean AgregarInquilino(Inquilino i) {
        boolean b = false;
        int filasAfectadas = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("INSERT INTO Inquilino(nombre, apellido, dni, domicilio, telefono) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getApellido());
            stmt.setString(3, i.getDni());
            stmt.setString(4, i.getDomicilio());
            stmt.setString(5, i.getTelefono());

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

    public boolean ModificarInquilino(Inquilino i) throws SQLException {
        int filasAfectadas = 0;
        try {
            gestorBDConexion.AbrirConexion();
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("UPDATE Inquilino SET nombre=?, apellido=?, dni=?, domicilio=?, telefono=? WHERE idInquilino=?");
            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getApellido());
            stmt.setString(3, i.getDni());
            stmt.setString(4, i.getDomicilio());
            stmt.setString(5, i.getTelefono());
            stmt.setInt(6, i.getIdInquilino());

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
