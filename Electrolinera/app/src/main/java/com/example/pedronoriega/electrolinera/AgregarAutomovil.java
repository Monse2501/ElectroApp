package com.example.pedronoriega.electrolinera;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_automovil);

        Bundle bundle = getIntent().getExtras();  //Recuperamos los datos de la actividad de iniciar sesion
        String email = bundle.getString("email"); //Guardamos el correo

        etAnio = (EditText)findViewById(R.id.etAnio);
        etModelo = (EditText)findViewById(R.id.etModelo);
        etTipoAuto = (EditText)findViewById(R.id.etTipoAuto);
        etMarca = (EditText)findViewById(R.id.etMarca);
        btnAgregar = (Button)findViewById(R.id.btnAgregarAuto);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agregar_automovil, menu);
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
