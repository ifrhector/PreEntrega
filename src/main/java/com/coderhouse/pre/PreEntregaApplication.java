package com.coderhouse.pre;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.bo.AddClientsBo;
import com.coderhouse.bo.AddCountriesBo;
import com.coderhouse.pre.controller.JavaDataBaseController;

@SpringBootApplication
public class PreEntregaApplication {

	private static Scanner data;

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(PreEntregaApplication.class, args);
		
		String field = "";
		String orderList = "";

		//Add countries
		AddCountriesBo addCountries = new AddCountriesBo();
		addCountries.addNewContries();
		
		//Add clients
		AddClientsBo addClients = new AddClientsBo();
		addClients.addClients();
		
		data = new Scanner(System.in);

		//show options menu
		System.out.print("Sleccione el campo ordenante de la lista: \n");
		System.out.print("Nombre [1] \n");
		System.out.print("Apellido [2] \n");
		System.out.print("País [3] \n");
		
		int order = data.nextInt();

		// Return new list sorted by user selection
		switch (order) {
		case 1: {
			field = "cl.name";
			break;
		}
		case 2: {
			field = "cl.last_name";
			break;
		}
		case 3: {
			field = "co.country_name";
			break;
		}
		default:
			throw new IllegalArgumentException("Valor no listado: " + order);
		}
		
		//Return order from list
		System.out.print("Orden: \n");
		System.out.print("Ascendente [1]\n");
		System.out.print("Descendente [2] \n");
		
		int asc = data.nextInt();
		
		switch (asc) {
		case 1: {
			orderList = "ASC";
			break;
		}
		case 2: {
			orderList = "DESC";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + asc);
		}
		
		//List clients
		JavaDataBaseController j = new JavaDataBaseController();
		j.getConnection();
		j.listClients(field, orderList);

	}

}
