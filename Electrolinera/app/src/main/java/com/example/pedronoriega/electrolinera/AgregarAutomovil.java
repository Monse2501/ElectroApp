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

public class AgregarAutomovil extends AppCompatActivity {

    EditText etAnio;
    EditText etModelo;
    EditText etTipoAuto;
    EditText etMarca;
    Button btnAgregar;

    String email;
    String contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_automovil);

        Bundle bundle = getIntent().getExtras();  //Recuperamos los datos de la actividad de iniciar sesion
        email = bundle.getString("email"); //Guardamos el correo
        contrasenia = bundle.getString("contrasenia"); //Guardamos la contraseña

        etAnio = (EditText)findViewById(R.id.etAnio);
        etModelo = (EditText)findViewById(R.id.etModelo);
        etTipoAuto = (EditText)findViewById(R.id.etTipoAuto);
        etMarca = (EditText)findViewById(R.id.etMarca);
        btnAgregar = (Button)findViewById(R.id.btnAgregarAuto);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int anio = Integer.parseInt(etAnio.getText().toString());
                String modelo = etModelo.getText().toString();
                String tipoAuto = etTipoAuto.getText().toString();
                int marca = Integer.parseInt(etMarca.getText().toString());

                Usuario usuario = new Usuario(email,contrasenia);

                Automovil automovil = new Automovil(modelo,tipoAuto,marca,anio,usuario);
                agregarAutomovil(usuario,automovil);

            }
        });
    }

    public void agregarAutomovil(Usuario usuario,Automovil automovil)
    {
        WSAgregarAutomovil wsAgregarAutomovil = new WSAgregarAutomovil(this);
        wsAgregarAutomovil.agregarAutomovilInBackground(usuario, automovil, new GetAutomovilCallback() {
            @Override
            public void done(Automovil returnedAutomovil) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(AgregarAutomovil.this);
                dialogBuilder.setMessage("La operación se ha realizado correctamente");
                dialogBuilder.setPositiveButton("Ok", null);
                dialogBuilder.show();
                startActivity(new Intent(AgregarAutomovil.this,VerAutomovil.class));
            }
        });
    }

}
