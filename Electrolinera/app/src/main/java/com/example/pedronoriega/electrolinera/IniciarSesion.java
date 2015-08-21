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
        Intent i = new Intent(this, VerPerfil.class);
        i.putExtra("email",etcorreo.getText().toString());
        i.putExtra("contrasenia",etcontrasenia.getText().toString());
        startActivity(i);
    }
}
