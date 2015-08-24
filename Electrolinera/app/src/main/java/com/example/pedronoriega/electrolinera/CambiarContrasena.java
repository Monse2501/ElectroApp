package com.example.pedronoriega.electrolinera;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CambiarContrasena extends AppCompatActivity {

    EditText etContraseniaAnt;
    EditText etContraseniaNueva;
    EditText etRepContraseniaNueva;
    Button btnGuardar;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasena);

        Bundle bundle = getIntent().getExtras();  //Recuperamos los datos de la actividad de iniciar sesion
        email = bundle.getString("email"); //Guardamos el correo

        etContraseniaAnt = (EditText)findViewById(R.id.etContraseniaAnterior);
        etContraseniaNueva = (EditText)findViewById(R.id.etContraseniaNueva);
        etRepContraseniaNueva = (EditText)findViewById(R.id.etRepetirContrasenia);
        btnGuardar = (Button)findViewById(R.id.btnCambiarContrasenia);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contraseniaAnt = etContraseniaAnt.getText().toString();
                Usuario usuario = new Usuario(email,contraseniaAnt);
                consultarContrasenia(usuario);
            }
        });
    }

    private void consultarContrasenia(Usuario usuario){
        WSConsultarContrasenia wsConsultarContrasenia = new WSConsultarContrasenia(this);
        wsConsultarContrasenia.iniciarSesionInBackground(usuario, new GetUserCallback() {
            @Override
            public void done(Usuario returnedUsuario) {
                if (returnedUsuario == null) {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(CambiarContrasena.this);
                    dialogBuilder.setMessage("La contraseña anteior es incorrecta");
                    dialogBuilder.setPositiveButton("Ok", null);
                    dialogBuilder.show();
                    etContraseniaAnt.setText("");

                } else {
                    cambiarContrasenia(returnedUsuario);
                }
            }
        });


    }

    private void cambiarContrasenia(Usuario usuario){
        String contraseniaNueva = etContraseniaNueva.getText().toString();
        String repContraseniaNueva = etRepContraseniaNueva.getText().toString();

        if(contraseniaNueva.equals(repContraseniaNueva)){
            Usuario usuarioContraseniaNueva = new Usuario(usuario.email,contraseniaNueva);
            WSModificarContrasena wsModificarContrasena= new WSModificarContrasena(this);
            wsModificarContrasena.modificarContrasenaInBackground(usuarioContraseniaNueva, new GetUserCallback() {
                @Override
                public void done(Usuario returnedUsuario) {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(CambiarContrasena.this);
                    dialogBuilder.setMessage("La operación se ha realizado correctamente");
                    dialogBuilder.setPositiveButton("Ok", null);
                    dialogBuilder.show();
                }
            });
        }
        else{
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(CambiarContrasena.this);
            dialogBuilder.setMessage("La contraseña no coincide");
            dialogBuilder.setPositiveButton("Ok", null);
            dialogBuilder.show();
            etRepContraseniaNueva.setText("");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cambiar_contrasena, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
