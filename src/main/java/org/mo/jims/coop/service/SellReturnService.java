package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.SellReturn;
import org.mo.jims.coop.repository.SellReturnRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sellReturnService")
public class SellReturnService {

	private SellReturnRepository sellReturnRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<SellReturn> getSellReturnByCriteria(String goodName, String customerName,
			Date beginTime, Date endTime, int page, int pageSize) {
		Page<SellReturn> SellReturnPage = new Page<SellReturn>();
		SellReturnPage.setTotalElement(sellReturnRepository.countAllByCriteria(goodName,
				customerName, beginTime, endTime), pageSize);
		SellReturnPage.setPageSize(pageSize);
		SellReturnPage.setCurrentPage(page);
		if (SellReturnPage.getTotalElement() == 0) {
			return SellReturnPage;
		}
		List<SellReturn> selectAllByNameOrAbbreviation = sellReturnRepository
				.selectAllByCriteria(goodName, customerName, beginTime,
						endTime, (page - 1) * pageSize, pageSize);
		SellReturnPage.setContent(selectAllByNameOrAbbreviation);
		return SellReturnPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public SellReturn getSellReturnByPK(String id) {
		return sellReturnRepository.selectByPK(id);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean saveSellReturn(SellReturn entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(sellReturnRepository.getCurrentTime());
			}
			sellReturnRepository.insert(entity);
			return true;
		}
		return false;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean alterSellReturn(SellReturn entity) {
		sellReturnRepository.updateByPK(entity);
		return true;
	}

	@Transactional(rollbackFor = RuntimeException.class)
	public boolean removeSellReturnByPK(String id) {
		sellReturnRepository.deleteByPK(id);
		return true;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getSellReturnInToday() {
		return sellReturnRepository.selectToday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getSellReturnInYesterday() {
		return sellReturnRepository.selectYesterday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getSellReturnInThisWeek() {
		return sellReturnRepository.selectThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getSellReturnInLastWeek() {
		return sellReturnRepository.selectLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getSellReturnInThisMonth() {
		return sellReturnRepository.selectThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getSellReturnInLastMonth() {
		return sellReturnRepository.selectLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getSellReturnInThisYear() {
		return sellReturnRepository.selectThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getSellReturnInLastYear() {
		return sellReturnRepository.selectLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<SellReturn> getAllSellReturn(){
		return sellReturnRepository.selectAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellReturnInToday(){
		return sellReturnRepository.countToday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellReturnInYesterday(){
		return sellReturnRepository.countYesterday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellReturnInThisWeek() {
		return sellReturnRepository.countThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellReturnInLastWeek() {
		return sellReturnRepository.countLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellReturnInThisMonth() {
		return sellReturnRepository.countThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellReturnInLastMonth() {
		return sellReturnRepository.countLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellReturnInThisYear() {
		return sellReturnRepository.countThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countSellReturnInLastYear() {
		return sellReturnRepository.countLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countAllSellReturn(){
		return sellReturnRepository.countAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getSellReturnPercentageofDayOnThisMonth(){
		int countToday = sellReturnRepository.countToday();
		int countYesterday = sellReturnRepository.countYesterday();
		int countThisMonth = sellReturnRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getSellReturnPercentageofWeekOnThisMonth(){
		int countToday = sellReturnRepository.countThisWeek();
		int countYesterday = sellReturnRepository.countLastWeek();
		int countThisMonth = sellReturnRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getSellReturnPercentageofMonthOnThisYear(){
		int countToday = sellReturnRepository.countThisMonth();
		int countYesterday = sellReturnRepository.countLastMonth();
		int countThisMonth = sellReturnRepository.countThisYear();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getSellReturnPercentageofYearOnAll(){
		int countToday = sellReturnRepository.countThisYear();
		int countYesterday = sellReturnRepository.countLastYear();
		int countThisMonth = sellReturnRepository.countAll();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}

	public SellReturnRepository getSellReturnRepository() {
		return sellReturnRepository;
	}

	@Resource(name = "sellReturnRepository")
	public void setSellReturnRepository(SellReturnRepository sellReturnRepository) {
		this.sellReturnRepository = sellReturnRepository;
	}

}
