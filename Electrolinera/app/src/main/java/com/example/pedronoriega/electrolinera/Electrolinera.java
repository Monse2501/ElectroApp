package com.example.pedronoriega.electrolinera;

public class Electrolinera {
	String nombre;		//Nombre de electrolinera
	float latitud;		//Latitud de su ubicación
	float longitud;		//Longitud de su ubicación
	String direccion;	//Direccion de electrolinera
	String marca;		//Marca de electrolinera
	String estado;		//Estado donde se encuentra la electrolinera
	float precio;		//Precio establecido en electrolinera
	int codigoPostal;	//Código postal de electrolinera
	
	//Constructor de la clase electrolinera
	public Electrolinera(String nombre, float latitud, float longitud, String direccion, String marca, String estado, float precio, int codigoPostal) {
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.direccion = direccion;
		this.marca = marca;
		this.estado = estado;
		this.precio = precio;
		this.codigoPostal = codigoPostal;
	}
	
	/******************************************************************************/
	/*** Métodos para agregar o modificar la información de las electrolineras ****/
	/******************************************************************************/
	
	//Método para asignar el nombre de la electrolinera
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	//Método para asignar la latitud de la ubicación de la electrolinera
	public void setLatitud(float latitud){
		this.latitud = latitud;
	}
	
	//Método para asignar la longitud de la ubicación de la electrolinera
	public void setLongitud(float longitud){
		this.longitud = longitud;
	}
	
	//Método para asignar la dirección de la electrolinera
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	
	//Método para asignar la marca de la electrolinera
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	//Método para asignar el estado donde se encuentra la electrolinera
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	//Método para asignar el precio de la electrolinera
	public void setPrecio(float precio){
		this.precio = precio;
	}
	
	//Método para asignar el código postal de la electrolinera
	public void setCodigoPostal(int codigoPostal){
		this.codigoPostal = codigoPostal;
	}
	
	
	/******************************************************************************/
	/********** Métodos para consultar información de las electrolineras **********/
	/******************************************************************************/
	
	//Método para obtener el nombre de la electrolinera
	public String getNombre(){
		return nombre;
	}
	
	//Método para obtener la latitud de la electrolinera
	public float getLatitud(){
		return latitud;
	}
	
	//Método para obtener la longitud de la electrolinera
	public float getLongitud(){
		return longitud;
	}
	
	//Método para obtener la dirección de la electrolinera
	public String getDireccion(){
		return direccion;
	}
	
	//Método para obtener la marca de la electrolinera
	public String getMarca(){
		return marca;
	}
	
	//Método para obtener el estado donde se encuentra la electrolinera
	public String getEstado(){
		return estado;
	}
	
	//Método para obtener el precio de la electrolinera
	public float getPrecio(){
		return precio;
	}
	
	//Método para obtener el código postal de la electrolinera
	public int getCodigoPostal(){
		return codigoPostal;
	}
}
