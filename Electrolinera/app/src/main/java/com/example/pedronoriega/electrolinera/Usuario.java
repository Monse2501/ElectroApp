package com.example.pedronoriega.electrolinera;

public class Usuario {
	String nombre;			//Guarda el nombre del usuario
	String apellidoPaterno;	//Apellido Paterno del usuario
	String apellidoMaterno; //Apellido Materno del usuario
	String genero;			//Género del usuario
	int edad;				//Edad del usuario
	String estado;			//Estado donde se encuentra el usuario
	Fotografia fotografia;	//Guarda la información de la fotografía del usuario
	String contrasenia;		//Contraseña del usuario
	String email;			//Email del usuario
	String tipoUsuario;		//Tipo de usuario (Arquitecto, Neo, Morpheo, Noticias, Cliente)
	Automovil auto;			//Automóviles que posee el usuario

	public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, int edad, String estado, Fotografia fotografia, String contrasenia, String email, String tipoUsuario, Automovil auto) {
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.genero = genero;
		this.edad = edad;
		this.estado = estado;
		this.fotografia = fotografia;
		this.contrasenia = contrasenia;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
		this.auto = auto;
	}

	public Usuario(String email, String contrasenia) {
		this.contrasenia = contrasenia;
		this.email = email;
	}

	/******************************************************************************/
	/****** Métodos para agregar o modificar la información de los usuarios *******/
	/******************************************************************************/
	
	//Método para asignar nombre al usuario
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	//Mtodo para asignar apellido paterno al usuario
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
	
	//Metodo para asignar el estado donde se encuentra el usuario
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	//Método para asignar la información de una fotografía de usuario
	public void setFotografia(Fotografia fotografia){
		this.fotografia = fotografia;
	}
	
	//Método para asignar una contraseña al usuario
	public void setContrasenia(String contrasenia){
		this.contrasenia = contrasenia;
	}
	
	//Método para asignar un correo electrónico al usuario
	public void setEmail(String email){
		this.email = email;
	}
	
	//Método para asignar el tipo de usuario
	public void setTipoUsuario(String tipoUsuario){
		this.tipoUsuario = tipoUsuario;
	}
	
	//Método para asignar los autos al usuario
	public void setAutomovil(Automovil auto){
		this.auto = auto;
	}
	
	/******************************************************************************/
	/********** Métodos para consulta de la información de los usuarios ***********/
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
	
	//Método para obtener la informacion de la fotografía del usuario
	public Fotografia getFotografia(){
		return fotografia;
	}
	
	//Método para obtener la contraseña del usuario
	public String getContrasenia(){
		return contrasenia;
	}
	
	//Método para obtener el correo electrónico del usuario
	public String getEmail(){
		return email;
	}
	
	//Método para obtener los automóviles del usuario
	public Automovil getAutomovil(){
		return auto;
	}
}
