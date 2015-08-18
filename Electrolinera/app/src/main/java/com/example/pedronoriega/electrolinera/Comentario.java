package com.example.pedronoriega.electrolinera;

import java.util.Date;

public class Comentario {
	String comentario;	//Guarda el comentario
	String titulo;		//Título del comentario
	Date fecha;		//Fecha en la que fue creado el comentario
	Usuario usuario;	//Usuario que envió el comentario

	//Constructor de la clase
	public Comentario() {
		// TODO Auto-generated constructor stub
	}
	
	/*********************************************************************************/
	/****** Métodos para agregar o modificar la información de los comentarios *******/
	/*********************************************************************************/
	
	//Método para asignar el comentario
	public void setComentario(String comentario){
		this.comentario = comentario;
	}
	
	//Método para asignar el título al comentario
	public void setTitutlo(String titulo){
		this.titulo = titulo;
	}
	
	//Método para asignar la fecha al comentario
	public void setFecha(Date fecha){
		this.fecha = fecha;
	}
	
	//Método para asignar el usuario que envió el comentario
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	/*********************************************************************************/
	/************ Métodos para consultar la información de los comentarios ***********/
	/*********************************************************************************/
	
	//Método para obtener el comentario
	public String getComentario(){
		return comentario;
	}
	
	//Método para obtener el título del comentario
	public String getTitulo(){
		return titulo;
	}
	
	//Método para obtener la fecha de la creación del comentario
	public Date getFecha(){
		return fecha;
	}
	
	//Método para obtener el usuario que envió el comentario
	public Usuario getUsuario(){
		return usuario;
	}
}
