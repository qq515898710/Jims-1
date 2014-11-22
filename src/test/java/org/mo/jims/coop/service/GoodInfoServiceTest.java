package org.mo.jims.coop.service;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.open.common.util.BaseTest;
import org.mo.open.common.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodInfoServiceTest extends BaseTest{

	@Autowired
	private GoodInfoService goodInfoService;
	
	@Test
	public void testGetGoodInfoByProvider() {
		
	}

	@Test
	public void testGetAllGoodName() {
		
	}

	@Test
	public void testBatchRemove() {
		
	}

	@Test
	public void testGetGoodInfoByName() {
		
	}

	@Test
	public void testGetGoodInfoByCriteria() {
		Page<GoodInfo> goodInfoByCriteria = goodInfoService.getGoodInfoByCriteria(null, null, null, 1, 10);
		List<GoodInfo> content = goodInfoByCriteria.getContent();
		Iterator<GoodInfo> iterator = content.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	@Test
	public void testGetGoodInfoByPK() {
		
	}

	@Test
	public void testSaveGoodInfo() {
		
	}

	@Test
	public void testAlterGoodInfo() {
		
	}

	@Test
	public void testRemoveGoodInfoByPK() {
		
	}

	@Test
	public void testGetGoodInfoInToday() {
		
	}

	@Test
	public void testGetGoodInfoInYesterday() {
		
	}

	@Test
	public void testGetGoodInfoInThisWeek() {
		
	}

	@Test
	public void testGetGoodInfoInLastWeek() {
		
	}

	@Test
	public void testGetGoodInfoInThisMonth() {
		
	}

	@Test
	public void testGetGoodInfoInLastMonth() {
		
	}

	@Test
	public void testGetGoodInfoInThisYear() {
		
	}

	@Test
	public void testGetGoodInfoInLastYear() {
		
	}

	@Test
	public void testGetAllGoodInfo() {
		
	}

	@Test
	public void testGetGoodInfoRepository() {
		
	}

	@Test
	public void testSetGoodInfoRepository() {
		
	}

	@Test
	public void testGetProviderInfoRepository() {
		
	}

	@Test
	public void testSetProviderInfoRepository() {
		
	}

}
