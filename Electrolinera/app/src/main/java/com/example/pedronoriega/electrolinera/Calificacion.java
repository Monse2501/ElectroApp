package com.example.pedronoriega.electrolinera;

public class Calificacion {
	int calificacion;	//Guarda la calificación de una electrolinera
	Electrolinera electrolinera; //Guarda la información de la electrolinera a la que está asociada

	//Constructor de la clase
	public Calificacion(int calificacion, Electrolinera electrolinera) {
		this.calificacion = calificacion;
		this.electrolinera = electrolinera;
	}

	//Método para asignar la calificación
	public void setCalificacion(int calificacion){
		this.calificacion = calificacion;
	}

	//Método para asignar la electrolinera a la que se asocia la calificación
	public void setElectrolinera(Electrolinera electrolinera){
		this.electrolinera = electrolinera;
	}

	//Método para obtener la calificación
	public int getCalificacion(){
		return calificacion;
	}

	//Método para obtener la electrolinera a la que se asocia la calificación
	public Electrolinera getElectrolinera(){
		return electrolinera;
	}
}
