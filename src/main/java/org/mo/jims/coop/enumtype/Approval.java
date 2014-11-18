package org.mo.jims.coop.enumtype;

import java.util.HashMap;
import java.util.Map;


/**
 * 审批状态类
 * 
 * @author moziqi
 *
 */
public enum Approval {
	
	PASS("0", "通过"), 
	NOPASS("1", "未通过");

	private static final Map<String, Approval> cache = new HashMap<String, Approval>();

	static{
		for(Approval approval:values()){
			cache.put(approval.ident, approval);
		}
	}
	
	private final String ident;// 识别
	
	private final String content;

	private Approval(String ident, String content) {
		this.ident =  ident;
		this.content = content;
	}

	public String getIdent() {
		return ident;
	}

	public String getContent() {
		return content;
	}
	
	public static Approval ident(String ident){
		return cache.get(ident);
	}

}
