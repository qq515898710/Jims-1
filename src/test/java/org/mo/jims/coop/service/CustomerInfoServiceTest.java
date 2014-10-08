package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.open.common.util.BaseTest;
import org.mo.open.common.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerInfoServiceTest extends BaseTest {
	
	@Autowired
	private CustomerInfoService customerInfoService;

	@Test
	public void testGetCustomerInfoByName() {
		CustomerInfo customerInfoByName = customerInfoService.getCustomerInfoByName("东莞理工学院城市学院");
		Assert.assertNotNull("customerInfoByName is null", customerInfoByName);
	}

	@Test
	public void testGetCustomerInfoByNameOrAbbreviation() {
		Page<CustomerInfo> customerInfoByNameOrAbbreviation = customerInfoService.getCustomerInfoByNameOrAbbreviation("城", 1, 10);
		Assert.assertNotNull("customerInfoByNameOrAbbreviation is null", customerInfoByNameOrAbbreviation);
		List<CustomerInfo> content = customerInfoByNameOrAbbreviation.getContent();
		Assert.assertNotNull("content is null", customerInfoByNameOrAbbreviation);
		for(int i=0;i<content.size();i++){
			CustomerInfo tbCustomerInfo = content.get(i);
			System.out.println(tbCustomerInfo.getName());
		}
	}

	@Test
	public void testGetByPK() {
		CustomerInfo tbCustomerInfo = customerInfoService.getByPK("cFri Oct 03 18:07:32 CST 2014");
		Assert.assertNotNull("tbCustomerInfo is null",tbCustomerInfo);
	}

	@Test
	public void testSave() {
		String cname="东莞理工学院城市学院";
		String abbreviation="城院";
		String address="广东东莞";
		String postalCode="523525";
		String phone="13580889535";
		String fax=null;
		String contacts="莫梓奇";
		String telephone="81234567";
		String email="mo@163.com";
		String depositBank="东莞银行";
		String accountBank="5345 3453 3453 6565";
		CustomerInfo tbCustomerInfo = new CustomerInfo( cname, abbreviation, address, postalCode, phone, fax, contacts, telephone, email, depositBank, accountBank);
		customerInfoService.save(tbCustomerInfo);
	}

	@Test
	public void testAlter() {

	}

	@Test
	public void testRemoveByPK() {

	}

}
