package org.mo.jims.coop.dto;

import org.mo.jims.coop.entity.GoodInfo;
import org.mo.open.common.converter.JavaDateConverter;
import org.mo.open.common.exception.MyRuntimeException;


public class GoodInfoDTO implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String id;

	private java.lang.String name;

	private java.lang.String abbreviation;

	private java.lang.String origin;

	private java.lang.String units;

	private java.lang.String pack;

	private java.lang.String approvalNum;

	private java.lang.String batchNum;

	private java.lang.String memo;
	
	private String time;
	
	private String providerName;
	
	private String formtoken;
	
	public GoodInfoDTO() {
		super();
	}

	public GoodInfo toEditObject() throws MyRuntimeException {
		try{
			return new GoodInfo(id, name, abbreviation, origin, units, pack,
					approvalNum, batchNum, memo,
					JavaDateConverter.StringConverterDate(time));
		}catch(Exception e){
			throw new MyRuntimeException("toEditObject-GoodInfoDTO convert fail");
		}
	}
	
	public GoodInfo toAddObject() throws MyRuntimeException {
		try{
			return new GoodInfo(name, abbreviation, origin, units, pack,
					approvalNum, batchNum, memo);
		}catch(Exception e){
			throw new MyRuntimeException("toAddObject-GoodInfoDTO convert fail");
		}
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

	public java.lang.String getUnits() {
		return units;
	}

	public void setUnits(java.lang.String units) {
		this.units = units;
	}

	public java.lang.String getPack() {
		return pack;
	}

	public void setPack(java.lang.String pack) {
		this.pack = pack;
	}

	public java.lang.String getApprovalNum() {
		return approvalNum;
	}

	public void setApprovalNum(java.lang.String approvalNum) {
		this.approvalNum = approvalNum;
	}

	public java.lang.String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(java.lang.String batchNum) {
		this.batchNum = batchNum;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
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


	public String getProviderName() {
		return providerName;
	}


	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Override
	public String toString() {
		return "GoodInfoDTO [id=" + id + ", name=" + name + ", abbreviation="
				+ abbreviation + ", origin=" + origin + ", units=" + units
				+ ", pack=" + pack + ", approvalNum=" + approvalNum
				+ ", batchNum=" + batchNum + ", memo=" + memo + ", time="
				+ time + ", providerName=" + providerName + ", formtoken="
				+ formtoken + "]";
	}
	
}
