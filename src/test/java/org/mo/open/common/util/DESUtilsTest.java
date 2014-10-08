package org.mo.open.common.util;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mo.open.common.util.DESUtils;

public class DESUtilsTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("加密的字符串例如:帐号root,密码123456");
		System.out.println("正在加密....");
		String encryptString = DESUtils.getEncryptString("root");
		String encryptString2 = DESUtils.getEncryptString("123456");
		System.out.println("加密完成,输出加密结果:");
		System.out.println("帐号:" + encryptString);
		System.out.println("密码:" + encryptString2);
		System.out.println("正在解密...");
		System.out.println("帐号:" + DESUtils.getDecryptString(encryptString));
		System.out.println("密码:" + DESUtils.getDecryptString(encryptString2));
	}

}
