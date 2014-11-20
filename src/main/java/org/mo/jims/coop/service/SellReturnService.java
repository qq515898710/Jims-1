package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.SellReturn;
import org.mo.jims.coop.repository.SellReturnRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("sellReturnService")
public class SellReturnService {

	private SellReturnRepository sellReturnRepository;

	public Page<SellReturn> getSellReturnByCriteria(String goodName,
			String customerName, Date beginTime, Date endTime, int page,
			int pageSize) {
		Page<SellReturn> SellReturnPage = new Page<SellReturn>();
		SellReturnPage.setTotalElement(sellReturnRepository.countAllByCriteria(
				goodName, customerName, beginTime, endTime), pageSize);
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

	public SellReturn getSellReturnByPK(String id) {
		if(id!=null && !"".equals(id)){
			return sellReturnRepository.selectByPK(id);
		}
		return null;
	}

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

	public boolean alterSellReturn(SellReturn entity) {
		if(entity!=null){
			sellReturnRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	public boolean removeSellReturnByPK(String id) {
		if(id!=null && !"".equals(id)){
			sellReturnRepository.deleteByPK(id);
			return true;
		}
		return false;
	}

	public List<SellReturn> getSellReturnInToday() {
		return sellReturnRepository.selectToday();
	}

	public List<SellReturn> getSellReturnInYesterday() {
		return sellReturnRepository.selectYesterday();
	}

	public List<SellReturn> getSellReturnInThisWeek() {
		return sellReturnRepository.selectThisWeek();
	}

	public List<SellReturn> getSellReturnInLastWeek() {
		return sellReturnRepository.selectLastWeek();
	}

	public List<SellReturn> getSellReturnInThisMonth() {
		return sellReturnRepository.selectThisMonth();
	}

	public List<SellReturn> getSellReturnInLastMonth() {
		return sellReturnRepository.selectLastMonth();
	}

	public List<SellReturn> getSellReturnInThisYear() {
		return sellReturnRepository.selectThisYear();
	}

	public List<SellReturn> getSellReturnInLastYear() {
		return sellReturnRepository.selectLastYear();
	}

	public List<SellReturn> getAllSellReturn() {
		return sellReturnRepository.selectAll();
	}

	public int countSellReturnInToday() {
		return sellReturnRepository.countToday();
	}

	public int countSellReturnInYesterday() {
		return sellReturnRepository.countYesterday();
	}

	public int countSellReturnInThisWeek() {
		return sellReturnRepository.countThisWeek();
	}

	public int countSellReturnInLastWeek() {
		return sellReturnRepository.countLastWeek();
	}

	public int countSellReturnInThisMonth() {
		return sellReturnRepository.countThisMonth();
	}

	public int countSellReturnInLastMonth() {
		return sellReturnRepository.countLastMonth();
	}

	public int countSellReturnInThisYear() {
		return sellReturnRepository.countThisYear();
	}

	public int countSellReturnInLastYear() {
		return sellReturnRepository.countLastYear();
	}

	public int countAllSellReturn() {
		return sellReturnRepository.countAll();
	}

	public Float getSellReturnPercentageofDayOnThisMonth() {
		int countToday = sellReturnRepository.countToday();
		int countYesterday = sellReturnRepository.countYesterday();
		int countThisMonth = sellReturnRepository.countThisMonth();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getSellReturnPercentageofWeekOnThisMonth() {
		int countToday = sellReturnRepository.countThisWeek();
		int countYesterday = sellReturnRepository.countLastWeek();
		int countThisMonth = sellReturnRepository.countThisMonth();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getSellReturnPercentageofMonthOnThisYear() {
		int countToday = sellReturnRepository.countThisMonth();
		int countYesterday = sellReturnRepository.countLastMonth();
		int countThisMonth = sellReturnRepository.countThisYear();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getSellReturnPercentageofYearOnAll() {
		int countToday = sellReturnRepository.countThisYear();
		int countYesterday = sellReturnRepository.countLastYear();
		int countThisMonth = sellReturnRepository.countAll();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public SellReturnRepository getSellReturnRepository() {
		return sellReturnRepository;
	}

	@Resource(name = "sellReturnRepository")
	public void setSellReturnRepository(
			SellReturnRepository sellReturnRepository) {
		this.sellReturnRepository = sellReturnRepository;
	}

}
