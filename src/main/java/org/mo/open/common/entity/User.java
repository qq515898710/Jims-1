/***********************************************************************
 * Module:  TbUser.java
 * Author:  YK
 * Purpose: Defines the Class TbUser
 ***********************************************************************/
package org.mo.open.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.mo.jims.coop.entity.InventoryInfo;
import org.mo.jims.coop.entity.Sell;
import org.mo.jims.coop.entity.SellReturn;
import org.mo.jims.coop.entity.Stock;
import org.mo.jims.coop.entity.StockReturn;
import org.mo.open.common.util.Sequence;

/**
 * 操作员信息
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String account;

	private java.lang.String username;

	private java.lang.String password;

	private Date createDate;

	private Date lastestDate;

	private List<Role> role;

	private List<UserLog> userLog;

	private List<Sell> sell;

	private List<SellReturn> sellReturn;

	private List<Stock> stock;

	private List<StockReturn> stockReturn;

	private List<InventoryInfo> inventoryInfo;

	public User() {
		super();
	}

	public User(String username, String password, Date createDate,
			Date lastestDate) {
		super();
		this.account = "u" + Sequence.nextId();
		this.username = username;
		this.password = password;
		this.createDate = createDate;
		this.lastestDate = lastestDate;
	}

	public java.lang.String getAccount() {
		return account;
	}

	public void setAccount(java.lang.String account) {
		this.account = account;
	}

	public java.lang.String getUsername() {
		return username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastestDate() {
		return lastestDate;
	}

	public void setLastestDate(Date lastestDate) {
		this.lastestDate = lastestDate;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public List<UserLog> getUserLog() {
		return userLog;
	}

	public void setUserLog(List<UserLog> userLog) {
		this.userLog = userLog;
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

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	public List<StockReturn> getStockReturn() {
		return stockReturn;
	}

	public void setStockReturn(List<StockReturn> stockReturn) {
		this.stockReturn = stockReturn;
	}

	public List<InventoryInfo> getInventoryInfo() {
		return inventoryInfo;
	}

	public void setInventoryInfo(List<InventoryInfo> inventoryInfo) {
		this.inventoryInfo = inventoryInfo;
	}

}