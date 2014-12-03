package org.mo.jims.coop.service;


import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mo.jims.coop.entity.InventoryInfo;
import org.mo.open.common.util.BaseTest;
import org.mo.open.common.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryInfoServiceTest extends BaseTest {

	@Autowired
	private InventoryInfoService inventoryInfoService;
	
	@Test
	public void testGetByInventoryInfoGoodName() {
		
	}

	@Test
	public void testBatchRemove() {
		
	}

	@Test
	public void testGetInventoryInfoByCriteria() {
		Page<InventoryInfo> inventoryInfoByCriteria = inventoryInfoService.getInventoryInfoByCriteria("", null, null, 1, 10);
		System.out.println(inventoryInfoByCriteria.getTotalElement());
		List<InventoryInfo> content = inventoryInfoByCriteria.getContent();
		for(InventoryInfo info : content){
			System.out.println(info.toString());
		}
		for(Iterator<InventoryInfo> iterator = content.iterator();iterator.hasNext();){
			System.out.println(iterator.next().toString());
		}
	}

	@Test
	public void testGetInventoryInfoByPK() {
		
	}

	@Test
	public void testSaveInventoryInfo() {
		
	}

	@Test
	public void testAlterInventoryInfo() {
		
	}

	@Test
	public void testRemoveInventoryInfoByPK() {
		
	}

	@Test
	public void testGetInventoryInfoInToday() {
		
	}

	@Test
	public void testGetInventoryInfoInYesterday() {
		
	}

	@Test
	public void testGetInventoryInfoInThisWeek() {
		
	}

	@Test
	public void testGetInventoryInfoInLastWeek() {
		
	}

	@Test
	public void testGetInventoryInfoInThisMonth() {
		
	}

	@Test
	public void testGetInventoryInfoInLastMonth() {
		
	}

	@Test
	public void testGetInventoryInfoInThisYear() {
		
	}

	@Test
	public void testGetInventoryInfoInLastYear() {
		
	}

	@Test
	public void testGetAllInventoryInfo() {
		
	}

	@Test
	public void testCountInventoryInfoInToday() {
		
	}

	@Test
	public void testCountInventoryInfoInYesterday() {
		
	}

	@Test
	public void testCountInventoryInfoInThisWeek() {
		
	}

	@Test
	public void testCountInventoryInfoInLastWeek() {
		
	}

	@Test
	public void testCountInventoryInfoInThisMonth() {
		
	}

	@Test
	public void testCountInventoryInfoInLastMonth() {
		
	}

	@Test
	public void testCountInventoryInfoInThisYear() {
		
	}

	@Test
	public void testCountInventoryInfoInLastYear() {
		
	}

	@Test
	public void testCountAllInventoryInfo() {
		
	}

	@Test
	public void testGetInventoryInfoPercentageofDayOnThisMonth() {
		
	}

	@Test
	public void testGetInventoryInfoPercentageofWeekOnThisMonth() {
		
	}

	@Test
	public void testGetInventoryInfoPercentageofMonthOnThisYear() {
		
	}

	@Test
	public void testGetInventoryInfoPercentageofYearOnAll() {
		
	}

	@Test
	public void testGetInventoryInfoRepository() {
		
	}

	@Test
	public void testSetInventoryInfoRepository() {
		
	}

}
