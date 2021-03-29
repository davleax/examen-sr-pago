package com.sr.pago.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sr.pago.bean.InfoRQ;
import com.sr.pago.conexion.Conexion;

public class CompraDaoImpl implements CompraDao {

	/*
	 * Dao que consulta en la tabla de compras
	 */

	@Override
	public List<InfoRQ> getAllCompras() {
		List<InfoRQ> compras = new ArrayList<>();
		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT * from compra";

		try {
			Conexion c = new Conexion();
			dbConnection = c.conexion();
			statement = (Statement) dbConnection.createStatement();

			System.out.println(selectTableSQL);

			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				InfoRQ infoRQ = new InfoRQ();
				infoRQ.setEmail(rs.getString("email"));
				compras.add(infoRQ);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return compras;

	}

	/**
	 * Dao que permite insetar una compra una compra
	 */
	@Override
	public boolean insertarCompra(InfoRQ compra) throws SQLException {
		Conexion c = new Conexion();
		// INSERT INTO `compra` (`id`, `email`, `name`, `lastName`, `cardNumber`,
		// `expirationDateYear`, `expirationDateMonth`, `gasType`, `amount`,
		// `gasStation`, `sellerName`)
		Connection dbConnection = null;
		String SQL_INSERT = "INSERT INTO COMPRA (ID, email, name, lastName, "
				+ "cardNumber,expirationDateYear, expirationDateMonth,gasType, amount,gasStation,sellerName )"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		dbConnection = c.conexion();
		PreparedStatement preparedStatement = (PreparedStatement) dbConnection.prepareStatement(SQL_INSERT);

		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString();

		preparedStatement.setString(1, uuidAsString);
		preparedStatement.setString(2, compra.getEmail());
		preparedStatement.setString(3, compra.getName());
		preparedStatement.setString(4, compra.getLastName());
		preparedStatement.setString(5, compra.getCardNumber());
		preparedStatement.setInt(6, compra.getExpirationDateYear().intValue());
		preparedStatement.setString(7, compra.getExpirationDateMonth());
		preparedStatement.setInt(8, compra.getGasType());
		preparedStatement.setDouble(9, compra.getAmount());
		preparedStatement.setString(10, compra.getGasStation());
		preparedStatement.setString(11, compra.getSellerName());

		int row = preparedStatement.executeUpdate();

		if (row > 0) {
			return true;
		}

		// rows affected
		System.out.println(row); // 1
		return false;
	}

}
