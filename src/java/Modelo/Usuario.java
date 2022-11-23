package Modelo;

public class Usuario {

    private int idUsuario;
    private String correoElectronico;
    private String contraseña;

    public Usuario(int idUsuario, String correoElectronico, String contraseña) {
        this.idUsuario = idUsuario;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
    }

    public Usuario(String correoElectronico, String contraseña) {
        this.idUsuario = -1;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return correoElectronico;
    }
}
