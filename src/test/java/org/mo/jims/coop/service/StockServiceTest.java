package org.mo.jims.coop.service;


import org.junit.Test;
import org.mo.jims.coop.entity.Stock;
import org.mo.open.common.util.BaseTest;
import org.mo.open.common.util.Page;
import org.springframework.beans.factory.annotation.Autowired;

public class StockServiceTest extends BaseTest{

	@Autowired
	private StockService stockService;
	
	@Test
	public void testGetStockByCriteria() {
		Page<Stock> stockByCriteria = stockService.getStockByCriteria(null, null, null,
				null, null, 1, 10);
		long totalElement = stockByCriteria.getTotalElement();
		System.out.println(totalElement);
	}

	@Test
	public void testGetStockByPK() {

	}

	@Test
	public void testSaveStock() {
		
	}

	@Test
	public void testAlterStock() {
		
	}

	@Test
	public void testRemoveStockByPK() {
		
	}

	@Test
	public void testGetStockInToday() {
		
	}

	@Test
	public void testGetStockInYesterday() {
		
	}

	@Test
	public void testGetStockInThisWeek() {
		
	}

	@Test
	public void testGetStockInLastWeek() {
		
	}

	@Test
	public void testGetStockInThisMonth() {
		
	}

	@Test
	public void testGetStockInLastMonth() {
		
	}

	@Test
	public void testGetStockInThisYear() {
		
	}

	@Test
	public void testGetStockInLastYear() {
		
	}

	@Test
	public void testGetAllStock() {
		
	}

	@Test
	public void testCountStockInToday() {
		
	}

	@Test
	public void testCountStockInYesterday() {
		
	}

	@Test
	public void testCountStockInThisWeek() {
		
	}

	@Test
	public void testCountStockInLastWeek() {
		
	}

	@Test
	public void testCountStockInThisMonth() {
		
	}

	@Test
	public void testCountStockInLastMonth() {
		
	}

	@Test
	public void testCountStockInThisYear() {
		
	}

	@Test
	public void testCountStockInLastYear() {
		
	}

	@Test
	public void testCountAllStock() {
		
	}

	@Test
	public void testGetStockPercentageofDayOnThisMonth() {
		
	}

	@Test
	public void testGetStockPercentageofWeekOnThisMonth() {
		
	}

	@Test
	public void testGetStockPercentageofMonthOnThisYear() {
		
	}

	@Test
	public void testGetStockPercentageofYearOnAll() {
		
	}

	@Test
	public void testGetStockRepository() {
		
	}

	@Test
	public void testSetStockRepository() {
		
	}

}
