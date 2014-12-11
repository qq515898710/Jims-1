package org.mo.jims.coop.enumtype;

import org.junit.Test;

public class ApprovalTest {

	@Test
	public void testGetIdent() {
		
	}

	@Test
	public void testGetContent() {
		
	}

	@Test
	public void testIdent() {
		System.out.println(Approval.NOPASS);
		Approval valueOf = Approval.valueOf("NOPASS");
		System.out.println(valueOf.getContent());
		Approval ident = Approval.ident("0");
		System.out.println(ident.getContent());
	}

}
