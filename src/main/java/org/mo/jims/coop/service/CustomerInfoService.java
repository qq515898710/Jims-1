package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.jims.coop.repository.CustomerInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("customerInfoService")
public class CustomerInfoService {

	private CustomerInfoRepository customerInfoRepository;

	public List<String> getAllCustomerName() {
		return customerInfoRepository.selectAllCustomerName();
	}
	
	public boolean batchRemove(String[] ids) {
		if (ids != null) {
			customerInfoRepository.batchDelete(ids);
			return true;
		}
		return false;
	}

	public CustomerInfo getCustomerInfoByName(String name) {
		if (!"".equals(name) && name != null) {
			return customerInfoRepository.selectByName(name);
		}
		return null;
	}

	public Page<CustomerInfo> getCustomerInfoByCriteria(String name,
			Date beginTime, Date endTime, int page, int pageSize) {
		Page<CustomerInfo> customerInfoPage = new Page<CustomerInfo>();
		customerInfoPage.setTotalElement(customerInfoRepository
				.countAllByCriteria(name, beginTime, endTime), pageSize);
		customerInfoPage.setPageSize(pageSize);
		customerInfoPage.setCurrentPage(page);
		if (customerInfoPage.getTotalElement() == 0) {
			return customerInfoPage;
		}
		List<CustomerInfo> selectAllByNameOrAbbreviation = customerInfoRepository
				.selectAllByCriteria(name, beginTime, endTime, (page - 1)
						* pageSize, pageSize);
		customerInfoPage.setContent(selectAllByNameOrAbbreviation);
		return customerInfoPage;
	}

	public Page<CustomerInfo> getAllCustomerInfoByPage(int page, int pageSize) {
		Page<CustomerInfo> customerInfoPage = new Page<CustomerInfo>();
		customerInfoPage.setTotalElement(customerInfoRepository.countAll(),
				pageSize);
		if (customerInfoPage.getTotalElement() == 0) {
			return customerInfoPage;
		}
		customerInfoPage.setPageSize(pageSize);
		customerInfoPage.setCurrentPage(page);
		List<CustomerInfo> selectAllByNameOrAbbreviation = customerInfoRepository
				.selectAllByPage((page - 1) * pageSize, pageSize);
		customerInfoPage.setContent(selectAllByNameOrAbbreviation);
		return customerInfoPage;
	}

	public boolean saveCustomerInfo(CustomerInfo entity) {
		if (entity != null) {
			if (entity.getTime() == null) {
				entity.setTime(customerInfoRepository.getCurrentTime());
			}
			String name = entity.getName();
			CustomerInfo selectByName = customerInfoRepository.selectByName(name);
			if (selectByName == null) {
				customerInfoRepository.insert(entity);
				return true;
			}
		}
		return false;
	}

	public boolean alterCustomerInfo(CustomerInfo entity) {
		if (entity != null) {
			customerInfoRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	public boolean removeCustomerInfoByPK(String id) {
		if (id != null && !"".equals(id)) {
			customerInfoRepository.deleteByPK(id);
			return true;
		}
		return false;
	}

	public CustomerInfo getCustomerInfoByPK(String id) {
		if (id != null && !"".equals(id)) {
			return customerInfoRepository.selectByPK(id);
		}
		return null;
	}

	public List<CustomerInfo> getCustomerInfoInToday() {
		return customerInfoRepository.selectToday();
	}

	public List<CustomerInfo> getCustomerInfoInYesterday() {
		return customerInfoRepository.selectYesterday();
	}

	public List<CustomerInfo> getCustomerInfoInThisWeek() {
		return customerInfoRepository.selectThisWeek();
	}

	public List<CustomerInfo> getCustomerInfoInLastWeek() {
		return customerInfoRepository.selectLastWeek();
	}

	public List<CustomerInfo> getCustomerInfoInThisMonth() {
		return customerInfoRepository.selectThisMonth();
	}

	public List<CustomerInfo> getCustomerInfoInLastMonth() {
		return customerInfoRepository.selectLastMonth();
	}

	public List<CustomerInfo> getCustomerInfoInThisYear() {
		return customerInfoRepository.selectThisYear();
	}

	public List<CustomerInfo> getCustomerInfoInLastYear() {
		return customerInfoRepository.selectLastYear();
	}

	public List<CustomerInfo> getAllCustomerInfo() {
		return customerInfoRepository.selectAll();
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
