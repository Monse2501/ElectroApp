package com.example.pedronoriega.electrolinera;

/**
 * Created by Pedro Noriega on 24/08/2015.
 */
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
public class WSAgregarAutomovil {
    //ConexionServerPHP conexionIniciarSesion;
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://www.monsesita-cfe.net84.net/Servicios/";

    public WSAgregarAutomovil(Context context)
    {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }

    public void agregarAutomovilInBackground(Usuario usuario, Automovil automovil, GetAutomovilCallback automovilCallback){
        //conexionIniciarSesion.progressDialog.show();
        progressDialog.show();
        new agregarAutomovilAsyncTask(usuario,automovil, automovilCallback).execute();

    }

    public class agregarAutomovilAsyncTask extends AsyncTask<Void, Void, Void>
    {
        Usuario usuario;
        Automovil automovil;
        GetAutomovilCallback automovilCallback;

        public agregarAutomovilAsyncTask(Usuario usuario,Automovil automovil, GetAutomovilCallback callback){
            this.usuario = usuario;
            this.automovil = automovil;
            this.automovilCallback = callback;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ArrayList<NameValuePair> datosAutomovil = new ArrayList<>();
            datosAutomovil.add(new BasicNameValuePair("email", usuario.email));
            datosAutomovil.add(new BasicNameValuePair("anio", automovil.anio+""));
            datosAutomovil.add(new BasicNameValuePair("modelo", automovil.modelo));
            datosAutomovil.add(new BasicNameValuePair("tipoCoche", automovil.tipo));
            datosAutomovil.add(new BasicNameValuePair("marca", automovil.marca+""));


            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "agregarAutomovil.php");


            try{
                //conexionIniciarSesion.post.setEntity(new UrlEncodedFormEntity(datosUsuario));
                //HttpResponse httpResponse = conexionIniciarSesion.client.execute(conexionIniciarSesion.post);
                post.setEntity(new UrlEncodedFormEntity(datosAutomovil));
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
            automovilCallback.done(null);
            super.onPostExecute(aVoid);
        }


    }

}
