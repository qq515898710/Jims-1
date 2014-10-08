package org.mo.jims.coop.service;

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
	public CustomerInfo getCustomerInfoByName(String name) {
		CustomerInfo selcetByName = null;
		selcetByName = customerInfoRepository.selcetByName(name);
		if (selcetByName == null) {
			return null;
		}
		return selcetByName;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<CustomerInfo> getCustomerInfoByNameOrAbbreviation(String name, int page, int pageSize) {
		Page<CustomerInfo> customerInfoPage = new Page<CustomerInfo>();
		customerInfoPage.setTotalElement(customerInfoRepository.countAllByNameOrAbbreviation(name), pageSize);
		if(customerInfoPage.getTotalElement() == 0){
			return customerInfoPage;
		}
		customerInfoPage.setPageSize(pageSize);
		customerInfoPage.setCurrentPage(page);
		List<CustomerInfo> selectAllByNameOrAbbreviation = 
				customerInfoRepository.selectAllByNameOrAbbreviation(name, (page - 1) * pageSize, pageSize);
		customerInfoPage.setContent(selectAllByNameOrAbbreviation);
		return customerInfoPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public CustomerInfo getByPK(String id) {
		return customerInfoRepository.selectByPK(id);
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean save(CustomerInfo entity) {
		customerInfoRepository.insert(entity);
		return true;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean alter(CustomerInfo entity) {
		customerInfoRepository.updateByPK(entity);
		return true;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean removeByPK(String id) {
		customerInfoRepository.deleteByPK(id);
		return true;
	}

	public CustomerInfoRepository getCustomerInfoRepository() {
		return customerInfoRepository;
	}

	@Resource(name = "customerInfoRepository")
	public void setCustomerInfoRepository(
			CustomerInfoRepository customerInfoRepository) {
		this.customerInfoRepository = customerInfoRepository;
	}

}
