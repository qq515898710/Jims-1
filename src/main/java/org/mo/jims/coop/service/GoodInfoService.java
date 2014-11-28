package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.ProviderGood;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.jims.coop.repository.GoodInfoRepository;
import org.mo.jims.coop.repository.ProviderInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("goodInfoService")
public class GoodInfoService {

	private GoodInfoRepository goodInfoRepository;

	private ProviderInfoRepository providerInfoRepository;

	public List<GoodInfo> getGoodInfoByProvider(String name) {
		if (!"".equals(name) && name != null) {
			return goodInfoRepository.selectByProvider(name);
		}
		return null;
	}

	public List<String> getAllGoodName() {
		return goodInfoRepository.selectAllGoodName();
	}

	public boolean batchRemove(String[] ids) {
		if (ids != null) {
			goodInfoRepository.batchDelete(ids);
			return true;
		}
		return false;
	}

	public GoodInfo getGoodInfoByName(String name) {
		if (!"".equals(name) && name != null) {
			return goodInfoRepository.selcetByName(name);
		}
		return null;
	}

	public Page<GoodInfo> getGoodInfoByCriteria(String name, Date beginTime,
			Date endTime, int page, int pageSize) {
		Page<GoodInfo> goodInfoPage = new Page<GoodInfo>();
		goodInfoPage
				.setTotalElement(goodInfoRepository.countAllByCriteria(name,
						beginTime, endTime), pageSize);
		goodInfoPage.setPageSize(pageSize);
		goodInfoPage.setCurrentPage(page);
		if (goodInfoPage.getTotalElement() == 0) {
			return goodInfoPage;
		}
		List<GoodInfo> selectAllByNameOrAbbreviation = goodInfoRepository
				.selectAllByCriteria(name, beginTime, endTime, (page - 1)
						* pageSize, pageSize);
		goodInfoPage.setContent(selectAllByNameOrAbbreviation);
		return goodInfoPage;
	}

	public GoodInfo getGoodInfoByPK(String id) {
		if (!"".equals(id) && id != null) {
			return goodInfoRepository.selectByPK(id);
		}
		return null;
	}

	public boolean saveGoodInfo(GoodInfo goodInfo, ProviderInfo providerInfo) {
		if (goodInfo != null && providerInfo != null) {
			if (goodInfo.getTime() == null) {
				goodInfo.setTime(goodInfoRepository.getCurrentTime());
			}
			String name = goodInfo.getName();
			GoodInfo selcetByName = goodInfoRepository.selcetByName(name);
			if(selcetByName == null){
				goodInfoRepository.insert(goodInfo);
				ProviderGood providerGood = new ProviderGood();
				providerGood.setGoodInfo(goodInfo);
				providerGood.setProviderInfo(providerInfo);
				goodInfoRepository.saveRelativity(providerGood);
				return true;
			}
		}
		return false;
	}

	public boolean alterGoodInfo(GoodInfo entity) {
		if (entity != null) {
			goodInfoRepository.updateByPK(entity);
			return true;
		}
		return false;
	}

	public boolean removeGoodInfoByPK(String id) {
		if (!"".equals(id) && id != null) {
			GoodInfo selectByPK = goodInfoRepository.selectByPK(id);
			ProviderGood providerGood = new ProviderGood();
			providerGood.setGoodInfo(selectByPK);
			goodInfoRepository.deleteByPK(id);
			//TODO:暂时移除删除关系,由于数据库设置了cascade
			//providerInfoRepository.deleteRelativity(providerGood);
			return true;
		}
		return false;
	}

	public List<GoodInfo> getGoodInfoInToday() {
		return goodInfoRepository.selectToday();
	}

	public List<GoodInfo> getGoodInfoInYesterday() {
		return goodInfoRepository.selectYesterday();
	}

	public List<GoodInfo> getGoodInfoInThisWeek() {
		return goodInfoRepository.selectThisWeek();
	}

	public List<GoodInfo> getGoodInfoInLastWeek() {
		return goodInfoRepository.selectLastWeek();
	}

	public List<GoodInfo> getGoodInfoInThisMonth() {
		return goodInfoRepository.selectThisMonth();
	}

	public List<GoodInfo> getGoodInfoInLastMonth() {
		return goodInfoRepository.selectLastMonth();
	}

	public List<GoodInfo> getGoodInfoInThisYear() {
		return goodInfoRepository.selectThisYear();
	}

	public List<GoodInfo> getGoodInfoInLastYear() {
		return goodInfoRepository.selectLastYear();
	}

	public List<GoodInfo> getAllGoodInfo() {
		return goodInfoRepository.selectAll();
	}

	public GoodInfoRepository getGoodInfoRepository() {
		return goodInfoRepository;
	}

	@Resource(name = "goodInfoRepository")
	public void setGoodInfoRepository(GoodInfoRepository goodInfoRepository) {
		this.goodInfoRepository = goodInfoRepository;
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
