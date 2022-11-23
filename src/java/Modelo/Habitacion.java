package Modelo;

public class Habitacion {

    private int idHabitacion;
    private TipoHabitacion tipoHabitacion;
    private String descripcion;

    public Habitacion(int idHabitacion, TipoHabitacion tipoHabitacion, String descripcion) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.descripcion = descripcion;
    }

    public Habitacion(TipoHabitacion tipoHabitacion, String descripcion) {
        this.idHabitacion = -1;
        this.tipoHabitacion = tipoHabitacion;
        this.descripcion = descripcion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", tipoHabitacion=" + tipoHabitacion + ", descripcion=" + descripcion + '}';
    }

}
