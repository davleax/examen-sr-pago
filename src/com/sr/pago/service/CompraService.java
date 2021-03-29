package com.sr.pago.service;

import java.util.List;

import com.sr.pago.bean.InfoRQ;

public interface CompraService {
	/**
	 * 
	 * @return
	 */
	List<InfoRQ> getAllCompras();

	/**
	 * 
	 * @param compra
	 * @throws Exception
	 */
	void insertarCompra(InfoRQ compra) throws Exception;

}
