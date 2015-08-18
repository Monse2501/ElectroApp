package com.example.pedronoriega.electrolinera;

import java.util.Date;

public class UsuarioEliminado {
	String nombre;			//Guarda el nombre del usuario
	String apellidoPaterno;	//Apellido Paterno del usuario
	String apellidoMaterno; //Apellido Materno del usuario
	String genero;			//Género del usuario
	int edad;				//Edad del usuario
	String estado;			//Estado donde se encuentra el usuario
	String tipoUsuario;		//Tipo de usuario (Arquitecto, Neo, Morpheo, Noticias, Cliente)
	Date fechaDeEliminacion; //Fecha en la que el usuario se eliminó su cuenta
	
	//Constructor de la clase
	public UsuarioEliminado() {
		
	}
		
	/********************************************************************************/
	/** Métodos para agregar o modificar la información de los usuarios eliminados **/
	/********************************************************************************/
	
	//Método para asignar nombre al usuario
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	//Método para asignar apellido paterno al usuario
	public void setApellidoPaterno(String apellidoPaterno){
		this.apellidoPaterno = apellidoPaterno;
	}
	
	//Método para asignar apellido materno al usuario
	public void setApellidoMaterno(String apellidoMaterno){
		this.apellidoMaterno = apellidoMaterno;
	}
	
	//Método para asignar género al usuario
	public void setGenero(String genero){
		this.genero = genero;
	}
	
	//Método para asignar edad al usuario
	public void setEdad(int edad){
		this.edad = edad;
	}
	
	//Método para asignar el estado donde se encuentra el usuario
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	//Método para asignar la fecha de eliminación del usuario
	public void setFechaDeEliminacion(Date fechaDeEliminacion){
		this.fechaDeEliminacion = fechaDeEliminacion;
	}
	
	/******************************************************************************/
	/**** Métodos para consulta de la información de los usuarios eliminados ******/
	/******************************************************************************/
	
	//Método para obtener el nombre del usuario
	public String getNombre(){
		return nombre;
	}
	
	//Método para obtener el apellido paterno del usuario
	public String getApellidoPaterno(){
		return apellidoPaterno;
	}
	
	//Método para obtener el apellido materno del usuario
	public String getApellidoMaterno(){
		return apellidoMaterno;
	}
	
	//Método para obtener el género del usuario
	public String getGenero(){
		return genero;
	}
	
	//Método para obtener la edad del usuario
	public int getEdad(){
		return edad;
	}
	
	//Método para obtener el estado donde se encuentra el usuario
	public String getEstado(){
		return estado;
	}

	//Método para obtener la fecha de eliminación del usuario
	public Date getFechaDeEliminacion(){
		return fechaDeEliminacion;
	}
}