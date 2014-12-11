/***********************************************************************
 * Module:  TbSell.java
 * Author:  YK
 * Purpose: Defines the Class TbSell
 ***********************************************************************/
package org.mo.jims.coop.entity;

import java.io.Serializable;

import org.mo.jims.coop.enumtype.Approval;
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

	private java.lang.String handler;
	
	private Approval approval;

	private GoodInfo goodInfo;

	private CustomerInfo customerInfo;

	private User user;

	public Sell() {
		super();
	}

	public Sell(String id, float unitCost, int amount, float sum, Approval approval) {
		super();
		this.id = id;
		this.unitCost = unitCost;
		this.amount = amount;
		this.sum = sum;
		this.approval = approval;

	}

	public Sell(float unitCost, int amount, float sum, String clearingForm,
			String handler, Approval approval, GoodInfo goodInfo,
			CustomerInfo customerInfo, User user) {
		super();
		this.id = "sell" + Sequence.nextId();
		this.unitCost = unitCost;
		this.amount = amount;
		this.sum = sum;
		this.clearingForm = clearingForm;
		this.handler = handler;
		this.approval = approval;
		this.user = user;
		this.goodInfo = goodInfo;
		this.customerInfo = customerInfo;
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

	public java.lang.String getHandler() {
		return handler;
	}

	public void setHandler(java.lang.String handler) {
		this.handler = handler;
	}
	
	public Approval getApproval() {
		return approval;
	}

	public void setApproval(Approval approval) {
		this.approval = approval;
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

	@Override
	public String toString() {
		return "Sell [id=" + id + ", unitCost=" + unitCost + ", amount="
				+ amount + ", sum=" + sum + ", time=" + time
				+ ", clearingForm=" + clearingForm + ", handler=" + handler
				+ ", approval=" + approval.getContent() + ", goodInfo=" + goodInfo
				+ ", customerInfo=" + customerInfo.toString() + ", user=" + user.toString() + "]";
	}
	
}