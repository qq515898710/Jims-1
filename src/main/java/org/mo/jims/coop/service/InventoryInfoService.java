package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.InventoryInfo;
import org.mo.jims.coop.repository.InventoryInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("inventoryInfoService")
public class InventoryInfoService {

	private InventoryInfoRepository inventoryInfoRepository;

	public List<InventoryInfo> getByInventoryInfoGoodName(String goodName) {
		if (goodName != null && !"".equals(goodName)) {
			return inventoryInfoRepository.selectByGoodName(goodName);
		}
		return null;
	}

	public List<InventoryInfo> getInventoryInfoByUser(String username) {
		if (username != null && !"".equals(username)) {
			return inventoryInfoRepository.selectByUser(username);
		}
		return null;
	}

	public boolean batchRemove(String[] id) {
		if (id != null) {
			inventoryInfoRepository.batchDelete(id);
			return true;
		}
		return false;
	}

	public Page<InventoryInfo> getInventoryInfoByCriteria(String goodName,
			Date beginTime, Date endTime, int page, int pageSize) {
		Page<InventoryInfo> inventoryInfoPage = new Page<InventoryInfo>();
		inventoryInfoPage.setTotalElement(inventoryInfoRepository
				.countAllByCriteria(goodName, beginTime, endTime), pageSize);
		inventoryInfoPage.setPageSize(pageSize);
		inventoryInfoPage.setCurrentPage(page);
		if (inventoryInfoPage.getTotalElement() == 0) {
			return inventoryInfoPage;
		}
		List<InventoryInfo> selectAllByNameOrAbbreviation = inventoryInfoRepository
				.selectAllByCriteria(goodName, beginTime, endTime, (page - 1)
						* pageSize, pageSize);
		inventoryInfoPage.setContent(selectAllByNameOrAbbreviation);
		return inventoryInfoPage;
	}

	public InventoryInfo getInventoryInfoByPK(String id) {
		if (!"".equals(id) && id != null) {
			return inventoryInfoRepository.selectByPK(id);
		}
		return null;
	}

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

	public boolean alterInventoryInfo(InventoryInfo entity) {
		if (entity != null) {
			inventoryInfoRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	public boolean removeInventoryInfoByPK(String id) {
		if (!"".equals(id) && id != null) {
			inventoryInfoRepository.deleteByPK(id);
			return true;
		}
		return false;
	}

	public List<InventoryInfo> getInventoryInfoInToday() {
		return inventoryInfoRepository.selectToday();
	}

	public List<InventoryInfo> getInventoryInfoInYesterday() {
		return inventoryInfoRepository.selectYesterday();
	}

	public List<InventoryInfo> getInventoryInfoInThisWeek() {
		return inventoryInfoRepository.selectThisWeek();
	}

	public List<InventoryInfo> getInventoryInfoInLastWeek() {
		return inventoryInfoRepository.selectLastWeek();
	}

	public List<InventoryInfo> getInventoryInfoInThisMonth() {
		return inventoryInfoRepository.selectThisMonth();
	}

	public List<InventoryInfo> getInventoryInfoInLastMonth() {
		return inventoryInfoRepository.selectLastMonth();
	}

	public List<InventoryInfo> getInventoryInfoInThisYear() {
		return inventoryInfoRepository.selectThisYear();
	}

	public List<InventoryInfo> getInventoryInfoInLastYear() {
		return inventoryInfoRepository.selectLastYear();
	}

	public List<InventoryInfo> getAllInventoryInfo() {
		return inventoryInfoRepository.selectAll();
	}

	public int countInventoryInfoInToday() {
		return inventoryInfoRepository.countToday();
	}

	public int countInventoryInfoInYesterday() {
		return inventoryInfoRepository.countYesterday();
	}

	public int countInventoryInfoInThisWeek() {
		return inventoryInfoRepository.countThisWeek();
	}

	public int countInventoryInfoInLastWeek() {
		return inventoryInfoRepository.countLastWeek();
	}

	public int countInventoryInfoInThisMonth() {
		return inventoryInfoRepository.countThisMonth();
	}

	public int countInventoryInfoInLastMonth() {
		return inventoryInfoRepository.countLastMonth();
	}

	public int countInventoryInfoInThisYear() {
		return inventoryInfoRepository.countThisYear();
	}

	public int countInventoryInfoInLastYear() {
		return inventoryInfoRepository.countLastYear();
	}

	public int countAllInventoryInfo() {
		return inventoryInfoRepository.countAll();
	}

	public Float getInventoryInfoPercentageofDayOnThisMonth() {
		int countToday = inventoryInfoRepository.countToday();
		int countYesterday = inventoryInfoRepository.countYesterday();
		int countThisMonth = inventoryInfoRepository.countThisMonth();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getInventoryInfoPercentageofWeekOnThisMonth() {
		int countToday = inventoryInfoRepository.countThisWeek();
		int countYesterday = inventoryInfoRepository.countLastWeek();
		int countThisMonth = inventoryInfoRepository.countThisMonth();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getInventoryInfoPercentageofMonthOnThisYear() {
		int countToday = inventoryInfoRepository.countThisMonth();
		int countYesterday = inventoryInfoRepository.countLastMonth();
		int countThisMonth = inventoryInfoRepository.countThisYear();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public Float getInventoryInfoPercentageofYearOnAll() {
		int countToday = inventoryInfoRepository.countThisYear();
		int countYesterday = inventoryInfoRepository.countLastWeek();
		int countThisMonth = inventoryInfoRepository.countAll();
		float result = (countToday / countThisMonth)
				- (countYesterday / countThisMonth);
		return result;
	}

	public InventoryInfoRepository getInventoryInfoRepository() {
		return inventoryInfoRepository;
	}

	@Resource(name = "inventoryInfoRepository")
	public void setInventoryInfoRepository(
			InventoryInfoRepository inventoryInfoRepository) {
		this.inventoryInfoRepository = inventoryInfoRepository;
	}

}
