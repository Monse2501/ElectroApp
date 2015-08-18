package com.example.pedronoriega.electrolinera;

public class Estacion {
	String nivel;					//El nivel de la estación
	String estadoDisponibilidad;	//Estado de disponibilidad de la estación (Disponible, No disponible, En mantenimiento, Sin conexión)
	String clasificacion;			//Clasificación de la electrolinera (Residencial, Empresarial, Pública)
	Electrolinera electrolinera;	//Electrolinera que está asociada a la estación de carga
	
	//Constructor de la clase
	public Estacion(String nivel, String estadoDisponibilidad, String clasificacion, Electrolinera electrolinera) {
		this.nivel = nivel;
		this.estadoDisponibilidad = estadoDisponibilidad;
		this.clasificacion = clasificacion;
		this.electrolinera = electrolinera;
	}
	
	/*********************************************************************************/
	/** Métodos para agregar o modificar la información de las estaciones de carga ***/
	/*********************************************************************************/

	//Método para asignar el nivel a una estación
	public void setNivel(String nivel){
		this.nivel = nivel;
	}
	
	//Método para asignar el estado de disponibilidad de una estación
	public void setEstadoDisponibilidad(String estadoDisponibilidad){
		this.estadoDisponibilidad = estadoDisponibilidad;
	}
	
	//Método para asignar la clasificación de una estación
	public void setClasificacion(String clasificacion){
		this.clasificacion = clasificacion;
	}
	
	//Método para asignar la electrolinera a la que está asociada la estación
	public void setElectrolinera(Electrolinera electrolinera){
		this.electrolinera = electrolinera;
	}
	
	/*********************************************************************************/
	/******* Métodos para consultar la información de las estaciones de carga ********/
	/*********************************************************************************/
	
	//Método para obtener el nivel de la estación
	public String getNivel(){
		return nivel;
	}
	
	//Método para obtener el estado de disponibilidad de la estación
	public String getEstadoDisponibilidad(){
		return estadoDisponibilidad;
	}
	
	//Método para obtener la clasificaión de la estación
	public String getClasificacion(){
		return clasificacion;
	}
	
	//Método para obtener la electrolinera que está asociada a la estación
	public Electrolinera getElectrolinera(){
		return electrolinera;
	}
}
