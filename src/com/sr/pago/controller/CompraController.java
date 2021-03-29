package com.sr.pago.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sr.pago.bean.InfoRQ;
import com.sr.pago.service.CompraServiceImpl;
/**
 * 
 * @author Alejo Trujillo Davalos
 * Rest para la aplicacion Compras 
 *
 */
@Path("/compra")
public class CompraController {

	/*/
	 * Metodo que permite registar una compra
	 */
	@POST
	@Path("/post/compraGasolina")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response compraGasolina(InfoRQ obj) {
		com.sr.pago.bean.Response response = new com.sr.pago.bean.Response();
		try {

			response.setSuccess(true);
			response.setError(null);
			response.setMessage("Correcto");

			CompraServiceImpl compraService = new CompraServiceImpl();
			compraService.insertarCompra(obj);
			return Response.status(201).entity(response).build();
		} catch (Exception e) {
			response.setSuccess(false);
			response.setError(e.getMessage());
			response.setMessage("Ocurrio un error");
			return Response.status(500).entity(response).build();
		}
	}

}
