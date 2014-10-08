package org.mo.jims.coop.service;

import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.repository.GoodInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("goodInfoService")
public class GoodInfoService {

	private GoodInfoRepository goodInfoRepository;

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public GoodInfo getGoodInfoByName(String name) {
		GoodInfo selcetByName = null;
		selcetByName = goodInfoRepository.selcetByName(name);
		if (selcetByName == null) {
			return null;
		}
		return selcetByName;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public Page<GoodInfo> getGoodInfoByNameOrAbbreviation(String name, int page, int pageSize) {
		Page<GoodInfo> goodInfoPage = new Page<GoodInfo>();
		goodInfoPage.setTotalElement(goodInfoRepository.countAllByNameOrAbbreviation(name), pageSize);
		if(goodInfoPage.getTotalElement() == 0){
			return goodInfoPage;
		}
		goodInfoPage.setPageSize(pageSize);
		goodInfoPage.setCurrentPage(page);
		List<GoodInfo> selectAllByNameOrAbbreviation = 
				goodInfoRepository.selectAllByNameOrAbbreviation(name, (page - 1) * pageSize, pageSize);
		goodInfoPage.setContent(selectAllByNameOrAbbreviation);
		return goodInfoPage;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public GoodInfo getByPK(String id) {
		return goodInfoRepository.selectByPK(id);
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean save(GoodInfo entity) {
		goodInfoRepository.insert(entity);
		return true;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean alter(GoodInfo entity) {
		goodInfoRepository.updateByPK(entity);
		return true;
	}

	@Transactional(noRollbackFor = Exception.class)
	public boolean removeByPK(String id) {
		goodInfoRepository.deleteByPK(id);
		return true;
	}

	public GoodInfoRepository getGoodInfoRepository() {
		return goodInfoRepository;
	}

	@Resource(name = "goodInfoRepository")
	public void setGoodInfoRepository(
			GoodInfoRepository goodInfoRepository) {
		this.goodInfoRepository = goodInfoRepository;
	}

}
