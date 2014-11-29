/***********************************************************************
 * Module:  TbStockReturn.java
 * Author:  YK
 * Purpose: Defines the Class TbStockReturn
 ***********************************************************************/
package org.mo.jims.coop.entity;

import java.io.Serializable;
import java.util.Date;

import org.mo.jims.coop.enumtype.Approval;
import org.mo.open.common.entity.User;
import org.mo.open.common.util.Sequence;

/**
 * 进货退货信息
 * 
 */
public class StockReturn implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private float unitCost;

	private int amount;

	private float sum;

	private java.lang.String checkConclusion;

	private java.util.Date time;

	private java.lang.String clearingForm;

	private java.lang.String handler;

	private Approval approval;

	private ProviderInfo providerInfo;

	private User user;

	private GoodInfo goodInfo;

	public StockReturn() {
		super();
	}

	public StockReturn(String id, float unitCost,
			int amount, float sum, String checkConclusion, Date time,
			String clearingForm, String handler,Approval approval, ProviderInfo providerInfo,
			User user, GoodInfo goodInfo) {
		super();
		this.id = id;
		this.unitCost = unitCost;
		this.amount = amount;
		this.sum = sum;
		this.checkConclusion = checkConclusion;
		this.time = time;
		this.clearingForm = clearingForm;
		this.handler = handler;
		this.approval = approval;
		this.providerInfo = providerInfo;
		this.user = user;
		this.goodInfo = goodInfo;
	}

	public StockReturn(float unitCost, int amount,
			float sum, String checkConclusion, String clearingForm,
			String handler,Approval approval, ProviderInfo providerInfo, User user,
			GoodInfo goodInfo) {
		super();
		this.id = "stockr" + Sequence.nextId();
		this.unitCost = unitCost;
		this.amount = amount;
		this.sum = sum;
		this.checkConclusion = checkConclusion;
		this.clearingForm = clearingForm;
		this.handler = handler;
		this.approval = approval;
		this.providerInfo = providerInfo;
		this.goodInfo = goodInfo;
		this.user = user;
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

	public java.lang.String getCheckConclusion() {
		return checkConclusion;
	}

	public void setCheckConclusion(java.lang.String checkConclusion) {
		this.checkConclusion = checkConclusion;
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

	public ProviderInfo getProviderInfo() {
		return providerInfo;
	}

	public void setProviderInfo(ProviderInfo providerInfo) {
		this.providerInfo = providerInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GoodInfo getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(GoodInfo goodInfo) {
		this.goodInfo = goodInfo;
	}

	@Override
	public String toString() {
		return "StockReturn [id=" + id
				+ ", unitCost=" + unitCost + ", amount=" + amount + ", sum="
				+ sum + ", checkConclusion=" + checkConclusion + ", time="
				+ time + ", clearingForm=" + clearingForm + ", handler="
				+ handler + ", approval=" + approval.getContent()
				+ ", providerInfo=" + providerInfo.toString() + ", user="
				+ user.toString() + ", goodInfo=" + goodInfo.toString() + "]";
	}

}