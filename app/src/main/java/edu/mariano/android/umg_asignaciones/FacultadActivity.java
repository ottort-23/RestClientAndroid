package edu.mariano.android.umg_asignaciones;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import edu.mariano.android.umg_asignaciones.entitys.Carrera;
import edu.mariano.android.umg_asignaciones.entitys.Facultad;
import edu.mariano.android.umg_asignaciones.entitys.RespuestaJson;

public class FacultadActivity extends AppCompatActivity {

    public static String URL_HOST = "http://54.187.64.130/SampleWS/";

    EditText etCodigo, etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultad);

        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etNombre = (EditText) findViewById(R.id.etNombre);



    }

    public void cancel(View view) {
        etCodigo.setText("");
        etNombre.setText("");
    }

    public void login(View view) {
        Guardar guardar = new Guardar(etCodigo.getText().toString(), etNombre.getText().toString());
        guardar.execute();
    }

    private class Guardar extends AsyncTask<Void, Void, RespuestaJson> {

        private String codigo;
        private String nombre;

        Guardar(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;

        }

        @Override
        protected RespuestaJson doInBackground(Void... voids) {
            String estatus = "A";
            RestClient client = new RestClient(MainActivity.URL_HOST + "facultades");
            client.AddParam("codigo", codigo);
            client.AddParam("nombre", nombre);
            client.AddParam("estatus", estatus);
            try {
                client.Execute("POST");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String response = client.getResponse();
            Gson gson = new Gson();
            return gson.fromJson(response, RespuestaJson.class);
        }

        @Override
        protected void onPostExecute(RespuestaJson respuesta) {

            if(respuesta == null){
                Toast.makeText(FacultadActivity.this, "Error: No se logro guardar", Toast.LENGTH_SHORT).show();
            }else {
                if(respuesta.getStatus().equals("succes")){
                    Toast.makeText(FacultadActivity.this, "Facultad agregada con éxito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FacultadActivity.this, "Error: parámetros incorrectos", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }


}
