package com.example.pedronoriega.electrolinera;

import java.util.Date;

public class AutomovilEliminado {
	String modelo; 	//Atributo que guarda el modelo del auto
	String tipo;	//Tipo del auto (híbrido o eléctrico)
	String marca;	//Marca del automóvil
	int anio;		//Año del automóvil
	Usuario usuario;//Guarda al dueño del automóvil
	Date fechaDeEliminacion; //Fecha de eliminación del automóvil
	
	//Constructor de la clase
	public AutomovilEliminado(String modelo) {
		this.modelo = modelo;
		fgklsdfjgkjsñdfgkjsñdlfkgjsdñlfkgjsñldfkg
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
	
	//Método para asignar la fecha de eliminación de un auto
	public void setFechaDeEliminacion(Date fechaDeEliminacion){
		this.fechaDeEliminacion = fechaDeEliminacion;
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
	
	//Método para obtener la fecha de eliminación del auto
	public Date fechaDeEliminacion(){
		return fechaDeEliminacion;
	}
}
