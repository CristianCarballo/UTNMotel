package Modelo;

public class Inquilino {

    private int idInquilino;
    private String nombre;
    private String apellido;
    private String dni;
    private String domicilio;
    private String telefono;

    public Inquilino(int idInquilino, String nombre, String apellido, String dni, String domicilio, String telefono) {
        this.idInquilino = idInquilino;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Inquilino(String nombre, String apellido, String dni, String domicilio, String telefono) {
        this.idInquilino = -1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Inquilino{" + "idInquilino=" + idInquilino + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }
}
