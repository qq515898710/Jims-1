package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.entity.ProviderGood;
import org.mo.jims.coop.repository.ProviderInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("providerInfoService")
public class ProviderInfoService {

	private ProviderInfoRepository providerInfoRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoByGood(String name){
		if (!"".equals(name) && name != null) {
			return providerInfoRepository.selectByGood(name);
		}
		return null;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<String> getAllProviderName(){
		return providerInfoRepository.selectAllProviderName();
	}
	
	@Transactional(noRollbackFor = Exception.class)
	public Boolean batchRemove(String[] id){
		if (id != null) {
			providerInfoRepository.batchDelete(id);
			return true;
		}
		return false;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public ProviderInfo getProviderInfoByName(String name) {
		if (name != null && !"".equals(name)) {
			return providerInfoRepository.selectByName(name);
		}
		return null;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
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

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public ProviderInfo getProviderInfoByPK(String id) {
		if(id!=null&&!"".equals(id)){
			return providerInfoRepository.selectByPK(id);
		}
		return null;
	}

	@Transactional(noRollbackFor = Exception.class)
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

	@Transactional(noRollbackFor = Exception.class)
	public boolean alterProviderInfo(ProviderInfo entity) {
		if (entity != null) {
			providerInfoRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean removeProviderInfoByPK(String id) {
		if(id!=null && !"".equals(id)){
			ProviderInfo selectByPK = providerInfoRepository.selectByPK(id);
			ProviderGood providerGood = new ProviderGood();
			providerGood.setProviderInfo(selectByPK);
			providerInfoRepository.deleteByPK(id);
			providerInfoRepository.deleteRelativity(providerGood);
			return true;
		}
		return false;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoInToday() {
		return providerInfoRepository.selectToday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoInYesterday() {
		return providerInfoRepository.selectYesterday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoInThisWeek() {
		return providerInfoRepository.selectThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoInLastWeek() {
		return providerInfoRepository.selectLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoInThisMonth() {
		return providerInfoRepository.selectThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoInLastMonth() {
		return providerInfoRepository.selectLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoInThisYear() {
		return providerInfoRepository.selectThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getProviderInfoInLastYear() {
		return providerInfoRepository.selectLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<ProviderInfo> getAllProviderInfo(){
		return providerInfoRepository.selectAll();
	}

	public ProviderInfoRepository getProviderInfoRepository() {
		return providerInfoRepository;
	}

	@Resource(name = "providerInfoRepository")
	public void setProviderInfoRepository(ProviderInfoRepository providerInfoRepository) {
		this.providerInfoRepository = providerInfoRepository;
	}

}
