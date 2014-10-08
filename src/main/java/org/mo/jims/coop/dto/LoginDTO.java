package org.mo.jims.coop.dto;

import java.io.Serializable;

import org.mo.open.common.entity.User;

public class LoginDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String account;

	private String password;

	private String code;

	public User toObject() {
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		return user;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
