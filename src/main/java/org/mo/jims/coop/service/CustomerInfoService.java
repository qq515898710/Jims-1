package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.repository.CustomerInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("customerInfoService")
public class CustomerInfoService {

	private CustomerInfoRepository customerInfoRepository;

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<String> getAllCustomerName(){
		return customerInfoRepository.selectAllCustomerName();
	}
	
	@Transactional(noRollbackFor = Exception.class)
	public boolean batchRemove(String[] ids) {
		if (ids != null) {
			customerInfoRepository.batchDelete(ids);
			return true;
		}
		return false;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public CustomerInfo getCustomerInfoByName(String name) {
		if (!"".equals(name) && name != null) {
			return customerInfoRepository.selectByName(name);
		}
		return null;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<CustomerInfo> getCustomerInfoByCriteria(String name, Date beginTime, Date endTime, int page, int pageSize) {
		Page<CustomerInfo> customerInfoPage = new Page<CustomerInfo>();
		customerInfoPage.setTotalElement(customerInfoRepository.countAllByCriteria(name, beginTime, endTime),
				pageSize);
		customerInfoPage.setPageSize(pageSize);
		customerInfoPage.setCurrentPage(page);
		if (customerInfoPage.getTotalElement() == 0) {
			return customerInfoPage;
		}
		List<CustomerInfo> selectAllByNameOrAbbreviation = customerInfoRepository.selectAllByCriteria(name, beginTime, endTime,
						(page - 1) * pageSize, pageSize);
		customerInfoPage.setContent(selectAllByNameOrAbbreviation);
		return customerInfoPage;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<CustomerInfo> getAllCustomerInfoByPage(int page, int pageSize) {
		Page<CustomerInfo> customerInfoPage = new Page<CustomerInfo>();
		customerInfoPage.setTotalElement(customerInfoRepository.countAll(), pageSize);
		if(customerInfoPage.getTotalElement() == 0){
			return customerInfoPage;
		}
		customerInfoPage.setPageSize(pageSize);
		customerInfoPage.setCurrentPage(page);
		List<CustomerInfo> selectAllByNameOrAbbreviation = 
				customerInfoRepository.selectAllByPage((page - 1) * pageSize, pageSize);
		customerInfoPage.setContent(selectAllByNameOrAbbreviation);
		return customerInfoPage;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean saveCustomerInfo(CustomerInfo entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(customerInfoRepository.getCurrentTime());
			}
			customerInfoRepository.insert(entity);
			return true;
		}
		return false;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean alterCustomerInfo(CustomerInfo entity) {
		if (entity != null) {
			customerInfoRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean removeCustomerInfoByPK(String id) {
		if (id != null && !"".equals(id)) {
			customerInfoRepository.deleteByPK(id);
			return true;
		}
		return false;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public CustomerInfo getCustomerInfoByPK(String id) {
		if (id != null && !"".equals(id)) {
			return customerInfoRepository.selectByPK(id);
		}
		return null;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getCustomerInfoInToday() {
		return customerInfoRepository.selectToday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getCustomerInfoInYesterday() {
		return customerInfoRepository.selectYesterday();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getCustomerInfoInThisWeek() {
		return customerInfoRepository.selectThisWeek();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getCustomerInfoInLastWeek() {
		return customerInfoRepository.selectLastWeek();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getCustomerInfoInThisMonth() {
		return customerInfoRepository.selectThisMonth();
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getCustomerInfoInLastMonth() {
		return customerInfoRepository.selectLastMonth();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getCustomerInfoInThisYear() {
		return customerInfoRepository.selectThisYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getCustomerInfoInLastYear() {
		return customerInfoRepository.selectLastYear();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<CustomerInfo> getAllCustomerInfo(){
		return customerInfoRepository.selectAll();
	}
	
	public CustomerInfoRepository getCustomerInfoRepository() {
		return customerInfoRepository;
	}

	@Resource(name = "customerInfoRepository")
	public void setCustomerInfoRepository(CustomerInfoRepository customerInfoRepository) {
		this.customerInfoRepository = customerInfoRepository;
	}

}
