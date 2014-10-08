/***********************************************************************
 * Module:  TbCustomerInfo.java
 * Author:  YK
 * Purpose: Defines the Class TbCustomerInfo
 ***********************************************************************/
package org.mo.jims.coop.entity;

import java.io.Serializable;
import java.util.List;

import org.mo.open.common.util.Sequence;

/**
 * 客户信息
 * 
 * @author moziqi
 *
 */
public class CustomerInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String id;

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

	private List<Sell> sell;

	private List<SellReturn> sellReturn;

	public CustomerInfo() {
		super();
	}

	public CustomerInfo(String name, String abbreviation, String address,
			String postalCode, String phone, String fax, String contacts,
			String telephone, String email, String depositBank,
			String accountBank) {
		super();
		this.id = "c" + Sequence.nextId();
		this.name = name;
		this.abbreviation = abbreviation;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.fax = fax;
		this.contacts = contacts;
		this.telephone = telephone;
		this.email = email;
		this.depositBank = depositBank;
		this.accountBank = accountBank;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
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

	public List<Sell> getSell() {
		return sell;
	}

	public void setSell(List<Sell> sell) {
		this.sell = sell;
	}

	public List<SellReturn> getSellReturn() {
		return sellReturn;
	}

	public void setSellReturn(List<SellReturn> sellReturn) {
		this.sellReturn = sellReturn;
	}

}