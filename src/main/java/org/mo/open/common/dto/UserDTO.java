package org.mo.open.common.dto;

import org.mo.open.common.entity.User;

public class UserDTO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String account;
	
	private String username;
	
	private String roleName;

	private String password;
	
	private String formtoken;
	
	private String repassword;

	public User toAddObject(){
		User user = new User(username, password);
		return user;
	}
	
	public User toEditObject(){
		User user = new User(account, username, password);
		return user;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getFormtoken() {
		return formtoken;
	}

	public void setFormtoken(String formtoken) {
		this.formtoken = formtoken;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Override
	public String toString() {
		return "UserDTO [account=" + account + ", username=" + username
				+ ", roleName=" + roleName + ", password=" + password + "]";
	}
	
}
