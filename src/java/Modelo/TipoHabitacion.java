package Modelo;

public class TipoHabitacion {

    private int idTipoHabitacion;
    private String descripcion;
    private int capacidad;
    private float precio;

    public TipoHabitacion(int idTipoHabitacion, String descripcion, int capacidad, float precio) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public TipoHabitacion(String descripcion, int capacidad, float precio) {
        this.idTipoHabitacion = -1;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" + "idTipoHabitacion=" + idTipoHabitacion + ", descripcion=" + descripcion + ", capacidad=" + capacidad + ", precio=" + precio + '}';
    }

}
