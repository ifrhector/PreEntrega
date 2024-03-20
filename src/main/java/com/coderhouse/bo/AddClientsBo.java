package com.coderhouse.bo;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import com.coderhouse.pre.controller.JavaDataBaseController;
import com.coderhouse.pre.entities.Client;
import com.coderhouse.pre.entities.Country;

public class AddClientsBo {

	private static final JavaDataBaseController controller = new JavaDataBaseController();
	
	public AddClientsBo() {
		controller.getConnection();
		
	}
	
	public void addClients() throws SQLException {

		
		List<Country> countries = controller.getAllCountry();
		
		Client cli_01 = new Client("Héctor", "Flores", "hector@test.com", getPhone(), getPhone(), countries.get(0).getId());
		Client cli_02 = new Client("Sara", "Cuevas", "sara@test.com", getPhone(), getPhone(), countries.get(1).getId());
		Client cli_03 = new Client("Javier", "Gonzalez", "javo@test.com", getPhone(), getPhone(), countries.get(2).getId());
		Client cli_04 = new Client("Oscar", "Najera", "oscar@test.com", getPhone(), getPhone(), countries.get(3).getId());
		Client cli_05 = new Client("Gerardo", "Garduño", "gar@test.com", getPhone(), getPhone(), countries.get(4).getId());
		Client cli_06 = new Client("Otto", "Wamp", "otto@test.com", getPhone(), getPhone(), countries.get(5).getId());
		Client cli_07 = new Client("Saúl", "Gudman", "gudman@test.com", getPhone(), getPhone(), countries.get(6).getId());
		Client cli_08 = new Client("Fernanda", "Suarez", "fer@test.com", getPhone(), getPhone(), countries.get(7).getId());
		Client cli_09 = new Client("Alejandra", "Fauno", "ale@test.com", getPhone(), getPhone(), countries.get(8).getId());
		Client cli_10 = new Client("Mengana", "Ortiz", "menga@test.com", getPhone(), getPhone(), countries.get(9).getId());
		
		controller.insertClient(cli_01);
		controller.insertClient(cli_02);
		controller.insertClient(cli_03);
		controller.insertClient(cli_04);
		controller.insertClient(cli_05);
		controller.insertClient(cli_06);
		controller.insertClient(cli_07);
		controller.insertClient(cli_08);
		controller.insertClient(cli_09);
		controller.insertClient(cli_10);
	}
	
	private String getPhone() {
		Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        
        return phoneNumber;
	}
	

}
