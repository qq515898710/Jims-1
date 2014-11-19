package org.mo.jims.coop.repository;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mo.jims.coop.entity.InventoryInfo;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryInfoRepositoryTest extends  BaseTest{

	@Autowired
	private InventoryInfoRepository inventoryInfoRepository;
	
	@Test
	public void testCountAllByCriteria() {
		
	}

	@Test
	public void testSelectAllByCriteria() {
		
	}

	@Test
	public void testBatchDelete() {
		
	}

	@Test
	public void testSelectByUser() {
		
	}

	@Test
	public void testSelectByGoodName() {
		List<InventoryInfo> selectByGoodName = inventoryInfoRepository.selectByGoodName("杜蕾斯");
		Iterator<InventoryInfo> iterator = selectByGoodName.iterator();
		while(iterator.hasNext()){
			InventoryInfo next = iterator.next();
			System.out.println(next.toString());
		}
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
		
	}

	@Test
	public void testSelectLastYear() {
		
	}

	@Test
	public void testSelectAll() {
		List<InventoryInfo> selectAll = inventoryInfoRepository.selectAll();
		Iterator<InventoryInfo> iterator = selectAll.iterator();
		while(iterator.hasNext()){
			InventoryInfo next = iterator.next();
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
		
	}

}
