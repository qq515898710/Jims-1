package org.mo.jims.coop.dto;

import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.StockReturn;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.open.common.converter.JavaDateConverter;
import org.mo.open.common.entity.User;
import org.mo.open.common.exception.MyRuntimeException;

public class StockReturnDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private float unitCost;

	private int amount;

	private float sum;

	private java.lang.String checkConclusion;

	private String time;

	private java.lang.String clearingForm;

	private java.lang.String handler;

	private String approval;

	private String goodName;

	private String providerName;

	private String username;

	private String formtoken;

	public StockReturn toEditObject(Approval approval, GoodInfo goodInfo,
			ProviderInfo providerInfo, User user) throws MyRuntimeException {
		try {
			return new StockReturn(id, unitCost, amount, sum, checkConclusion,
					JavaDateConverter.StringConverterDate(time), clearingForm,
					handler, approval, providerInfo, user, goodInfo);
		} catch (Exception e) {
			throw new MyRuntimeException("toEditObject--"
					+ getClass().getName() + " convert fail");
		}
	}

	public StockReturn toAddObject(Approval approval, GoodInfo goodInfo,
			ProviderInfo providerInfo, User user) throws MyRuntimeException {
		try {
			return new StockReturn(unitCost, amount, sum, checkConclusion,
					clearingForm, handler, approval, providerInfo, user,
					goodInfo);
		} catch (Exception e) {
			throw new MyRuntimeException("toAddObject--" + getClass().getName()
					+ " convert fail");
		}
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public java.lang.String getCheckConclusion() {
		return checkConclusion;
	}

	public void setCheckConclusion(java.lang.String checkConclusion) {
		this.checkConclusion = checkConclusion;
	}

	public String getFormtoken() {
		return formtoken;
	}

	public void setFormtoken(String formtoken) {
		this.formtoken = formtoken;
	}

	@Override
	public String toString() {
		return "StockReturnDTO [id=" + id 
				+ ", unitCost=" + unitCost + ", amount=" + amount + ", sum="
				+ sum + ", checkConclusion=" + checkConclusion + ", time="
				+ time + ", clearingForm=" + clearingForm + ", handler="
				+ handler + ", approval=" + approval + ", goodName=" + goodName
				+ ", providerName=" + providerName + ", username=" + username
				+ ", formtoken=" + formtoken + "]";
	}

}
