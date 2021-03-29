package com.sr.pago.dao;

import java.sql.SQLException;
import java.util.List;

import com.sr.pago.bean.InfoRQ;

public interface CompraDao {
	List<InfoRQ> getAllCompras();
	boolean insertarCompra(InfoRQ compra) throws SQLException;
}
