package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.StockReturn;
import org.mo.jims.coop.repository.StockReturnRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("stockReturnService")
public class StockReturnService {

	private StockReturnRepository stockReturnRepository;

	public Page<StockReturn> getStockReturnByCriteria(String goodName,
			String customerName, Date beginTime, Date endTime, int page,
			int pageSize) {
		Page<StockReturn> StockReturnPage = new Page<StockReturn>();
		StockReturnPage.setTotalElement(stockReturnRepository
				.countAllByCriteria(goodName, customerName, null, beginTime,
						endTime), pageSize);
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

	public StockReturn getStockReturnByPK(String id) {
		if (id != null && !"".equals(id)) {
			return stockReturnRepository.selectByPK(id);
		}
		return null;
	}

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

	public boolean alterStockReturn(StockReturn entity) {
		if (entity != null) {
			stockReturnRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	public boolean removeStockReturnByPK(String id) {
		if (id != null && !"".equals(id)) {
			stockReturnRepository.deleteByPK(id);
			return true;
		}
		return false;
	}

	public List<StockReturn> getStockReturnInToday() {
		return stockReturnRepository.selectToday();
	}

	public List<StockReturn> getStockReturnInYesterday() {
		return stockReturnRepository.selectYesterday();
	}

	public List<StockReturn> getStockReturnInThisWeek() {
		return stockReturnRepository.selectThisWeek();
	}

	public List<StockReturn> getStockReturnInLastWeek() {
		return stockReturnRepository.selectLastWeek();
	}

	public List<StockReturn> getStockReturnInThisMonth() {
		return stockReturnRepository.selectThisMonth();
	}

	public List<StockReturn> getStockReturnInLastMonth() {
		return stockReturnRepository.selectLastMonth();
	}

	public List<StockReturn> getStockReturnInThisYear() {
		return stockReturnRepository.selectThisYear();
	}

	public List<StockReturn> getStockReturnInLastYear() {
		return stockReturnRepository.selectLastYear();
	}

	public List<StockReturn> getAllStockReturn() {
		return stockReturnRepository.selectAll();
	}

	public int countStockReturnInToday() {
		return stockReturnRepository.countToday();
	}

	public int countStockReturnInYesterday() {
		return stockReturnRepository.countYesterday();
	}

	public int countStockReturnInThisWeek() {
		return stockReturnRepository.countThisWeek();
	}

	public int countStockReturnInLastWeek() {
		return stockReturnRepository.countLastWeek();
	}

	public int countStockReturnInThisMonth() {
		return stockReturnRepository.countThisMonth();
	}

	public int countStockReturnInLastMonth() {
		return stockReturnRepository.countLastMonth();
	}

	public int countStockReturnInThisYear() {
		return stockReturnRepository.countThisYear();
	}

	public int countStockReturnInLastYear() {
		return stockReturnRepository.countLastYear();
	}

	public int countAllStockReturn() {
		return stockReturnRepository.countAll();
	}

	public Float getStockReturnPercentageofDayOnThisMonth() {
		int countToday = stockReturnRepository.countToday();
		int countYesterday = stockReturnRepository.countYesterday();
		int countThisMonth = stockReturnRepository.countThisMonth();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getStockReturnPercentageofWeekOnThisMonth() {
		int countToday = stockReturnRepository.countThisWeek();
		int countYesterday = stockReturnRepository.countLastWeek();
		int countThisMonth = stockReturnRepository.countThisMonth();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getStockReturnPercentageofMonthOnThisYear() {
		int countToday = stockReturnRepository.countThisMonth();
		int countYesterday = stockReturnRepository.countLastMonth();
		int countThisMonth = stockReturnRepository.countThisYear();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getStockReturnPercentageofYearOnAll() {
		int countToday = stockReturnRepository.countThisYear();
		int countYesterday = stockReturnRepository.countLastYear();
		int countThisMonth = stockReturnRepository.countAll();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public StockReturnRepository getStockReturnRepository() {
		return stockReturnRepository;
	}

	@Resource(name = "stockReturnRepository")
	public void setStockReturnRepository(
			StockReturnRepository stockReturnRepository) {
		this.stockReturnRepository = stockReturnRepository;
	}

}
