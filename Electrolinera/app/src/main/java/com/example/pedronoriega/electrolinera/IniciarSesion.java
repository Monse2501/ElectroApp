package com.example.pedronoriega.electrolinera;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IniciarSesion extends AppCompatActivity implements View.OnClickListener{

    EditText etcorreo;
    EditText etcontrasenia;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        etcorreo = (EditText)findViewById(R.id.etCorreo);
        etcontrasenia = (EditText)findViewById(R.id.etContrasenia);
        btnIniciarSesion = (Button)findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(this);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_iniciar_sesion, menu);
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

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btnIniciarSesion:

                String correo = etcorreo.getText().toString();
                String contrasenia = etcontrasenia.getText().toString();

                Usuario usuario = new Usuario(correo, contrasenia);
                authenticate(usuario);

                break;
        }
    }

    private void authenticate(Usuario usuario){
        WSIniciarSesion serverIniciarSesion = new WSIniciarSesion(this);
        serverIniciarSesion.iniciarSesionInBackground(usuario, new GetUserCallback() {
            @Override
            public void done(Usuario returnedUsuario) {
                if(returnedUsuario == null){
                    showErrorMessage();
                }else{
                    logUserIn(returnedUsuario);
                }
            }
        });
    }

    private void showErrorMessage(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(IniciarSesion.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();
    }

    private void logUserIn(Usuario returnedUser){

        startActivity(new Intent(this,MainActivity.class));
    }
}
