package com.example.pedronoriega.electrolinera;

public class TarjetaDeCredito {
	String digitosTarjeta;		//Número de la tarjeta de crédito
	int ccv;					//CCV de la tarjeta
	String tipoTarjeta;			//Tipo de la tarjeta (American Express, Master Card, etc)
	String banco;				//Banco de la tarjeta
	String fechaDeExpiracion;	//Fecha de expiración de la tarjeta
	Usuario usuario;			//Dueño de la tarjeta
	
	//Constructor de la clase
	public TarjetaDeCredito(String digitosTarjeta, int ccv, String tipoTarjeta, String banco, String fechaDeExpiracion, Usuario usuario) {
		// TODO Auto-generated constructor stub
		this.digitosTarjeta = digitosTarjeta;
		this.ccv = ccv;
		this.tipoTarjeta = tipoTarjeta;
		this.banco = banco;
		this.fechaDeExpiracion = fechaDeExpiracion;
		this.usuario = usuario;
	}
	
	/*********************************************************************************/
	/** Métodos para agregar o modificar la información de las tarjetas de crédito ***/
	/*********************************************************************************/
	
	//Método para asignar los dígitos a la tarjeta de crédito
	public void setDigitosTarjeta(String digitosTarjeta){
		this.digitosTarjeta = digitosTarjeta;
	}
	
	//Método para asignar el número ccv de la tarjeta
	public void setCCV(int ccv){
		this.ccv = ccv;
	}
	
	//Método para asignar el tipo de tarjeta
	public void setTipoTarjeta(String tipoTarjeta){
		this.tipoTarjeta = tipoTarjeta;
	}
	
	//Método para asignar el banco de la tarjeta
	public void setBanco(String banco){
		this.banco = banco;
	}
	
	//Método para asignar fecha de expiración de la tarjeta
	public void setFechaDeExpiracion(String fechaDeExpiracion){
		this.fechaDeExpiracion = fechaDeExpiracion;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	/*********************************************************************************/
	/*********** Métodos para consultar la información de los comentarios ************/
	/*********************************************************************************/
	
	//Método para obtener el número de tarjeta
	public String getDigitosTarjeta(){
		return digitosTarjeta;
	}
	
	//Método para obtener el número ccv de la tarjeta
	public int getCCV(){
		return ccv;
	}
	
	//Método para obtener el tipo de tarjeta
	public String getTipoTarjeta(){
		return tipoTarjeta;
	}
	
	//Método para obtener el banco de la tarjeta
	public String getBanco(){
		return banco;
	}
	
	//Método para obtener la fecha de expiración de la tarjeta
	public String getFechaDeExpiracion(){
		return fechaDeExpiracion;
	}
	
	//Método para obtener el dueño de la tarjeta
	public Usuario getUsuario(){
		return usuario;
	}
}
