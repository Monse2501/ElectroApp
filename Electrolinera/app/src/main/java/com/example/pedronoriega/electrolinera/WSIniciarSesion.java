package com.example.pedronoriega.electrolinera;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;

public class WSIniciarSesion { //clase para conexion con el servicio php iniciarSesion.php
    ConexionServerPHP conexionIniciarSesion;

    public WSIniciarSesion(Context context)
    {
        conexionIniciarSesion = new ConexionServerPHP(context);
    }

    public void iniciarSesionInBackground(Usuario usuario, GetUserCallback userCallback){
       conexionIniciarSesion.progressDialog.show();

    }

    public class IniciarSesionAsyncTask extends AsyncTask<Void, Void, Usuario>
    {
        Usuario usuario;
        GetUserCallback userCallback;

        public IniciarSesionAsyncTask(Usuario usuario, GetUserCallback callback){
            this.usuario = usuario;
            this.userCallback = callback;
        }

        @Override
        protected Usuario doInBackground(Void... params) {
            ArrayList<NameValuePair> datosUsuario = new ArrayList<>();
            datosUsuario.add(new BasicNameValuePair("email", usuario.email));
            datosUsuario.add(new BasicNameValuePair(""));

            return null;
        }
    }


}
