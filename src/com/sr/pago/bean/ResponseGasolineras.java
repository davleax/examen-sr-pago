package com.sr.pago.bean;

import java.util.List;

/**
 * 
 * @author Alejo Trujllo Davalos
 *
 */
public class ResponseGasolineras {

	private Paginador pagination;
	private List<Gasolinera> results;

	public Paginador getPagination() {
		return pagination;
	}

	public void setPagination(Paginador pagination) {
		this.pagination = pagination;
	}

	public List<Gasolinera> getResults() {
		return results;
	}

	public void setResults(List<Gasolinera> results) {
		this.results = results;
	}

}
