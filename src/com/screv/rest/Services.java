package com.screv.rest;

import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
		
		Taxi taxi1 = new Taxi("ABC-1234", -25.438698, -49.237869) ;
		Taxi taxi2 = new Taxi("ABD-2345", -25.443852, -49.24186) ;
		Taxi taxi3 = new Taxi("ACB-3456", -25.443697, -49.234006) ;
		
		/*
		 * -25.444162,-49.238813 Próximo de 1
		 * -25.440209,-49.239371 Próximo de 2
		 * -25.441992,-49.235938 Próximo de 3
		 * */
		
		HashMap hm = new HashMap() ;
		hm.put("tax1lng", taxi1.getLongitude()) ;
		hm.put("tax1lat", taxi1.getLatitude()) ;
		hm.put("tax1placa", taxi1.getPlaca()) ;
		
		hm.put("tax2lng", taxi2.getLongitude()) ;
		hm.put("tax2lat", taxi2.getLatitude()) ;
		hm.put("tax2placa", taxi2.getPlaca()) ;
		
		hm.put("tax3lng", taxi3.getLongitude()) ;
		hm.put("tax3lat", taxi3.getLatitude()) ;
		hm.put("tax3placa", taxi3.getPlaca()) ;
		
		/*
		hm.put("taxi1", taxi1) ;
		hm.put("taxi2", taxi2) ;
		hm.put("taxi3", taxi3) ;
		*/
		
		JSONObject resposta = new JSONObject(hm) ;
		return resposta ;
	}
}