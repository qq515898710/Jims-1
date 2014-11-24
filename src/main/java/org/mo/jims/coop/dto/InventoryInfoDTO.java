package org.mo.jims.coop.dto;

import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.InventoryInfo;
import org.mo.open.common.converter.JavaDateConverter;
import org.mo.open.common.entity.User;
import org.mo.open.common.exception.MyRuntimeException;

public class InventoryInfoDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private java.lang.String specification;

	private float unitCost;

	private int amount;

	private String goodName;

	private String username;

	private String time;

	private String formtoken;

	public InventoryInfo toEditObject(GoodInfo goodInfo, User user)
			throws MyRuntimeException {
		try {
			return new InventoryInfo(id, specification, unitCost, amount,
					goodInfo, user, JavaDateConverter.StringConverterDate(time));
		} catch (Exception e) {
			throw new MyRuntimeException(
					"toEditObject-InventoryInfoDTO convert fail");
		}
	}

	public InventoryInfo toAddObject(GoodInfo goodInfo, User user)
			throws MyRuntimeException {
		try {
			return new InventoryInfo(specification, unitCost, amount, goodInfo,
					user);
		} catch (Exception e) {
			throw new MyRuntimeException(
					"toAddObject-InventoryInfoDTO convert fail");
		}
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getSpecification() {
		return specification;
	}

	public void setSpecification(java.lang.String specification) {
		this.specification = specification;
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

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFormtoken() {
		return formtoken;
	}

	public void setFormtoken(String formtoken) {
		this.formtoken = formtoken;
	}

	@Override
	public String toString() {
		return "InventoryInfoDTO [id=" + id + ", specification="
				+ specification + ", unitCost=" + unitCost + ", amount="
				+ amount + ", goodName=" + goodName + ", username=" + username
				+ ", time=" + time + ", formtoken=" + formtoken + "]";
	}

}
