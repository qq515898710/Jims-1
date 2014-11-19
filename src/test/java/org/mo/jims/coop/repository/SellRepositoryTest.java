package org.mo.jims.coop.repository;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mo.jims.coop.entity.Sell;
import org.mo.open.common.repository.UserRepository;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class SellRepositoryTest extends BaseTest {

	@Autowired
	private SellRepository sellRepository;
	
	@Autowired
	private CustomerInfoRepository customerInfoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testCountAllByCriteria() {
		
	}

	@Test
	public void testSelectAllByCriteria() {
		
	}

	@Test
	public void testInsert() {
	}

	@Test
	public void testUpdateByPK() {
		
	}

	@Test
	public void testDeleteByPK() {
		
	}

	@Test
	public void testSelectByPK() {
		
	}

	@Test
	public void testGetCurrentTime() {
		
	}

	@Test
	public void testGetLatestInsert() {
		
	}

	@Test
	public void testGetLatestInsertId() {
		
	}

	@Test
	public void testSelectToday() {
		
	}

	@Test
	public void testSelectYesterday() {
		
	}

	@Test
	public void testSelectThisWeek() {
		
	}

	@Test
	public void testSelectLastWeek() {
		
	}

	@Test
	public void testSelectThisMonth() {
		
	}

	@Test
	public void testSelectLastMonth() {
		
	}

	@Test
	public void testSelectThisYear() {
		List<Sell> selectLastYear = sellRepository.selectThisYear();
		System.out.println(selectLastYear.size());
		Iterator<Sell> iterator = selectLastYear.iterator();
		while(iterator.hasNext()){
			Sell next = iterator.next();
			System.out.println(next.toString());
		}
	}

	@Test
	public void testSelectLastYear() {
		List<Sell> selectLastYear = sellRepository.selectLastYear();
		System.out.println(selectLastYear.size());
		Iterator<Sell> iterator = selectLastYear.iterator();
		while(iterator.hasNext()){
			Sell next = iterator.next();
			System.out.println(next.toString());
		}
	}

	@Test
	public void testSelectAll() {
		List<Sell> selectAll = sellRepository.selectAll();
		System.out.println(selectAll.size());
		Iterator<Sell> iterator = selectAll.iterator();
		while(iterator.hasNext()){
			Sell next = iterator.next();
			System.out.println(next.toString());
		}
	}

	@Test
	public void testCountToday() {
		
	}

	@Test
	public void testCountYesterday() {
		
	}

	@Test
	public void testCountThisWeek() {
		
	}

	@Test
	public void testCountLastWeek() {
		
	}

	@Test
	public void testCountThisMonth() {
		
	}

	@Test
	public void testCountLastMonth() {
		
	}

	@Test
	public void testCountThisYear() {
		
	}

	@Test
	public void testCountLastYear() {
		
	}

	@Test
	public void testCountAll() {
		int countAll = sellRepository.countAll();
		System.out.println(countAll);
	}

}
