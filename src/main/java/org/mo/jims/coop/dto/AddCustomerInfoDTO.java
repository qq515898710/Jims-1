package org.mo.jims.coop.dto;

import org.mo.jims.coop.entity.CustomerInfo;

public class AddCustomerInfoDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String name;

	private java.lang.String abbreviation;

	private java.lang.String address;

	private java.lang.String postalCode;

	private java.lang.String phone;

	private java.lang.String fax;

	private java.lang.String contacts;

	private java.lang.String telephone;

	private java.lang.String email;

	private java.lang.String depositBank;

	private java.lang.String accountBank;

	public CustomerInfo toObject() {
		CustomerInfo customerInfo = new CustomerInfo(name, abbreviation,
				address, postalCode, phone, fax, contacts, telephone, email,
				depositBank, accountBank);
		return customerInfo;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(java.lang.String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(java.lang.String postalCode) {
		this.postalCode = postalCode;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getFax() {
		return fax;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public java.lang.String getContacts() {
		return contacts;
	}

	public void setContacts(java.lang.String contacts) {
		this.contacts = contacts;
	}

	public java.lang.String getTelephone() {
		return telephone;
	}

	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(java.lang.String depositBank) {
		this.depositBank = depositBank;
	}

	public java.lang.String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(java.lang.String accountBank) {
		this.accountBank = accountBank;
	}

	@Override
	public String toString() {
		return "AddCustomerInfoDTO [name=" + name + ", abbreviation="
				+ abbreviation + ", address=" + address + ", postalCode="
				+ postalCode + ", phone=" + phone + ", fax=" + fax
				+ ", contacts=" + contacts + ", telephone=" + telephone
				+ ", email=" + email + ", depositBank=" + depositBank
				+ ", accountBank=" + accountBank + "]";
	}
}
