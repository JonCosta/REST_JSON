package com.screv.rest;

public class Taxi {
	
	private double latitude, longitude ;
	private String placa ;
	
	public Taxi(){
		
	}
	
	public Taxi(String placa, double lat, double lng){
		this.placa = placa ;
		this.latitude = lat ;
		this.longitude = lng ;
	}
	
	/*MÉTODOS GETTER E SETTER*/
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
}//Fecha classe
