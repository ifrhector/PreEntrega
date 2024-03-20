package com.coderhouse.pre.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "code_three_digits")
	private String codeThreeDigits;
	
	

	public Country(long id, String countryName, String codeThreeDigits) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.codeThreeDigits = codeThreeDigits;
	}

	public Country() {
		
	}
	
	public long getId() {
		return id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCodeThreeDigits() {
		return codeThreeDigits;
	}

	public void setCodeThreeDigits(String codeThreeDigits) {
		this.codeThreeDigits = codeThreeDigits;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryName=" + countryName + ", codeThreeDigits=" + codeThreeDigits + "]";
	}
	
}
