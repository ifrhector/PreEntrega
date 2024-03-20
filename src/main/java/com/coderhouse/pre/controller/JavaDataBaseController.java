package com.coderhouse.pre.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coderhouse.pre.entities.Client;
import com.coderhouse.pre.entities.Country;

public class JavaDataBaseController {

	private static final String DATA_BASE = "coderhouseHFR";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DATA_BASE;
	private static final String USER = "root";
	private static final String PASSWORD = "{Xjaskux3.";

	private Connection connection;

	// Manage connection
	public Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Coneccion Exitosa a la Base de Datos: " + DATA_BASE);
			} catch (SQLException e) {
				System.err.println("Error al al establecer la coneccion" + e.getMessage());
			}
		}
		return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Coneccion Cerrada!");
			} catch (SQLException e) {
				System.err.println("Error al al cerrar la coneccion" + e.getMessage());
			}

		}
	}

	// -------------CRUDS-------------

	// Countries
	public void insertCountry(Country country) {
		PreparedStatement statement = null;
		String query = "INSERT INTO countries (code_three_digits, country_name) VALUES (?, ?)";

		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, country.getCodeThreeDigits());
			statement.setString(2, country.getCountryName());
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				throw new SQLException("No se pudo insertar el curso: " + country.getCountryName());
			}
			System.out.println("El País " + country.getCountryName() + ", fue insertado correctamente");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}

	public List<Country> getAllCountry() {
		Statement statement = null;
		ResultSet resultSet = null;

		List<Country> result = new ArrayList<Country>();

		String query = "SELECT id, code_three_digits, country_name FROM countries";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Country country = new Country(resultSet.getLong("id"), resultSet.getString("country_name"),
						resultSet.getString("code_three_digits"));
				result.add(country);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement o el resultSet: " + e.getMessage());
			}
		}

		return result;
	}

	// Clients
	public void insertClient(Client client) {
		PreparedStatement statement = null;
		String query = "INSERT INTO clients (cel_phone, email, country_id, last_name, local_phone, name) VALUES (?, ?, ?, ?, ?, ?)";

		try {

			statement = connection.prepareStatement(query);
			
			statement.setString(1, client.getCelPhone());
			statement.setString(2, client.getEmail());
			statement.setLong(3, client.getIdCountry());
			statement.setString(4, client.getLastName());
			statement.setString(5, client.getLocalPhone());
			statement.setString(6, client.getName());

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				throw new SQLException("Error on insert: " + client.getName() + " " + client.getName());
			}
			System.out.println("Insert: " + client.getName() + " " + client.getName());

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}
	
	public void listClients(String flied, String order) {
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		String query = "SELECT cl.*, co.country_name FROM clients cl JOIN countries co ON co.id = cl.country_id ORDER BY " + flied + " " + order;
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println(
						"Cliente: " + resultSet.getString("name") + " " +
						resultSet.getString("last_name") + "\n" +
						"Celular: " + resultSet.getString("cel_phone") + "\n" +
						"Email: " + resultSet.getString("email") + "\n" +
						"Teléfono: " + resultSet.getString("local_phone") + "\n" +
						"País: " + resultSet.getString("country_name") +
						"\n-----------------------------------------------------------"
						);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement o el resultSet: " + e.getMessage());
			}
		}
		
	}
}
