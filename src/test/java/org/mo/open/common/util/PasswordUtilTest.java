package org.mo.open.common.util;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class PasswordUtilTest extends BaseTest {
	
	private final String SALT = "/%El-B9ua* vbo@N#,WU[+Mp+c-5#zgP&1w^-I*#|r]i`HdQ7eMTA$UCFXnA]2xR";
	
	@Resource
	private Md5PasswordEncoder md5PasswordEncoder;

	public Md5PasswordEncoder getMd5PasswordEncoder() {
		return md5PasswordEncoder;
	}

	public void setMd5PasswordEncoder(Md5PasswordEncoder md5PasswordEncoder) {
		this.md5PasswordEncoder = md5PasswordEncoder;
	}

	@Test
	public void testEncodePasswordString() {
		String encodePassword = md5PasswordEncoder.encodePassword("123456",
				SALT);
		System.out.println(encodePassword);
	}

}
