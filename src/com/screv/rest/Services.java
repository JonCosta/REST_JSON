package com.screv.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.text.DecimalFormat ;

@Path("/teste")
public class Services {

	@Produces("application/json")
	@Consumes("application/json")
	@POST
	@Path("/somar")
	public JSONObject somar(JSONObject jsonParam) {

		// Lê os parâmetros em jsonParam e gera um outro JSON como resposta
		// Exemplo:
		Double n1 = null;
		Double n2 = null;
		try {
			n1 = jsonParam.getDouble("numero1");
			n2 = jsonParam.getDouble("numero2");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double soma = n1 + n2;

		HashMap<String, Double> hm = new HashMap<String, Double>();
		hm.put("resultado", soma);
		// Cada chave do HashMap vira uma Chave do JSON
		JSONObject resposta = new JSONObject(hm);
		return resposta;
	}
	
	@Produces("application/json")
	@Consumes("application/json")
	@POST
	@Path("/multiplicar")
	public JSONObject multiplicar(JSONObject jsonParam){
		
		// Lê os parâmetros em jsonParam e gera um outro JSON como resposta
		// Exemplo:
		Double n1 = null;
		Double n2 = null;
		try{
			n1 = jsonParam.getDouble("numero1") ;
			n2 = jsonParam.getDouble("numero2") ;
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double soma = n1 * n2;

		HashMap<String, Double> hm = new HashMap<String, Double>();
		hm.put("resultado", soma);
		// Cada chave do HashMap vira uma Chave do JSON
		JSONObject resposta = new JSONObject(hm);
		return resposta;
		
	}//Fecha multiplicar
	
	@Produces("application/json")
	@Consumes("application/json")
	@POST
	@Path("/mostrarCoord")
	public JSONObject mostrarCoord(JSONObject jsonParam){
		Double n1 = null;
		Double n2 = null;
		String placa = "" ;
		try{
			n1 = jsonParam.getDouble("latitude") ;
			n2 = jsonParam.getDouble("longitude") ;
			placa = jsonParam.getString("placa") ;
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap hm = new HashMap() ;
		hm.put("coord1", n1) ;
		hm.put("coord2", n2) ;
		hm.put("placa", placa) ;
		JSONObject resposta = new JSONObject(hm) ;
		return resposta ;
	}
	
	@Produces("application/json")
	@Consumes("application/json")
	@POST
	@Path("/experiencia1")
	public JSONObject experiencia1(JSONObject jsonParam){
		
		HashMap<String, String> hm = new HashMap<String, String>() ;
		double lat = 0, latOrigem = 0 ;
		double lng = 0, lngOrigem = 0 ;
		double distA = 0;
		double distB = 0;
		double distC = 0;
		
		Taxi taxiA = new Taxi("ABC-1234", -25.438294, -49.237397) ;
		Taxi taxiB = new Taxi("ABD-2345", -25.43779, -49.236914) ;
		Taxi taxiC = new Taxi("ACB-3456", -25.437344, -49.236259) ;
		
		/*
		 * -25.444162,-49.238813 Próximo de A
		 * -25.440209,-49.239371 Próximo de B
		 * -25.441992,-49.235938 Próximo de C
		 * */
		
		try {
			
			latOrigem = jsonParam.getDouble("latitude") ;
			latOrigem = latOrigem / 1E6 ;
			lngOrigem = jsonParam.getDouble("longitude") ;
			lngOrigem = lngOrigem / 1E6 ;
			
			System.out.println("Lat: "+ latOrigem+ " Lng: "+lngOrigem) ;
			
			distA = distFrom(latOrigem, lngOrigem, taxiA.getLatitude(), taxiA.getLongitude()) ;
			System.out.println("DistA: "+distA) ;
			distB = distFrom(latOrigem, lngOrigem, taxiB.getLatitude(), taxiB.getLongitude()) ;
			System.out.println("DistB: "+distB) ;
			distC = distFrom(latOrigem, lngOrigem, taxiC.getLatitude(), taxiC.getLongitude()) ;
			System.out.println("DistC: "+distC) ;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		if((distA <= distB) && (distA <= distC)){
			hm.put("Placa", taxiA.getPlaca()) ;
		}else if((distB <= distA) && (distB <= distC)){
			hm.put("Placa", taxiB.getPlaca()) ;
		}else if((distC <= distA) && (distC <= distB)){
			hm.put("Placa", taxiC.getPlaca()) ;
		}else {
			hm.put("Placa", "Nada foi encontrado") ;
		}
		
		JSONObject resposta = new JSONObject(hm) ;
		return resposta ;
		
	}//Fecha experiencia1
	
	public double distFrom(double lat1, double lng1, double lat2, double lng2) {
		//Raio da Terra em milhas
		double earthRadius = 3958.75; 
		//Diferença entre as latitudes e longitutdes, já convertendo os graus para Radianos
	    double dLat = Math.toRadians(lat2-lat1); 
	    double dLng = Math.toRadians(lng2-lng1);
	    //Aplicação da fórmula
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;
	    //Variável para converter de Milhas para Metros
	    int meterConversion = 1609; 
	    //Envia a distância convertida em metros
	    return new Double(dist * meterConversion).doubleValue();
	}//Fecha distFrom
}