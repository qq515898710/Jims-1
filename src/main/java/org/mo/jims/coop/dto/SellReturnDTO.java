package org.mo.jims.coop.dto;

import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.SellReturn;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.open.common.entity.User;
import org.mo.open.common.exception.MyRuntimeException;

public class SellReturnDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private String unitCost;

	private String amount;

	private String sum;

	private String time;

	private java.lang.String clearingForm;

	private java.lang.String handler;

	private String approval;

	private String goodName;

	private String customerName;

	private String username;

	private String formtoken;

	public SellReturn toEditObject(Approval approval) throws MyRuntimeException {
		try {
			return new SellReturn(id, Float.valueOf(unitCost),
					Integer.valueOf(amount), Float.valueOf(sum),approval);
		} catch (Exception e) {
			throw new MyRuntimeException(
					"toEditObject-SellReturnDTO convert fail");
		}
	}

	public SellReturn toAddObject(Approval approval, GoodInfo goodInfo,
			CustomerInfo customerInfo, User user) throws MyRuntimeException {
		try {
			return new SellReturn(Float.valueOf(unitCost),
					Integer.valueOf(amount), Float.valueOf(sum), clearingForm, handler,
					approval, goodInfo, customerInfo, user);
		} catch (Exception e) {
			throw new MyRuntimeException(
					"toAddObject-SellReturnDTO convert fail");
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFormtoken() {
		return formtoken;
	}

	public void setFormtoken(String formtoken) {
		this.formtoken = formtoken;
	}

	@Override
	public String toString() {
		return "SellReturnDTO [id=" + id + ", unitCost=" + unitCost
				+ ", amount=" + amount + ", sum=" + sum + ", time=" + time
				+ ", clearingForm=" + clearingForm + ", handler=" + handler
				+ ", approval=" + approval + ", goodName=" + goodName
				+ ", customerName=" + customerName + ", username=" + username
				+ ", formtoken=" + formtoken + "]";
	}

}
