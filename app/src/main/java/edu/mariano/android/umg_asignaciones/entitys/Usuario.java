package edu.mariano.android.umg_asignaciones.entitys;

/**
 * Created by Ottoniel RT on 27/07/2017.
 */

public class Usuario {

    private int id;
    private String nombre;
    private String contrasenia;

    public Usuario(int id, String nombre, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
