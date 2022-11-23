package Modelo;

public class Foto {

    private int idFoto;
    private String descripcion;
    private int idHabitacion;

    public Foto(int idFoto, String descripcion, int idHabitacion) {
        this.idFoto = idFoto;
        this.descripcion = descripcion;
        this.idHabitacion = idHabitacion;
    }

    public Foto(String descripcion, int idHabitacion) {
        this.idFoto = -1;
        this.descripcion = descripcion;
        this.idHabitacion = idHabitacion;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

}
