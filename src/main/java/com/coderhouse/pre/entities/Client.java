package com.coderhouse.pre.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	@Column(name = "local_phone")
	private String localPhone;
	
	@Column(name = "cel_phone")
	private String celPhone;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="country_id")
	private Country country;
	
	@Column(name = "country_id", insertable = false, updatable = false)
	private Long idCountry;

	public Client() {
		
	}

	public Client(String name, String lastName, String email, String localPhone, String celPhone, Long idCountry) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.localPhone = localPhone;
		this.celPhone = celPhone;
		this.idCountry = idCountry;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocalPhone() {
		return localPhone;
	}

	public void setLocalPhone(String localPhone) {
		this.localPhone = localPhone;
	}

	public String getCelPhone() {
		return celPhone;
	}

	public void setCelPhone(String celPhone) {
		this.celPhone = celPhone;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", localPhone="
				+ localPhone + ", celPhone=" + celPhone + ", country=" + country + ", idCountry=" + idCountry + "]";
	}
	

}
