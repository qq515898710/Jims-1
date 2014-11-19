package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.Stock;
import org.mo.jims.coop.repository.StockRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("stockService")
public class StockService {

	private StockRepository stockRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<Stock> getStockByCriteria(String goodName, String customerName,
			Date beginTime, Date endTime, int page, int pageSize) {
		Page<Stock> StockPage = new Page<Stock>();
		StockPage.setTotalElement(stockRepository.countAllByCriteria(goodName,
				customerName, null, beginTime, endTime), pageSize);
		StockPage.setPageSize(pageSize);
		StockPage.setCurrentPage(page);
		if (StockPage.getTotalElement() == 0) {
			return StockPage;
		}
		List<Stock> selectAllByNameOrAbbreviation = stockRepository
				.selectAllByCriteria(goodName, customerName, null, beginTime,
						endTime, (page - 1) * pageSize, pageSize);
		StockPage.setContent(selectAllByNameOrAbbreviation);
		return StockPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Stock getStockByPK(String id) {
		return stockRepository.selectByPK(id);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean saveStock(Stock entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(stockRepository.getCurrentTime());
			}
			stockRepository.insert(entity);
			return true;
		}
		return false;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean alterStock(Stock entity) {
		stockRepository.updateByPK(entity);
		return true;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean removeStockByPK(String id) {
		stockRepository.deleteByPK(id);
		return true;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getStockInToday() {
		return stockRepository.selectToday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getStockInYesterday() {
		return stockRepository.selectYesterday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getStockInThisWeek() {
		return stockRepository.selectThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getStockInLastWeek() {
		return stockRepository.selectLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getStockInThisMonth() {
		return stockRepository.selectThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getStockInLastMonth() {
		return stockRepository.selectLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getStockInThisYear() {
		return stockRepository.selectThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getStockInLastYear() {
		return stockRepository.selectLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Stock> getAllStock(){
		return stockRepository.selectAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockInToday(){
		return stockRepository.countToday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockInYesterday(){
		return stockRepository.countYesterday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockInThisWeek() {
		return stockRepository.countThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockInLastWeek() {
		return stockRepository.countLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockInThisMonth() {
		return stockRepository.countThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockInLastMonth() {
		return stockRepository.countLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockInThisYear() {
		return stockRepository.countThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockInLastYear() {
		return stockRepository.countLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countAllStock(){
		return stockRepository.countAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getStockPercentageofDayOnThisMonth(){
		int countToday = stockRepository.countToday();
		int countYesterday = stockRepository.countYesterday();
		int countThisMonth = stockRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getStockPercentageofWeekOnThisMonth(){
		int countToday = stockRepository.countThisWeek();
		int countYesterday = stockRepository.countLastWeek();
		int countThisMonth = stockRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getStockPercentageofMonthOnThisYear(){
		int countToday = stockRepository.countThisMonth();
		int countYesterday = stockRepository.countLastMonth();
		int countThisMonth = stockRepository.countThisYear();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getStockPercentageofYearOnAll(){
		int countToday = stockRepository.countThisYear();
		int countYesterday = stockRepository.countLastYear();
		int countThisMonth = stockRepository.countAll();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}

	public StockRepository getStockRepository() {
		return stockRepository;
	}

	@Resource(name = "stockRepository")
	public void setStockRepository(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

}
