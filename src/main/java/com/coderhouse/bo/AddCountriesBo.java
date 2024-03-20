package com.coderhouse.bo;

import com.coderhouse.pre.controller.JavaDataBaseController;
import com.coderhouse.pre.entities.Country;

public class AddCountriesBo {

	private static final JavaDataBaseController controller = new JavaDataBaseController();

	public AddCountriesBo() {
		controller.getConnection();
	}

	public void addNewContries() {
		

		Country c1 = new Country();
		Country c2 = new Country();
		Country c3 = new Country();
		Country c4 = new Country();
		Country c5 = new Country();
		Country c6 = new Country();
		Country c7 = new Country();
		Country c8 = new Country();
		Country c9 = new Country();
		Country c10 = new Country();

		c1.setCountryName("México");
		c1.setCodeThreeDigits("MEX");
		c2.setCountryName("Argentina");
		c2.setCodeThreeDigits("ARG");
		c3.setCountryName("Colombia");
		c3.setCodeThreeDigits("COL");
		c4.setCountryName("Bolivia");
		c4.setCodeThreeDigits("BOL");
		c5.setCountryName("Clile");
		c5.setCodeThreeDigits("CHL");
		c6.setCountryName("Costa Rica");
		c6.setCodeThreeDigits("CRI");
		c7.setCountryName("Ecuador");
		c7.setCodeThreeDigits("ECU");
		c8.setCountryName("Venezuela");
		c8.setCodeThreeDigits("VEN");
		c9.setCountryName("Brasil");
		c9.setCodeThreeDigits("BRA");
		c10.setCountryName("Paraguay");
		c10.setCodeThreeDigits("PRY");

		controller.insertCountry(c1);
		controller.insertCountry(c2);
		controller.insertCountry(c3);
		controller.insertCountry(c4);
		controller.insertCountry(c5);
		controller.insertCountry(c6);
		controller.insertCountry(c7);
		controller.insertCountry(c8);
		controller.insertCountry(c9);
		controller.insertCountry(c10);
	}

}
