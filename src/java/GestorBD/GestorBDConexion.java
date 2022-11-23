package GestorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBDConexion {

    private Connection con;

    public Connection getConexion() {
        return con;
    }

    public GestorBDConexion() {

    }

    public void AbrirConexion() {
        try {

//          **********************************AQUÍ********************************************
//          String url = "jdbc:sqlserver://172.16.140.13:1433;databaseName=";
            String url = "jdbc:sqlserver://KILLERBISS\\SQLEXPRESS:1433;databaseName=UTNMotel";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

//          **********************************AQUÍ********************************************
//          con = DriverManager.getConnection(url, "alumno1w1", "alumno1w1");
            con = DriverManager.getConnection(url, "sa", "123");

            System.out.println("Conexión a la BD");

        } catch (Exception e) {
            System.out.println("Error en conexión ");
        }
    }

    public void CerrarConexion() {
        try {
            con.close();
            System.out.println("Conexión cerrada");

        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión");
        }
    }
}
