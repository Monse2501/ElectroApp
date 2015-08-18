package com.example.pedronoriega.electrolinera;

public class Fotografia {
	String nombreFoto;		//Guarda el nombre de la foto
	int ancho;				//Guarda el ancho de la foto	
	int alto;				//Guarda el alto de la foto
	String tipoFoto;		//Es la extensi�n de la foto (PNG, JPG, JPEG) 
	
	//Constructor de la clase
	public Fotografia() {
		
	}

	/******************************************************************************/
	/****** Métodos para agregar o modificar la información de una fotografía *****/
	/******************************************************************************/
	
	//Método para asignar el nombre a la foto
	public void setNombreFoto(String nombreFoto){
		this.nombreFoto = nombreFoto;
	}
	
	//Método para asignar el ancho de la foto
	public void setAncho(int ancho){
		this.ancho = ancho;
	}
	
	//Método para asignar el alto de la foto
	public void setAlto(int alto){
		this.alto = alto;
	}
	
	//Método para asignar el tipo de la foto (PNG, JPG, JPEG)
	public void setTipo(String tipoFoto){
		this.tipoFoto = tipoFoto;
	}
	
	/******************************************************************************/
	/*********** Métodos para consultar la información de una fotografía **********/
	/******************************************************************************/
	
	//Método para obtener el nombre de la foto
	public String getNombreFoto(){
		return nombreFoto;
	}
	
	//Método para obtener el ancho de la foto
	public int getAncho(){
		return ancho;
	}
	
	//Método para obtener el alto de la foto
	public int getAlto(){
		return alto;
	}
	
	//Método para obtener el tipo de la foto
	public String getTipo(){
		return tipoFoto;
	}
}
