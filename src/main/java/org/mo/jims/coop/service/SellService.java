package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.Sell;
import org.mo.jims.coop.repository.SellRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sellService")
public class SellService {

	private SellRepository sellRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<Sell> getSellByCriteria(String goodName, String customerName,
			Date beginTime, Date endTime, int page, int pageSize) {
		Page<Sell> SellPage = new Page<Sell>();
		SellPage.setTotalElement(sellRepository.countAllByCriteria(goodName,
				customerName, beginTime, endTime), pageSize);
		SellPage.setPageSize(pageSize);
		SellPage.setCurrentPage(page);
		if (SellPage.getTotalElement() == 0) {
			return SellPage;
		}
		List<Sell> selectAllByNameOrAbbreviation = sellRepository
				.selectAllByCriteria(goodName, customerName, beginTime,
						endTime, (page - 1) * pageSize, pageSize);
		SellPage.setContent(selectAllByNameOrAbbreviation);
		return SellPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Sell getSellByPK(String id) {
		return sellRepository.selectByPK(id);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean saveSell(Sell entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(sellRepository.getCurrentTime());
			}
			sellRepository.insert(entity);
			return true;
		}
		return false;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean alterSell(Sell entity) {
		sellRepository.updateByPK(entity);
		return true;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean removeSellByPK(String id) {
		sellRepository.deleteByPK(id);
		return true;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getSellInToday() {
		return sellRepository.selectToday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getSellInYesterday() {
		return sellRepository.selectYesterday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getSellInThisWeek() {
		return sellRepository.selectThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getSellInLastWeek() {
		return sellRepository.selectLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getSellInThisMonth() {
		return sellRepository.selectThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getSellInLastMonth() {
		return sellRepository.selectLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getSellInThisYear() {
		return sellRepository.selectThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getSellInLastYear() {
		return sellRepository.selectLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<Sell> getAllSell(){
		return sellRepository.selectAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellInToday(){
		return sellRepository.countToday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellInYesterday(){
		return sellRepository.countYesterday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellInThisWeek() {
		return sellRepository.countThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellInLastWeek() {
		return sellRepository.countLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellInThisMonth() {
		return sellRepository.countThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellInLastMonth() {
		return sellRepository.countLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellInThisYear() {
		return sellRepository.countThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellInLastYear() {
		return sellRepository.countLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countAllSell(){
		return sellRepository.countAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getSellPercentageofDayOnThisMonth(){
		int countToday = sellRepository.countToday();
		int countYesterday = sellRepository.countYesterday();
		int countThisMonth = sellRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getSellPercentageofWeekOnThisMonth(){
		int countToday = sellRepository.countThisWeek();
		int countYesterday = sellRepository.countLastWeek();
		int countThisMonth = sellRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getSellPercentageofMonthOnThisYear(){
		int countToday = sellRepository.countThisMonth();
		int countYesterday = sellRepository.countLastMonth();
		int countThisMonth = sellRepository.countThisYear();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getSellPercentageofYearOnAll(){
		int countToday = sellRepository.countThisYear();
		int countYesterday = sellRepository.countLastYear();
		int countThisMonth = sellRepository.countAll();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}

	public SellRepository getSellRepository() {
		return sellRepository;
	}

	@Resource(name = "sellRepository")
	public void setSellRepository(SellRepository SellRepository) {
		this.sellRepository = SellRepository;
	}

}
