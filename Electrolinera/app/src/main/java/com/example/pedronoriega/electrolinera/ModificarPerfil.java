package com.example.pedronoriega.electrolinera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ModificarPerfil extends AppCompatActivity {

    EditText etNombre;
    EditText etApellidoPaterno;
    EditText etApellidoMaterno;
    EditText etFechaNacimiento;
    EditText etGenero;
    EditText etEstado;
    Button btnModificar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_perfil);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellidoPaterno = (EditText)findViewById(R.id.etApellidoPaterno);
        etApellidoMaterno = (EditText)findViewById(R.id.etApellidoMaterno);
        etFechaNacimiento = (EditText)findViewById(R.id.etEdad);
        etGenero = (EditText)findViewById(R.id.etGenero);
        etEstado = (EditText)findViewById(R.id.etEstado);

        Bundle bundle = getIntent().getExtras();  //Recuperamos los datos de la actividad de iniciar sesion
        String correo = bundle.getString("correo");
        String nombre = bundle.getString("nombre");
        String apellidoPaterno = bundle.getString("aPat");
        String apellidoMaterno = bundle.getString("aMat");
        int edad = bundle.getInt("edad");
        String genero = bundle.getString("genero");
        String estado = bundle.getString("estado");

        etNombre.setText(nombre);
        etApellidoPaterno.setText(apellidoPaterno);
        etApellidoMaterno.setText(apellidoMaterno);
        etFechaNacimiento.setText(edad+"");
        etGenero.setText(genero);
        etEstado.setText(estado);

        Usuario usuario = new Usuario(correo,nombre,apellidoPaterno,apellidoMaterno,genero,edad,estado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar_perfil, menu);
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
