package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.Sell;
import org.mo.jims.coop.repository.SellRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("sellService")
public class SellService {

	private SellRepository sellRepository;
	
	
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

	
	public Sell getSellByPK(String id) {
		if(id!=null && !"".equals(id)){
			return sellRepository.selectByPK(id);
		}
		return null;
	}

	
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

	
	public boolean alterSell(Sell entity) {
		if(entity!=null){
			sellRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	
	public boolean removeSellByPK(String id) {
		if(id!=null && !"".equals(id)){
			sellRepository.deleteByPK(id);
			return true;
		}
		return false;
	}
	
	
	public List<Sell> getSellInToday() {
		return sellRepository.selectToday();
	}

	
	public List<Sell> getSellInYesterday() {
		return sellRepository.selectYesterday();
	}

	
	public List<Sell> getSellInThisWeek() {
		return sellRepository.selectThisWeek();
	}

	
	public List<Sell> getSellInLastWeek() {
		return sellRepository.selectLastWeek();
	}
	
	
	public List<Sell> getSellInThisMonth() {
		return sellRepository.selectThisMonth();
	}

	
	public List<Sell> getSellInLastMonth() {
		return sellRepository.selectLastMonth();
	}
	
	
	public List<Sell> getSellInThisYear() {
		return sellRepository.selectThisYear();
	}
	
	
	public List<Sell> getSellInLastYear() {
		return sellRepository.selectLastYear();
	}
	
	
	public List<Sell> getAllSell(){
		return sellRepository.selectAll();
	}
	
	
	public int countSellInToday(){
		return sellRepository.countToday();
	}
	
	
	public int countSellInYesterday(){
		return sellRepository.countYesterday();
	}
	
	
	public int countSellInThisWeek() {
		return sellRepository.countThisWeek();
	}

	
	public int countSellInLastWeek() {
		return sellRepository.countLastWeek();
	}
	
	
	public int countSellInThisMonth() {
		return sellRepository.countThisMonth();
	}

	
	public int countSellInLastMonth() {
		return sellRepository.countLastMonth();
	}
	
	
	public int countSellInThisYear() {
		return sellRepository.countThisYear();
	}
	
	
	public int countSellInLastYear() {
		return sellRepository.countLastYear();
	}
	
	
	public int countAllSell(){
		return sellRepository.countAll();
	}
	
	
	public Float getSellPercentageofDayOnThisMonth(){
		int countToday = sellRepository.countToday();
		int countYesterday = sellRepository.countYesterday();
		int countThisMonth = sellRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	
	public Float getSellPercentageofWeekOnThisMonth(){
		int countToday = sellRepository.countThisWeek();
		int countYesterday = sellRepository.countLastWeek();
		int countThisMonth = sellRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	
	public Float getSellPercentageofMonthOnThisYear(){
		int countToday = sellRepository.countThisMonth();
		int countYesterday = sellRepository.countLastMonth();
		int countThisMonth = sellRepository.countThisYear();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	
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
