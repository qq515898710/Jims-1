package org.mo.jims.coop.entity;

/**
 * 供应商与商品关系表
 * 
 * @author moziqi
 *
 */
public class ProviderGood implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private ProviderInfo providerInfo;

	private GoodInfo goodInfo;

	public ProviderInfo getProviderInfo() {
		return providerInfo;
	}

	public void setProviderInfo(ProviderInfo providerInfo) {
		this.providerInfo = providerInfo;
	}

	public GoodInfo getGoodInfo() {
		return goodInfo;
	}

	public void setGoodInfo(GoodInfo goodInfo) {
		this.goodInfo = goodInfo;
	}

}
