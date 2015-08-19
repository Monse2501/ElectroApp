package com.example.pedronoriega.electrolinera;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

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
    //ConexionServerPHP conexionIniciarSesion;
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://www.pruebitas-cfe.site40.net/";
    public String nombreServicio = "";
    Context context;

    public WSIniciarSesion(Context context)
    {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
        this.context = context;
        //conexionIniciarSesion = new ConexionServerPHP(context);
    }

    public void iniciarSesionInBackground(Usuario usuario, GetUserCallback userCallback){
       //conexionIniciarSesion.progressDialog.show();
        progressDialog.show();
        new IniciarSesionAsyncTask(usuario, userCallback).execute();

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
            datosUsuario.add(new BasicNameValuePair("contrasena", usuario.contrasenia));
            //conexionIniciarSesion.Conexion("iniciarSesion.php");

            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "iniciarSesion.php");

            Usuario returnedUsuario = null;

            try{
                //conexionIniciarSesion.post.setEntity(new UrlEncodedFormEntity(datosUsuario));
                //HttpResponse httpResponse = conexionIniciarSesion.client.execute(conexionIniciarSesion.post);
                post.setEntity(new UrlEncodedFormEntity(datosUsuario));
                HttpResponse httpResponse = client.execute(post);

                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity);
                JSONObject jObject = new JSONObject(result);

                if(jObject.length()== 0){
                    returnedUsuario = null;
                    Toast.makeText(context,"error",Toast.LENGTH_LONG).show();
                }else{
                    String email = jObject.getString("correo");
//                    Toast.makeText(context,email,Toast.LENGTH_LONG).show();
                    returnedUsuario = new Usuario(usuario.email,usuario.contrasenia);
                }

            }catch(Exception e){
                e.printStackTrace();
            }

            return returnedUsuario;
        }

        @Override
        protected void onPostExecute(Usuario returnedUser) {
            //conexionIniciarSesion.progressDialog.dismiss();
            progressDialog.dismiss();
            userCallback.done(returnedUser);
            super.onPostExecute(returnedUser);
        }


    }


}
