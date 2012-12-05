package com.screv.rest;

public class Pedido {

	private String endereco, referencia ;
	
	public Pedido(){
		
	}
	
	public Pedido(String endereco, String referencia) {
		this.endereco = endereco ;
		this.referencia = referencia ;
	}
	
	//GETTERS E SETTERS
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	
	
}//Fecha classe