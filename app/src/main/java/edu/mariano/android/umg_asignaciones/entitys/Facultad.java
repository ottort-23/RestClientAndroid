package edu.mariano.android.umg_asignaciones.entitys;

/**
 * Created by Ottoniel RT on 27/07/2017.
 */

public class Facultad {

    private int idFacultad;
    private String codigo;
    private String nombre;
    private String estatus;

    public Facultad(int idFacultad, String codigo, String nombre, String estatus) {
        this.idFacultad = idFacultad;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public int getIdFacultad() {
        return idFacultad;
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
