package com.example.pedronoriega.electrolinera;

import android.app.ProgressDialog;
import android.content.Context;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 * Created by Pedro Noriega on 19/08/2015.
 */
public class ConexionServerPHP {
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://www.pruebitas-cfe.site40.net/";
    public String nombreServicio = "";
    HttpParams httpRequestParams;
    HttpClient client;
    HttpPost post;

    public ConexionServerPHP(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }

    public void Conexion(String nombreServicio)
    {
        this.nombreServicio=nombreServicio;
        httpRequestParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
        HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);
        client = new DefaultHttpClient(httpRequestParams);
        post = new HttpPost(SERVER_ADDRESS + nombreServicio);
    }



}
