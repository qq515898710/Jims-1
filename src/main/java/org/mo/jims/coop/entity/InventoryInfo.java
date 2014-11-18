/***********************************************************************
 * Module:  TbInventoryInfo.java
 * Author:  YK
 * Purpose: Defines the Class TbInventoryInfo
 ***********************************************************************/
package org.mo.jims.coop.entity;

import java.io.Serializable;
import java.util.Date;

import org.mo.open.common.entity.User;
import org.mo.open.common.util.Sequence;

/**
 * 库存信息
 * 
 */
public class InventoryInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private java.lang.String specification;

	private float unitCost;

	private int amount;
	
	private GoodInfo goodInfo;

	private User user;

	private Date time;

	public InventoryInfo() {
		super();
	}

	public InventoryInfo(String id, String specification, float unitCost,
			int amount, GoodInfo goodInfo, User user, Date time) {
		super();
		this.id = id;
		this.specification = specification;
		this.unitCost = unitCost;
		this.amount = amount;
		this.user = user;
		this.goodInfo = goodInfo;
		this.time = time;
	}

	public InventoryInfo(String specification, float unitCost, int amount,
			GoodInfo goodInfo, User user, Date time) {
		super();
		this.id = "i" + Sequence.nextId();
		this.specification = specification;
		this.unitCost = unitCost;
		this.amount = amount;
		this.user = user;
		this.goodInfo = goodInfo;
		this.time = time;
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

	public GoodInfo getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(GoodInfo goodInfo) {
		this.goodInfo = goodInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "InventoryInfo [id=" + id + ", specification=" + specification
				+ ", unitCost=" + unitCost + ", amount=" + amount
				+ ", goodInfo=" + goodInfo.toString() + ", user=" + user.toString() + ", time="
				+ time + "]";
	}
	
	

}