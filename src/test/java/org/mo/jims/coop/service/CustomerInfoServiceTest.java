package org.mo.jims.coop.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
	public void testGetAllCustomerName(){
		List<String> allCustomerName = customerInfoService.getAllCustomerName();
		Iterator<String> iterator = allCustomerName.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	@Test
	public void testGetCustomerInfoByName() {
		CustomerInfo customerInfoByName = customerInfoService.getCustomerInfoByName("东莞理工学院城市学院");
		Assert.assertNotNull("customerInfoByName is null", customerInfoByName);
	}

	@Test
	public void testGetCustomerInfoByNameOrAbbreviation() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2014-12-10");
		Date date2 = dateFormat.parse("2014-12-13");
		Page<CustomerInfo> customerInfoByNameOrAbbreviation = customerInfoService
				.getCustomerInfoByCriteria("阿迪王", date, date2, 1, 50);
		Assert.assertNotNull("customerInfoByNameOrAbbreviation is null",
				customerInfoByNameOrAbbreviation);
		System.out.println("customerInfoByNameOrAbbreviation.getTotalElement():"+customerInfoByNameOrAbbreviation.getTotalElement());
		if(customerInfoByNameOrAbbreviation.getTotalElement() > 0){
			List<CustomerInfo> content = customerInfoByNameOrAbbreviation
					.getContent();
			Assert.assertNotNull("content is null",
					customerInfoByNameOrAbbreviation);
			for (int i = 0; i < content.size(); i++) {
				CustomerInfo tbCustomerInfo = content.get(i);
				System.out.println(tbCustomerInfo.getName() +"--"+i);
			}
		}else{
			System.out.println(customerInfoByNameOrAbbreviation.getTotalElement());
		}
	}

	@Test
	public void testGetByPK() {
		CustomerInfo tbCustomerInfo = customerInfoService.getCustomerInfoByPK("cFri Oct 03 18:07:32 CST 2014");
		Assert.assertNotNull("tbCustomerInfo is null",tbCustomerInfo);
	}

	@Test
	public void testSave() {
		CustomerInfo tbCustomerInfo  = null;
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
		for(int i=1;i<10;i++){
			tbCustomerInfo = new CustomerInfo(cname+i, abbreviation+"9", address, postalCode, phone, fax, contacts, telephone, email, depositBank, accountBank);
			customerInfoService.saveCustomerInfo(tbCustomerInfo);
		}
	}

	@Test
	public void testAlter() {

	}

	@Test
	public void testRemoveByPK() {

	}

}
