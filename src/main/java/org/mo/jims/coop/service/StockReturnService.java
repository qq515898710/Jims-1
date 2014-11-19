package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.StockReturn;
import org.mo.jims.coop.repository.StockReturnRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("stockReturnService")
public class StockReturnService {

	private StockReturnRepository stockReturnRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<StockReturn> getStockReturnByCriteria(String goodName,
			String customerName, Date beginTime, Date endTime, int page,
			int pageSize) {
		Page<StockReturn> StockReturnPage = new Page<StockReturn>();
		StockReturnPage.setTotalElement(stockReturnRepository.countAllByCriteria(
				goodName, customerName, null, beginTime, endTime), pageSize);
		StockReturnPage.setPageSize(pageSize);
		StockReturnPage.setCurrentPage(page);
		if (StockReturnPage.getTotalElement() == 0) {
			return StockReturnPage;
		}
		List<StockReturn> selectAllByNameOrAbbreviation = stockReturnRepository
				.selectAllByCriteria(goodName, customerName, null, beginTime,
						endTime, (page - 1) * pageSize, pageSize);
		StockReturnPage.setContent(selectAllByNameOrAbbreviation);
		return StockReturnPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public StockReturn getStockReturnByPK(String id) {
		return stockReturnRepository.selectByPK(id);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean saveStockReturn(StockReturn entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(stockReturnRepository.getCurrentTime());
			}
			stockReturnRepository.insert(entity);
			return true;
		}
		return false;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean alterStockReturn(StockReturn entity) {
		stockReturnRepository.updateByPK(entity);
		return true;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean removeStockReturnByPK(String id) {
		stockReturnRepository.deleteByPK(id);
		return true;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getStockReturnInToday() {
		return stockReturnRepository.selectToday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getStockReturnInYesterday() {
		return stockReturnRepository.selectYesterday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getStockReturnInThisWeek() {
		return stockReturnRepository.selectThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getStockReturnInLastWeek() {
		return stockReturnRepository.selectLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getStockReturnInThisMonth() {
		return stockReturnRepository.selectThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getStockReturnInLastMonth() {
		return stockReturnRepository.selectLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getStockReturnInThisYear() {
		return stockReturnRepository.selectThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getStockReturnInLastYear() {
		return stockReturnRepository.selectLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<StockReturn> getAllStockReturn(){
		return stockReturnRepository.selectAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockReturnInToday(){
		return stockReturnRepository.countToday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockReturnInYesterday(){
		return stockReturnRepository.countYesterday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockReturnInThisWeek() {
		return stockReturnRepository.countThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockReturnInLastWeek() {
		return stockReturnRepository.countLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockReturnInThisMonth() {
		return stockReturnRepository.countThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockReturnInLastMonth() {
		return stockReturnRepository.countLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockReturnInThisYear() {
		return stockReturnRepository.countThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countStockReturnInLastYear() {
		return stockReturnRepository.countLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countAllStockReturn(){
		return stockReturnRepository.countAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getStockReturnPercentageofDayOnThisMonth(){
		int countToday = stockReturnRepository.countToday();
		int countYesterday = stockReturnRepository.countYesterday();
		int countThisMonth = stockReturnRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getStockReturnPercentageofWeekOnThisMonth(){
		int countToday = stockReturnRepository.countThisWeek();
		int countYesterday = stockReturnRepository.countLastWeek();
		int countThisMonth = stockReturnRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getStockReturnPercentageofMonthOnThisYear(){
		int countToday = stockReturnRepository.countThisMonth();
		int countYesterday = stockReturnRepository.countLastMonth();
		int countThisMonth = stockReturnRepository.countThisYear();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getStockReturnPercentageofYearOnAll(){
		int countToday = stockReturnRepository.countThisYear();
		int countYesterday = stockReturnRepository.countLastYear();
		int countThisMonth = stockReturnRepository.countAll();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}

	public StockReturnRepository getStockReturnRepository() {
		return stockReturnRepository;
	}

	@Resource(name = "stockReturnRepository")
	public void setStockReturnRepository(StockReturnRepository stockReturnRepository) {
		this.stockReturnRepository = stockReturnRepository;
	}

}
