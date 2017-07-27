package edu.mariano.android.umg_asignaciones.entitys;

/**
 * Created by Ottoniel RT on 27/07/2017.
 */

public class RespuestaJson {

    private String status;
    private String message;

    public RespuestaJson(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
