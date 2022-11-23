package Modelo;

public class Servicio {

    private int idServicio;
    private String descripcion;
    private float precio;

    public Servicio(int idServicio, String descripcion, float precio) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Servicio(String descripcion, float precio) {
        this.idServicio = -1;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
}
