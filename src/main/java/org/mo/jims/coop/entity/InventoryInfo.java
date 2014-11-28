/***********************************************************************
 * Module:  TbInventoryInfo.java
 * Author:  YK
 * Purpose: Defines the Class TbInventoryInfo
 ***********************************************************************/
package org.mo.jims.coop.entity;

import java.io.Serializable;
import java.util.Date;

import org.mo.open.common.util.Sequence;

/**
 * 库存信息
 * 
 */
public class InventoryInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private float unitCost;

	private int amount;

	private GoodInfo goodInfo;

	private Date time;

	public InventoryInfo() {
		super();
	}

	public InventoryInfo(String id, float unitCost, int amount,
			GoodInfo goodInfo, Date time) {
		super();
		this.id = id;
		this.unitCost = unitCost;
		this.amount = amount;
		this.goodInfo = goodInfo;
		this.time = time;
	}

	public InventoryInfo(float unitCost, int amount, GoodInfo goodInfo) {
		super();
		this.id = "i" + Sequence.nextId();
		this.unitCost = unitCost;
		this.amount = amount;
		this.goodInfo = goodInfo;
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

	public GoodInfo getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(GoodInfo goodInfo) {
		this.goodInfo = goodInfo;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "InventoryInfo [id=" + id + ", unitCost=" + unitCost
				+ ", amount=" + amount + ", goodInfo=" + goodInfo.toString()
				+ ", time=" + time + "]";
	}

}