package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.InventoryInfo;
import org.mo.jims.coop.repository.InventoryInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("inventoryInfoService")
public class InventoryInfoService {

	private InventoryInfoRepository inventoryInfoRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getByInventoryInfoGoodName(String goodName) {
		if (goodName != null && !"".equals(goodName)) {
			return inventoryInfoRepository.selectByGoodName(goodName);
		}
		return null;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoByUser(String username){
		if(username!=null && !"".equals(username)){
			return inventoryInfoRepository.selectByUser(username);
		}
		return null;
	}
	
	@Transactional(noRollbackFor = Exception.class)
	public boolean batchRemove(String[] id) {
		if (id != null) {
			inventoryInfoRepository.batchDelete(id);
			return true;
		}
		return false;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<InventoryInfo> getInventoryInfoByCriteria(String name, Date beginTime, Date endTime,
			int page, int pageSize) {
		Page<InventoryInfo> inventoryInfoPage = new Page<InventoryInfo>();
		inventoryInfoPage.setTotalElement(inventoryInfoRepository.countAllByCriteria(
				name, beginTime, endTime), pageSize);
		inventoryInfoPage.setPageSize(pageSize);
		inventoryInfoPage.setCurrentPage(page);
		if (inventoryInfoPage.getTotalElement() == 0) {
			return inventoryInfoPage;
		}
		List<InventoryInfo> selectAllByNameOrAbbreviation = inventoryInfoRepository.selectAllByCriteria(
				name, beginTime, endTime, (page - 1) * pageSize, pageSize);
		inventoryInfoPage.setContent(selectAllByNameOrAbbreviation);
		return inventoryInfoPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public InventoryInfo getInventoryInfoByPK(String id) {
		return inventoryInfoRepository.selectByPK(id);
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean saveInventoryInfo(InventoryInfo entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(inventoryInfoRepository.getCurrentTime());
			}
			inventoryInfoRepository.insert(entity);
			return true;
		}
		return false;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean alterInventoryInfo(InventoryInfo entity) {
		inventoryInfoRepository.updateByPK(entity);
		return true;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean removeInventoryInfoByPK(String id) {
		inventoryInfoRepository.deleteByPK(id);
		return true;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoInToday() {
		return inventoryInfoRepository.selectToday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoInYesterday() {
		return inventoryInfoRepository.selectYesterday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoInThisWeek() {
		return inventoryInfoRepository.selectThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoInLastWeek() {
		return inventoryInfoRepository.selectLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoInThisMonth() {
		return inventoryInfoRepository.selectThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoInLastMonth() {
		return inventoryInfoRepository.selectLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoInThisYear() {
		return inventoryInfoRepository.selectThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getInventoryInfoInLastYear() {
		return inventoryInfoRepository.selectLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<InventoryInfo> getAllInventoryInfo(){
		return inventoryInfoRepository.selectAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countInventoryInfoInToday(){
		return inventoryInfoRepository.countToday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countInventoryInfoInYesterday(){
		return inventoryInfoRepository.countYesterday();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countInventoryInfoInThisWeek() {
		return inventoryInfoRepository.countThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countInventoryInfoInLastWeek() {
		return inventoryInfoRepository.countLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countInventoryInfoInThisMonth() {
		return inventoryInfoRepository.countThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countInventoryInfoInLastMonth() {
		return inventoryInfoRepository.countLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countInventoryInfoInThisYear() {
		return inventoryInfoRepository.countThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countInventoryInfoInLastYear() {
		return inventoryInfoRepository.countLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public int countAllInventoryInfo(){
		return inventoryInfoRepository.countAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getInventoryInfoPercentageofDayOnThisMonth(){
		int countToday = inventoryInfoRepository.countToday();
		int countYesterday = inventoryInfoRepository.countYesterday();
		int countThisMonth = inventoryInfoRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getInventoryInfoPercentageofWeekOnThisMonth(){
		int countToday = inventoryInfoRepository.countThisWeek();
		int countYesterday = inventoryInfoRepository.countLastWeek();
		int countThisMonth = inventoryInfoRepository.countThisMonth();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getInventoryInfoPercentageofMonthOnThisYear(){
		int countToday = inventoryInfoRepository.countThisMonth();
		int countYesterday = inventoryInfoRepository.countLastMonth();
		int countThisMonth = inventoryInfoRepository.countThisYear();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Float getInventoryInfoPercentageofYearOnAll(){
		int countToday = inventoryInfoRepository.countThisYear();
		int countYesterday = inventoryInfoRepository.countLastWeek();
		int countThisMonth = inventoryInfoRepository.countAll();
		float result = (countToday / countThisMonth) - (countYesterday / countThisMonth);
		return result;
	}

	public InventoryInfoRepository getInventoryInfoRepository() {
		return inventoryInfoRepository;
	}

	@Resource(name = "inventoryInfoRepository")
	public void setInventoryInfoRepository(InventoryInfoRepository inventoryInfoRepository) {
		this.inventoryInfoRepository = inventoryInfoRepository;
	}

}
