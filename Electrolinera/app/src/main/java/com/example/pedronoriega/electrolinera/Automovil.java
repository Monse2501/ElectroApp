package com.example.pedronoriega.electrolinera;

public class Automovil {
	String modelo; 	//Atributo que guarda el modelo del auto
	String tipo;	//Tipo del auto (híbrido o eléctrico)
	String marca;	//Marca del automóvil
	int anio;		//Año del automóvil
	Usuario usuario;//Guarda al dueño del automóvil
	
	//Constructor de la clase
	public Automovil(String modelo, String tipo, String marca, int anio, Usuario usuario) {
		this.modelo = modelo;
		this.tipo = tipo;
		this.marca = marca;
		this.anio = anio;
		this.usuario = usuario;
	}
	
	/******************************************************************************/
	/***** Métodos para agregar o modificar la información de los automóviles *****/
	/******************************************************************************/

	//Método para asignar usuario al auto
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	//Método para asignar el modelo al auto
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	
	//Método para asignar el tipo del auto (híbrido o eléctrico)
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	//Método para asignar la marca del auto
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	//Método para asignar el año del auto
	public void setAnio(int anio){
		this.anio = anio;
	}
	
	/******************************************************************************/
	/********* Métodos para consultar la información de los automóviles ***********/
	/******************************************************************************/
	
	//Método para obtener los datos del dueño del auto
	public Usuario getUsuario(){
		return usuario;
	}

	//Método para obtener el modelo del auto
	public String getModelo(){
		return modelo;
	}
	
	//Método para obtener el tipo del auto
	public String getTipo(){
		return tipo;
	}
	
	//Método para obtener la marca del auto
	public String getMarca(){
		return marca;
	}
	
	//Método para obtener el año del auto
	public int getAnio(){
		return anio;
	}
}
