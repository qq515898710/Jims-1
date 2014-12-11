package org.mo.jims.coop.service;


import org.junit.Test;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.StockReturn;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.open.common.entity.User;
import org.mo.open.common.service.UserService;
import org.mo.open.common.util.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

public class StockReturnServiceTest extends BaseTest{

	@Autowired
	private StockReturnService stockReturnService;
	
	@Autowired
	private ProviderInfoService providerInfoService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GoodInfoService goodInfoService;
	
	@Test
	public void testGetStockReturnByCriteria() {
		
	}

	@Test
	public void testGetStockReturnByPK() {
		StockReturn stockReturnByPK = stockReturnService.getStockReturnByPK("stockr14177600454120001");
		System.out.println(stockReturnByPK.toString());
	}

	@Test
	public void testSaveStockReturn() {
		ProviderInfo providerInfo=providerInfoService.getProviderInfoByPK("p1");
		User user=userService.getUserByPK("moziqi");
		GoodInfo goodInfo=goodInfoService.getGoodInfoByPK("g1");
		StockReturn entity = new StockReturn(10.2f, 10, 11.2f, "123", "123", "123", 
				Approval.NOPASS, providerInfo, user, goodInfo);
		stockReturnService.saveStockReturn(entity);
	}

	@Test
	public void testAlterStockReturn() {
		
	}

	@Test
	public void testRemoveStockReturnByPK() {
		
	}

	@Test
	public void testGetStockReturnInToday() {
		
	}

	@Test
	public void testGetStockReturnInYesterday() {
		
	}

	@Test
	public void testGetStockReturnInThisWeek() {
		
	}

	@Test
	public void testGetStockReturnInLastWeek() {
		
	}

	@Test
	public void testGetStockReturnInThisMonth() {
		
	}

	@Test
	public void testGetStockReturnInLastMonth() {
		
	}

	@Test
	public void testGetStockReturnInThisYear() {
		
	}

	@Test
	public void testGetStockReturnInLastYear() {
		
	}

	@Test
	public void testGetAllStockReturn() {
		
	}

	@Test
	public void testCountStockReturnInToday() {
		
	}

	@Test
	public void testCountStockReturnInYesterday() {
		
	}

	@Test
	public void testCountStockReturnInThisWeek() {
		
	}

	@Test
	public void testCountStockReturnInLastWeek() {
		
	}

	@Test
	public void testCountStockReturnInThisMonth() {
		
	}

	@Test
	public void testCountStockReturnInLastMonth() {
		
	}

	@Test
	public void testCountStockReturnInThisYear() {
		
	}

	@Test
	public void testCountStockReturnInLastYear() {
		
	}

	@Test
	public void testCountAllStockReturn() {
		
	}

	@Test
	public void testGetStockReturnPercentageofDayOnThisMonth() {
		
	}

	@Test
	public void testGetStockReturnPercentageofWeekOnThisMonth() {
		
	}

	@Test
	public void testGetStockReturnPercentageofMonthOnThisYear() {
		
	}

	@Test
	public void testGetStockReturnPercentageofYearOnAll() {
		
	}

	@Test
	public void testGetStockReturnRepository() {
		
	}

	@Test
	public void testSetStockReturnRepository() {
		
	}

}
