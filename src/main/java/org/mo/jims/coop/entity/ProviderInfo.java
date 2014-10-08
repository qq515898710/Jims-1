/***********************************************************************
 * Module:  TbProviderInfo.java
 * Author:  YK
 * Purpose: Defines the Class TbProviderInfo
 ***********************************************************************/
package org.mo.jims.coop.entity;

import java.io.Serializable;
import java.util.List;

import org.mo.open.common.util.Sequence;

/**
 * 供应商信息
 * 
 */
public class ProviderInfo implements Serializable {
	/**
	 * 
	 */
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

	private java.lang.String depositBank;

	private java.lang.String email;

	private List<Stock> tbStock;

	private List<StockReturn> tbStockReturn;

	private List<GoodInfo> goodInfo;

	public ProviderInfo() {
		super();
	}

	public ProviderInfo(String pname, String abbreviation, String address,
			String postalCode, String phone, String fax, String contacts,
			String telephone, String depositBank, String email) {
		super();
		this.id = "p" + Sequence.nextId();
		this.name = pname;
		this.abbreviation = abbreviation;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.fax = fax;
		this.contacts = contacts;
		this.telephone = telephone;
		this.depositBank = depositBank;
		this.email = email;
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

	public java.lang.String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(java.lang.String depositBank) {
		this.depositBank = depositBank;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public List<Stock> getTbStock() {
		return tbStock;
	}

	public void setTbStock(List<Stock> tbStock) {
		this.tbStock = tbStock;
	}

	public List<StockReturn> getTbStockReturn() {
		return tbStockReturn;
	}

	public void setTbStockReturn(List<StockReturn> tbStockReturn) {
		this.tbStockReturn = tbStockReturn;
	}

	public List<GoodInfo> getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(List<GoodInfo> goodInfo) {
		this.goodInfo = goodInfo;
	}

}