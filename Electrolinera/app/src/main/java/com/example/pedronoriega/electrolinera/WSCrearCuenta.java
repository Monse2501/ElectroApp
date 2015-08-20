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

/**
 * Created by Pedro Noriega on 20/08/2015.
 */
public class WSCrearCuenta {
    //ConexionServerPHP conexionIniciarSesion;
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://www.monsesita-cfe.net84.net/Servicios/";
    public String nombreServicio = "";
    Context context;

    public WSCrearCuenta(Context context)
    {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
        //conexionIniciarSesion = new ConexionServerPHP(context);
    }

    public void crearCuentaInBackground(Usuario usuario, GetUserCallback userCallback){
        //conexionIniciarSesion.progressDialog.show();
        progressDialog.show();
        new crearCuentaAsyncTask(usuario, userCallback).execute();

    }

    public class crearCuentaAsyncTask extends AsyncTask<Void, Void, Void>
    {
        Usuario usuario;
        GetUserCallback userCallback;

        public crearCuentaAsyncTask(Usuario usuario, GetUserCallback callback){
            this.usuario = usuario;
            this.userCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ArrayList<NameValuePair> datosUsuario = new ArrayList<>();
            datosUsuario.add(new BasicNameValuePair("email", usuario.email));
            datosUsuario.add(new BasicNameValuePair("contrasena", usuario.contrasenia));
            datosUsuario.add(new BasicNameValuePair("nombre", usuario.nombre));
            datosUsuario.add(new BasicNameValuePair("apPat", usuario.apellidoPaterno));
            datosUsuario.add(new BasicNameValuePair("apMat", usuario.apellidoMaterno));
            datosUsuario.add(new BasicNameValuePair("genero", usuario.genero));
            datosUsuario.add(new BasicNameValuePair("edad", usuario.edad + ""));
            datosUsuario.add(new BasicNameValuePair("Estado_idEstado", usuario.estado));
            //datosUsuario.add(new BasicNameValuePair("Fotografia_idFotografia", null));
            //conexionIniciarSesion.Conexion("iniciarSesion.php");

            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "crearCuenta.php");


            try{
                //conexionIniciarSesion.post.setEntity(new UrlEncodedFormEntity(datosUsuario));
                //HttpResponse httpResponse = conexionIniciarSesion.client.execute(conexionIniciarSesion.post);
                post.setEntity(new UrlEncodedFormEntity(datosUsuario));
                client.execute(post);

            }catch(Exception e){
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //conexionIniciarSesion.progressDialog.dismiss();
            progressDialog.dismiss();
            userCallback.done(null);
            super.onPostExecute(aVoid);
        }


    }

}
