package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.Stock;
import org.mo.jims.coop.enumtype.Approval;
import org.mo.jims.coop.repository.StockRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("stockService")
public class StockService {

	private StockRepository stockRepository;

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

	public Stock getStockByPK(String id) {
		if (id != null && !"".equals(id)) {
			return stockRepository.selectByPK(id);
		}
		return null;
	}

	public boolean saveStock(Stock entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(stockRepository.getCurrentTime());
			}
			entity.setApproval(Approval.NOPASS);
			stockRepository.insert(entity);
			return true;
		}
		return false;
	}

	public boolean alterStock(Stock entity) {
		if (entity != null) {
			stockRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	public boolean removeStockByPK(String id) {
		if (id != null && !"".equals(id)) {
			stockRepository.deleteByPK(id);
			return true;
		}
		return false;
	}

	public List<Stock> getStockInToday() {
		return stockRepository.selectToday();
	}

	public List<Stock> getStockInYesterday() {
		return stockRepository.selectYesterday();
	}

	public List<Stock> getStockInThisWeek() {
		return stockRepository.selectThisWeek();
	}

	public List<Stock> getStockInLastWeek() {
		return stockRepository.selectLastWeek();
	}

	public List<Stock> getStockInThisMonth() {
		return stockRepository.selectThisMonth();
	}

	public List<Stock> getStockInLastMonth() {
		return stockRepository.selectLastMonth();
	}

	public List<Stock> getStockInThisYear() {
		return stockRepository.selectThisYear();
	}

	public List<Stock> getStockInLastYear() {
		return stockRepository.selectLastYear();
	}

	public List<Stock> getAllStock() {
		return stockRepository.selectAll();
	}

	public int countStockInToday() {
		return stockRepository.countToday();
	}

	public int countStockInYesterday() {
		return stockRepository.countYesterday();
	}

	public int countStockInThisWeek() {
		return stockRepository.countThisWeek();
	}

	public int countStockInLastWeek() {
		return stockRepository.countLastWeek();
	}

	public int countStockInThisMonth() {
		return stockRepository.countThisMonth();
	}

	public int countStockInLastMonth() {
		return stockRepository.countLastMonth();
	}

	public int countStockInThisYear() {
		return stockRepository.countThisYear();
	}

	public int countStockInLastYear() {
		return stockRepository.countLastYear();
	}

	public int countAllStock() {
		return stockRepository.countAll();
	}

	public Float getStockPercentageofDayOnThisMonth() {
		int countToday = stockRepository.countToday();
		int countYesterday = stockRepository.countYesterday();
		int countThisMonth = stockRepository.countThisMonth();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getStockPercentageofWeekOnThisMonth() {
		int countToday = stockRepository.countThisWeek();
		int countYesterday = stockRepository.countLastWeek();
		int countThisMonth = stockRepository.countThisMonth();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getStockPercentageofMonthOnThisYear() {
		int countToday = stockRepository.countThisMonth();
		int countYesterday = stockRepository.countLastMonth();
		int countThisMonth = stockRepository.countThisYear();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getStockPercentageofYearOnAll() {
		int countToday = stockRepository.countThisYear();
		int countYesterday = stockRepository.countLastYear();
		int countThisMonth = stockRepository.countAll();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
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
