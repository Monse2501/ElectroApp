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
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener{

    EditText etNombre;
    EditText etApellidoPaterno;
    EditText etApellidoMaterno;
    EditText etCorreo;
    EditText etContrasenia;
    EditText etRepetirContrasenia;
    EditText etFechaNacimiento;
    EditText etGenero;
    EditText etEstado;
    Button btnRegistarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellidoPaterno = (EditText)findViewById(R.id.etApellidoPaterno);
        etApellidoMaterno = (EditText)findViewById(R.id.etApellidoMaterno);
        etCorreo = (EditText)findViewById(R.id.etCorreo);
        etContrasenia = (EditText)findViewById(R.id.etContrasenia);
        etRepetirContrasenia = (EditText)findViewById(R.id.etRepetirContrasenia);
        etFechaNacimiento = (EditText)findViewById(R.id.etFechaNacimiento);
        etGenero = (EditText)findViewById(R.id.etGenero);
        etEstado = (EditText)findViewById(R.id.etEstado);
        btnRegistarme = (Button)findViewById(R.id.btnRegistrarme);

        btnRegistarme.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
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
            case R.id.btnRegistrarme:

                String nombre = etNombre.getText().toString();
                String apellidoPaterno = etApellidoPaterno.getText().toString();
                String apellidoMaterno = etApellidoMaterno.getText().toString();
                String email = etCorreo.getText().toString();
                int edad = Integer.parseInt(etFechaNacimiento.getText().toString());
                String contrasenia = etContrasenia.getText().toString();
                String repetirContrasenia = etRepetirContrasenia.getText().toString();
                String estado = etEstado.getText().toString();
                String genero = etGenero.getText().toString();
                if(contrasenia.equals(repetirContrasenia))
                {
                    Usuario usuario = new Usuario(nombre,apellidoPaterno,apellidoMaterno,genero,edad,estado,contrasenia,email);
                    registerUser(usuario);
                }else{
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Registro.this);
                    dialogBuilder.setMessage("La contraseña no coincide");
                    dialogBuilder.setPositiveButton("Ok", null);
                    dialogBuilder.show();

                    etContrasenia.setText("");
                    etRepetirContrasenia.setText("");
                }

                break;
        }
    }

    private void registerUser(Usuario usuario){
        WSCrearCuenta wsCrearCuenta = new WSCrearCuenta(this);
        wsCrearCuenta.crearCuentaInBackground(usuario, new GetUserCallback() {
            @Override
            public void done(Usuario returnedUser) {
                Intent i = new Intent(Registro.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
