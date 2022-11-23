package GestorBD;

import Modelo.Foto;
import Modelo.Habitacion;
import Modelo.TipoHabitacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorBDHabitacion {

    GestorBDConexion gestorBDConexion = new GestorBDConexion();

    public ArrayList<Habitacion> ObtenerTodasLasHabitaciones() throws SQLException {
        ArrayList<Habitacion> lista = new ArrayList<>();
        Habitacion habitacion = null;
        try {
            gestorBDConexion.AbrirConexion();

//            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("SELECT * FROM Habitacion h inner join Foto f on f.idHabitacion = h.idHabitacion inner join TipoHabitacion t on t.idTipoHabitacion=h.idTipoHabitacion");
            PreparedStatement stmt = gestorBDConexion.getConexion().prepareStatement("SELECT h.idHabitacion, h.idTipoHabitacion, h.descripcion as 'Desc Habitacion', t.idTipoHabitacion,t.capacidad,t.precio, t.descripcion as 'Desc Tipo' FROM Habitacion h inner join TipoHabitacion t on t.idTipoHabitacion=h.idTipoHabitacion");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idHabitacion = rs.getInt("idHabitacion");
                String descHabitacion = rs.getString("Desc Habitacion");

                int idTipoHabitacion = rs.getInt("idTipoHabitacion");
                String descTipo = rs.getString("Desc Tipo");
                int capacidad = rs.getInt("capacidad");
                Float precio = rs.getFloat("precio");

                TipoHabitacion tipoHabitacion = new TipoHabitacion(idTipoHabitacion, descTipo, capacidad, precio);

                habitacion = new Habitacion(idHabitacion, tipoHabitacion, descHabitacion);

                lista.add(habitacion);
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

    
}
