package org.mo.jims.coop.repository;


import java.util.Date;

import org.junit.Test;
import org.mo.open.common.converter.SpringDateConverter;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerInfoRepositoryTest extends BaseTest{

	@Autowired
	private CustomerInfoRepository customerInfoRepository;
	
	@Autowired
	private SpringDateConverter springDateConverter;
	
	@Test
	public void testSelectByName() {
		
	}

	@Test
	public void testCountAllByCriteria() {
		
		Date beginTime = springDateConverter.convert("2014-12-10 10:20:30");
		Date endTime = springDateConverter.convert("2014-12-13 10:20:30");
		System.out.println(endTime);
		int countAllByCriteria = customerInfoRepository.countAllByCriteria("阿迪王", beginTime, endTime);
		System.out.println(countAllByCriteria);
	}

	@Test
	public void testSelectAllByCriteria() {
		
	}

	@Test
	public void testSelectAllByPage() {
		
	}

	@Test
	public void testBatchDelete() {
		
	}

	@Test
	public void testSelectAllCustomerName() {
		
	}

}
