package edu.mariano.android.umg_asignaciones;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import edu.mariano.android.umg_asignaciones.entitys.Usuario;

public class MainActivity extends AppCompatActivity {

    public static String URL_HOST = "http://54.187.64.130/SampleWS/";

    EditText etUsuario, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etPass = (EditText) findViewById(R.id.etPass);

    }

    public void cancel(View view) {
        etPass.setText("");
        etUsuario.setText("");
    }

    public void login(View view) {
        Login login = new Login(etUsuario.getText().toString(), etPass.getText().toString());
        login.execute();
    }

    private class Login extends AsyncTask<Void, Void, Usuario> {

        private final String usuario;
        private String password;

        Login(String usuario, String password) {
            this.usuario = usuario;
            this.password = password;

        }

        @Override
        protected Usuario doInBackground(Void... voids) {
            RestClient client = new RestClient(MainActivity.URL_HOST + "usuarios/" + usuario);
            client.AddParam("usuario", usuario);
            try {
                client.Execute("GET");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String response = client.getResponse();
            if (response.length() > 0) {
                Gson gson = new Gson();
                //Usuario[] usuarios = gson.fromJson(response, Usuario[].class);
                return gson.fromJson(response, Usuario.class);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Usuario usuarioR) {
            if (usuarioR == null) {
                Toast.makeText(MainActivity.this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
            } else {


                if (usuarioR.getContrasenia().equals(password)) {
                    Toast.makeText(MainActivity.this, "Login correcto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, FacultadActivity.class);
                    intent.putExtra("usuario", new Gson().toJson(usuarioR.getNombre()));
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

}
