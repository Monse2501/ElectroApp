package com.example.pedronoriega.electrolinera;

public class ElectrolineraEliminado {
	String nombre;		//Nombre de electrolinera
	float latitud;		//Latitud de su ubicación
	float longitud;		//Longitud de su ubicación
	String direccion;	//Direccion de electrolinera
	String marca;		//Marca de electrolinera
	String estado;		//Estado donde se encuentra la electrolinera
	Estacion estacion;	//Información de las estaciones de la electrolinera
	String fechaDeEliminacion; 	//Guarda la fecha en la que se eliminó la electrolinera
	String motivo; 		//El motivo de la eliminación de electrolinera

	//Constructor de la clase electrolinera
	public ElectrolineraEliminado() {
		
	}
	
	/**************************************************************************************/
	/** Métodos para agregar o modificar la información de las electrolineras eliminadas **/
	/**************************************************************************************/
	
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
	
	//Método para asignar una estación a la electrolinera
	public void setEstacion(Estacion estacion){
		this.estacion = estacion;
	}
	
	//Método para asignar la fecha de eliminación de una electrolinera
	public void setFechaDeEliminacion(String fechaDeEliminacion){
		this.fechaDeEliminacion = fechaDeEliminacion;
	}
	
	//M�todo para asignar el motivo de la eliminaci�n de la electrolinera
	public void setMotivo(String motivo){
		this.motivo = motivo;
	}
	
	
	/******************************************************************************/
	/********** M�todos para consultar informaci�n de las electrolineras **********/
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
	
	//Método para obtener las estaciones de electrolinera
	public Estacion getEstacion(){
		return estacion;
	}
	
	//Método para obtener la fecha de eliminación de una electrolinera
	public String getFechaDeEliminacion(){
		return fechaDeEliminacion;
	}
	
	//Método para obtener el motivo de eliminación de una electrolinera
	public String getMotivo(){
		return motivo;
	}
}
