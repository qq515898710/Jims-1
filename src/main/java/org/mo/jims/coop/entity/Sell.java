/***********************************************************************
 * Module:  TbSell.java
 * Author:  YK
 * Purpose: Defines the Class TbSell
 ***********************************************************************/
package org.mo.jims.coop.entity;

import java.io.Serializable;
import java.util.Date;

import org.mo.open.common.entity.User;
import org.mo.open.common.util.Sequence;

/**
 * 销售信息
 * 
 * @author moziqi
 *
 */
public class Sell implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private float unitCost;

	private int amount;

	private float sum;

	private java.util.Date time;

	private java.lang.String clearingForm;

	private java.lang.String headler;

	private GoodInfo goodInfo;

	private CustomerInfo customerInfo;

	private User user;

	public Sell() {
		super();
	}

	public Sell(float unitCost, int amount, float sum, Date time,
			String clearingForm, String headler,User user) {
		super();
		this.id = "sell" + Sequence.nextId();
		this.unitCost = unitCost;
		this.amount = amount;
		this.sum = sum;
		this.time = time;
		this.clearingForm = clearingForm;
		this.headler = headler;
		this.user=user;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.lang.String getClearingForm() {
		return clearingForm;
	}

	public void setClearingForm(java.lang.String clearingForm) {
		this.clearingForm = clearingForm;
	}

	public java.lang.String getHeadler() {
		return headler;
	}

	public void setHeadler(java.lang.String headler) {
		this.headler = headler;
	}

	public GoodInfo getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(GoodInfo goodInfo) {
		this.goodInfo = goodInfo;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}