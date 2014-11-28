package org.mo.jims.coop.dto;

import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.Stock;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.open.common.converter.JavaDateConverter;
import org.mo.open.common.entity.User;
import org.mo.open.common.exception.MyRuntimeException;

public class StockDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private String unitCost;

	private String amount;

	private String sum;

	private java.lang.String checkConclusion;

	private String time;

	private java.lang.String clearingForm;

	private java.lang.String handler;

	private String approval;

	private String goodName;

	private String providerName;

	private String username;

	private String formtoken;

	public StockDTO() {
		super();
	}

	public Stock toEditObject(Approval approval, GoodInfo goodInfo,
			ProviderInfo providerInfo, User user) throws MyRuntimeException {
		try {
			return new Stock(id, Float.valueOf(unitCost),
					Integer.valueOf(amount), Float.valueOf(sum),
					checkConclusion,
					JavaDateConverter.StringConverterDate(time), clearingForm,
					handler, approval, providerInfo, user, goodInfo);
		} catch (Exception e) {
			throw new MyRuntimeException("toEditObject--"
					+ getClass().getName() + " convert fail");
		}
	}

	public Stock toAddObject(Approval approval, GoodInfo goodInfo,
			ProviderInfo providerInfo, User user) throws MyRuntimeException {
		try {
			return new Stock(Float.valueOf(unitCost), Integer.valueOf(amount),
					Float.valueOf(sum), checkConclusion, clearingForm, handler,
					approval, providerInfo, goodInfo, user);
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

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
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
		return "StockDTO [id=" + id + ", unitCost=" + unitCost + ", amount="
				+ amount + ", sum=" + sum + ", checkConclusion="
				+ checkConclusion + ", time=" + time + ", clearingForm="
				+ clearingForm + ", handler=" + handler + ", approval="
				+ approval + ", goodName=" + goodName + ", providerName="
				+ providerName + ", username=" + username + ", formtoken="
				+ formtoken + "]";
	}
}
