package org.mo.open.common.util;

import org.junit.Test;

public class RegexValidateUtilTest {

	@Test
	public void testCheckQQ() {
		boolean checkQQ = RegexValidateUtil.checkQQ("709847739");
		System.out.println(checkQQ);
	}

	@Test
	public void testCheckCellphone() {
		boolean checkCellphone = RegexValidateUtil.checkCellphone("13580889535");
		System.out.println(checkCellphone);
	}

	@Test
	public void testCheckTelephone() {
		boolean checkTelephone = RegexValidateUtil.checkTelephone("0769-83456386");
		System.out.println(checkTelephone);
	}

	@Test
	public void testCheckFax() {
		boolean checkFax = RegexValidateUtil.checkFax("076-83456386");
		System.out.println(checkFax);
	}

	@Test
	public void testCheckEmail() {
		boolean checkEmail = RegexValidateUtil.checkEmail("709847739@qq.com");
		System.out.println(checkEmail);
	}

	@Test
	public void testCheckNotEmputy() {
		boolean checkNotEmputy = RegexValidateUtil.checkNotEmputy("");
		System.out.println(checkNotEmputy);
	}

}
