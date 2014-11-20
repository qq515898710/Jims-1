package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.ProviderGood;
import org.mo.jims.coop.repository.ProviderInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("providerInfoService")
public class ProviderInfoService {

	private ProviderInfoRepository providerInfoRepository;

	public List<ProviderInfo> getProviderInfoByGood(String name) {
		if (!"".equals(name) && name != null) {
			return providerInfoRepository.selectByGood(name);
		}
		return null;
	}

	public List<String> getAllProviderName() {
		return providerInfoRepository.selectAllProviderName();
	}

	public Boolean batchRemove(String[] id) {
		if (id != null) {
			providerInfoRepository.batchDelete(id);
			return true;
		}
		return false;
	}

	public ProviderInfo getProviderInfoByName(String name) {
		if (name != null && !"".equals(name)) {
			return providerInfoRepository.selectByName(name);
		}
		return null;
	}

	public Page<ProviderInfo> getProviderInfoByCriteria(String name,
			Date beginTime, Date endTime, int page, int pageSize) {
		Page<ProviderInfo> providerInfoPage = new Page<ProviderInfo>();
		providerInfoPage.setTotalElement(providerInfoRepository
				.countAllByCriteria(name, beginTime, endTime), pageSize);
		providerInfoPage.setPageSize(pageSize);
		providerInfoPage.setCurrentPage(page);
		if (providerInfoPage.getTotalElement() == 0) {
			return providerInfoPage;
		}
		List<ProviderInfo> selectAllByNameOrAbbreviation = providerInfoRepository
				.selectAllByCriteria(name, beginTime, endTime, (page - 1)
						* pageSize, pageSize);
		providerInfoPage.setContent(selectAllByNameOrAbbreviation);
		return providerInfoPage;
	}

	public ProviderInfo getProviderInfoByPK(String id) {
		if (id != null && !"".equals(id)) {
			return providerInfoRepository.selectByPK(id);
		}
		return null;
	}

	public boolean saveProviderInfo(ProviderInfo entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(providerInfoRepository.getCurrentTime());
			}
			providerInfoRepository.insert(entity);
			return true;
		}
		return false;
	}

	public boolean alterProviderInfo(ProviderInfo entity) {
		if (entity != null) {
			providerInfoRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	public boolean removeProviderInfoByPK(String id) {
		if (id != null && !"".equals(id)) {
			ProviderInfo selectByPK = providerInfoRepository.selectByPK(id);
			ProviderGood providerGood = new ProviderGood();
			providerGood.setProviderInfo(selectByPK);
			providerInfoRepository.deleteByPK(id);
			providerInfoRepository.deleteRelativity(providerGood);
			return true;
		}
		return false;
	}

	public List<ProviderInfo> getProviderInfoInToday() {
		return providerInfoRepository.selectToday();
	}

	public List<ProviderInfo> getProviderInfoInYesterday() {
		return providerInfoRepository.selectYesterday();
	}

	public List<ProviderInfo> getProviderInfoInThisWeek() {
		return providerInfoRepository.selectThisWeek();
	}

	public List<ProviderInfo> getProviderInfoInLastWeek() {
		return providerInfoRepository.selectLastWeek();
	}

	public List<ProviderInfo> getProviderInfoInThisMonth() {
		return providerInfoRepository.selectThisMonth();
	}

	public List<ProviderInfo> getProviderInfoInLastMonth() {
		return providerInfoRepository.selectLastMonth();
	}

	public List<ProviderInfo> getProviderInfoInThisYear() {
		return providerInfoRepository.selectThisYear();
	}

	public List<ProviderInfo> getProviderInfoInLastYear() {
		return providerInfoRepository.selectLastYear();
	}

	public List<ProviderInfo> getAllProviderInfo() {
		return providerInfoRepository.selectAll();
	}

	public ProviderInfoRepository getProviderInfoRepository() {
		return providerInfoRepository;
	}

	@Resource(name = "providerInfoRepository")
	public void setProviderInfoRepository(
			ProviderInfoRepository providerInfoRepository) {
		this.providerInfoRepository = providerInfoRepository;
	}

}
