package org.mo.open.common.util;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class PasswordUtil {

	private static Md5PasswordEncoder md5PasswordEncoder;
	

	public static String encodePassword(String password) {
		return encodePassword(password, null);
	}

	public static String encodePassword(String password, String salt) {
		return md5PasswordEncoder.encodePassword(password, salt);
	}
	
	
	public Md5PasswordEncoder getMd5PasswordEncoder() {
		return md5PasswordEncoder;
	}

	@Resource(name="md5PasswordEncoder")
	public void setMd5PasswordEncoder(Md5PasswordEncoder md5PasswordEncoder) {
		this.md5PasswordEncoder = md5PasswordEncoder;
	}
}
