package br.pucrs.school_system.models;

public class Address {
	private String street;
	private String number;
	private String complement;
	private String zipcode;

	public Address(String street, String number, String complement, String zipcode) {
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return this.complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}