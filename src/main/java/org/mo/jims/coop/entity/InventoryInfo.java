/***********************************************************************
 * Module:  TbInventoryInfo.java
 * Author:  YK
 * Purpose: Defines the Class TbInventoryInfo
 ***********************************************************************/
package org.mo.jims.coop.entity;

import java.io.Serializable;

import org.mo.open.common.entity.User;
import org.mo.open.common.util.Sequence;

/**
 * 库存信息
 * 
 */
public class InventoryInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private java.lang.String name;

	private java.lang.String abbreviation;

	private java.lang.String origin;

	private java.lang.String specification;

	private java.lang.String pack;

	private java.lang.String units;

	private float unitCost;

	private int amount;

	private User user;

	public InventoryInfo() {
		super();
	}

	public InventoryInfo(String name, String abbreviation, String origin,
			String specification, String pack, String units, float unitCost,
			int amount,User user) {
		super();
		this.id = "i" + Sequence.nextId();
		this.name = name;
		this.abbreviation = abbreviation;
		this.origin = origin;
		this.specification = specification;
		this.pack = pack;
		this.units = units;
		this.unitCost = unitCost;
		this.amount = amount;
		this.user = user;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(java.lang.String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public java.lang.String getOrigin() {
		return origin;
	}

	public void setOrigin(java.lang.String origin) {
		this.origin = origin;
	}

	public java.lang.String getSpecification() {
		return specification;
	}

	public void setSpecification(java.lang.String specification) {
		this.specification = specification;
	}

	public java.lang.String getPack() {
		return pack;
	}

	public void setPack(java.lang.String pack) {
		this.pack = pack;
	}

	public java.lang.String getUnits() {
		return units;
	}

	public void setUnits(java.lang.String units) {
		this.units = units;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}