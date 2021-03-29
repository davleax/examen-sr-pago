package com.sr.pago.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class ClientRest {

	Client cliente;

	public ClientRest() {
		this.cliente = ClientBuilder.newClient();
	}

	public String servicioSrPago() {
		String resultado = "";
		try {
			resultado = this.cliente.target("https://api.datos.gob.mx/v1/precio.gasolina.publico")
					.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(String.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
