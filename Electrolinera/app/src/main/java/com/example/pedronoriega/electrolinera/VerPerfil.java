package com.example.pedronoriega.electrolinera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerPerfil extends AppCompatActivity {

    TextView etNombre;
    TextView etApellidoPaterno;
    TextView etApellidoMaterno;
    TextView etCorreo;
    TextView etFechaNacimiento;
    TextView etGenero;
    TextView etEstado;
    Button btnModificar;

    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String correo;
    int fechaNacimiento;
    String genero;
    String estado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perfil);

        Bundle bundle = getIntent().getExtras();  //Recuperamos los datos de la actividad de iniciar sesion
        String email = bundle.getString("email"); //Guardamos el correo
        String contrasenia = bundle.getString("contrasenia"); //Guardamos la contrasenia

        etNombre = (TextView)findViewById(R.id.tvNombre);
        etApellidoPaterno = (TextView)findViewById(R.id.tvApellidoPaterno);
        etApellidoMaterno = (TextView)findViewById(R.id.tvApellidoMaterno);
        etCorreo = (TextView)findViewById(R.id.tvCorreo);
        etFechaNacimiento = (TextView)findViewById(R.id.tvFechaNacimiento);
        etGenero = (TextView)findViewById(R.id.tvGenero);
        etEstado = (TextView)findViewById(R.id.tvEstado);
        btnModificar = (Button)findViewById(R.id.btnModificar);

        Usuario usuario = new Usuario(email,contrasenia);
        verMiPerfil(usuario);

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VerPerfil.this, ModificarPerfil.class);
                i.putExtra("correo", correo);
                i.putExtra("nombre",nombre);
                i.putExtra("aPat",apellidoPaterno);
                i.putExtra("aMat",apellidoMaterno);
                i.putExtra("edad",fechaNacimiento);
                i.putExtra("genero",genero);
                i.putExtra("estado",estado);
                startActivity(i);
            }
        });




    }

    private void verMiPerfil(Usuario usuario){
        WSVerPerfil wsVerPerfil =new WSVerPerfil(this);
        wsVerPerfil.verPerfilInBackground(usuario, new GetUserCallback() {
            @Override
            public void done(Usuario returnedUsuario) {
                nombre = returnedUsuario.nombre;
                apellidoPaterno = returnedUsuario.apellidoPaterno;
                apellidoMaterno = returnedUsuario.apellidoMaterno;
                correo = returnedUsuario.email;
                fechaNacimiento = returnedUsuario.edad;
                genero = returnedUsuario.genero;
                estado = returnedUsuario.estado;

                etNombre.setText(nombre);
                etApellidoPaterno.setText(apellidoPaterno);
                etApellidoMaterno.setText(apellidoMaterno);
                etCorreo.setText(correo);
                etFechaNacimiento.setText(fechaNacimiento+"");
                etGenero.setText(genero);
                etEstado.setText(estado);
            }
        });
    }
}
