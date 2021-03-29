package com.sr.pago.service;

import java.util.List;

import com.google.gson.Gson;
import com.sr.pago.bean.Gasolinera;
import com.sr.pago.bean.InfoRQ;
import com.sr.pago.bean.ResponseGasolineras;
import com.sr.pago.client.ClientRest;
import com.sr.pago.dao.CompraDaoImpl;

/**
 * 
 * @author Alejo Trujillo Davalos
 *
 */
public class CompraServiceImpl implements CompraService {

	@Override
	public List<InfoRQ> getAllCompras() {
		CompraDaoImpl dao = new CompraDaoImpl();
		return dao.getAllCompras();
	}

	@Override
	public void insertarCompra(InfoRQ compra) throws Exception {

		/**
		 * Consulta el servicio de las gasolineras
		 */
		ClientRest restClient = new ClientRest();
		String resultado = restClient.servicioSrPago();
		// Parsea la respuesta del servidor objetos

		Gson gson = new Gson();
		ResponseGasolineras data = gson.fromJson(resultado, ResponseGasolineras.class);
		/**
		 * Validacion de negocio
		 */
		if (compra.getAmount() < 0) {
			throw new Exception("Error amount debe ser mayor a 0");
		}
		if (compra.getName().equals("")) {
			throw new Exception("Error nombre no debe de estar vacion");
		}
		/**
		 * Valida que eista la gas esation enla lista del servicio
		 */
		CompraDaoImpl dao = new CompraDaoImpl();
		for (Gasolinera element : data.getResults()) {

			if (compra.getGasStation().equals(element.get_id())) {
				System.out.println("La gasolinera es :" + element.getCalle());
				compra.setGasStation(element.get_id());

			}
		}
		/**
		 * Inseta la compra
		 */
		dao.insertarCompra(compra);
	}

}
