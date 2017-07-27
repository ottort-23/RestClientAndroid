package edu.mariano.android.umg_asignaciones.entitys;

/**
 * Created by Ottoniel RT on 27/07/2017.
 */

public class Carrera {

    private int id;
    private int codigoFacultad;
    private String codigo;
    private String nombre;
    private String estatus;

    public Carrera(int id, int codigoFacultad, String codigo, String nombre, String estatus) {
        this.id = id;
        this.codigoFacultad = codigoFacultad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public int getCodigoFacultad() {
        return codigoFacultad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstatus() {
        return estatus;
    }
}
