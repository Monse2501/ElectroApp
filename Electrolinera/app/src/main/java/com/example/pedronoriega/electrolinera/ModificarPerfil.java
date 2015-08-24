package com.example.pedronoriega.electrolinera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

    String correo;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    int edad;
    String genero;
    String estado;



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
        btnModificar = (Button)findViewById(R.id.btnModificar);

        Bundle bundle = getIntent().getExtras();  //Recuperamos los datos de la actividad de iniciar sesion
        correo = bundle.getString("email");
        String bnombre = bundle.getString("nombre");
        String bapellidoPaterno = bundle.getString("aPat");
        String bapellidoMaterno = bundle.getString("aMat");
        int bedad = bundle.getInt("edad");
        String bgenero = bundle.getString("genero");
        String bestado = bundle.getString("estado");

        etNombre.setText(bnombre);
        etApellidoPaterno.setText(bapellidoPaterno);
        etApellidoMaterno.setText(bapellidoMaterno);
        etFechaNacimiento.setText(bedad+"");
        etGenero.setText(bgenero);
        etEstado.setText(bestado);





        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = etNombre.getText().toString();
                apellidoPaterno = etApellidoPaterno.getText().toString();
                apellidoMaterno = etApellidoMaterno.getText().toString();
                edad = Integer.parseInt(etFechaNacimiento.getText().toString());
                genero = etGenero.getText().toString();
                estado = etEstado.getText().toString();

                Usuario usuario = new Usuario(correo,nombre,apellidoPaterno,apellidoMaterno,genero,edad,estado);
                verMiPerfil(usuario);
            }
        });



    }

    private void verMiPerfil(Usuario usuario){
        WSModificarPerfil wsModificarPerfil =new WSModificarPerfil(this);
        wsModificarPerfil.modificarPerfilInBackground(usuario, new GetUserCallback() {
            @Override
            public void done(Usuario returnedUsuario) {

            }
        });
    }
}
