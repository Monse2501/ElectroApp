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
 * Created by Pedro Noriega on 21/08/2015.
 */
public class WSVerPerfil {

    //ConexionServerPHP conexionIniciarSesion;
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://www.monsesita-cfe.net84.net/Servicios/";
    public String nombreServicio = "";
    Context context;

    public WSVerPerfil(Context context)
    {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
        //conexionIniciarSesion = new ConexionServerPHP(context);
    }

    public void verPerfilInBackground(Usuario usuario, GetUserCallback userCallback){
        //conexionIniciarSesion.progressDialog.show();
        //progressDialog.show();
        new verPerfilAsyncTask(usuario, userCallback).execute();

    }

    public class verPerfilAsyncTask extends AsyncTask<Void, Void, Usuario>
    {
        Usuario usuario;
        GetUserCallback userCallback;

        public verPerfilAsyncTask(Usuario usuario, GetUserCallback callback){
            this.usuario = usuario;
            this.userCallback = callback;


        }


        @Override
        protected Usuario doInBackground(Void... params) {
            ArrayList<NameValuePair> datosUsuario = new ArrayList<>();
            datosUsuario.add(new BasicNameValuePair("email",usuario.email));

            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpClient client = new DefaultHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(SERVER_ADDRESS + "verPerfil.php");

            Usuario returnedUser = null;

            try{
                post.setEntity(new UrlEncodedFormEntity(datosUsuario));
                HttpResponse httpResponse = client.execute(post);

                HttpEntity entity = httpResponse.getEntity();
                String result = EntityUtils.toString(entity);
                JSONObject jObject = new JSONObject(result);

                if(jObject.length()== 0){
                    returnedUser = null;
                }else{
                    String email = jObject.getString("email");
                    String nombre = jObject.getString("nombre");
                    String apellidoPaterno = jObject.getString("apellidoPaterno");
                    String apellidoMaterno = jObject.getString("apellidoMaterno");
                    String genero = jObject.getString("genero");
                    int edad = jObject.getInt("edad");
                    String estado = jObject.getString("descripcionEstado");
                    System.out.println(email);
                    System.out.println(nombre);
                    System.out.println(apellidoPaterno);
                    System.out.println(apellidoMaterno);
                    System.out.println(genero);
                    System.out.println(edad + "");
                    System.out.println(estado);

                    returnedUser = new Usuario(email,nombre,apellidoPaterno,apellidoMaterno,genero,edad,estado);
                }

            }catch(Exception e){
                e.printStackTrace();
            }


            return returnedUser;
        }

        @Override
        protected void onPostExecute(Usuario returnedUser) {
            progressDialog.dismiss();
            userCallback.done(returnedUser);
            super.onPostExecute(returnedUser);
        }
    }


}
