package com.example.pedronoriega.electrolinera;

public class Noticia {
	String noticia;		//Noticia
	String fecha;		//Fecha de publicación
	String fuente;		//Fuente de donde se obtuvo
	String titulo;		//Título de la noticia
	Fotografia fotografia;	//Fotografía que contiene la noticia
	Usuario usuario;	//Usuario que la publicó
	
	//Constructor de la clase
	public Noticia(String noticia, String fecha, String fuente, String titulo, Fotografia fotografia, Usuario usuario) {
		this.noticia = noticia;
		this.fecha = fecha;
		this.fuente = fuente;
		this.titulo = titulo;
		this.fotografia = fotografia;
		this.usuario = usuario;
	}
	
	/*********************************************************************************/
	/******** Métodos para agregar o modificar la informaci�ón de las noticias ********/
	/*********************************************************************************/
	
	//Método para asignar la noticia
	public void setNoticia(String noticia){
		this.noticia = noticia;
	}
	
	//Método para asignar la fecha de publicación
	public void setFecha(String fecha){
		this.fecha = fecha;
	}
	
	//Método para asignar la fuente de donde se obtuvo
	public void setfuente(String fuente){
		this.fuente = fuente;
	}
	
	//Método para asignar el título de la noticia
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	//Método para asignar la fotografía de la noticia
	public void setFotografia(Fotografia fotografia){
		this.fotografia = fotografia;
	}
	
	//Método para asignar el usuario que la publica
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	/*********************************************************************************/
	/************ Métodos para consultar la información de los comentarios ***********/
	/*********************************************************************************/
	
	//Método para obtener la noticia
	public String getNoticia(){
		return noticia;
	}
	
	//Método para obtener la fecha de publicación
	public String getFecha(){
		return fecha;
	}
	
	//Método para obtener la fuente de la noticia
	public String getFuente(){
		return fuente;
	}
	
	//Método para obtener el título de la noticia
	public String getTitulo(){
		return titulo;
	}
	
	//Método para obtener la información de la fotografía
	public Fotografia getFotografia(){
		return fotografia;
	}
	
	//Método para obtener la información del usuario
	public Usuario getUsuario(){
		return usuario;
	}
}
