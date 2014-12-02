package org.mo.jims.coop.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.repository.GoodInfoRepository;
import org.mo.open.common.util.Page;
import org.springframework.stereotype.Service;

@Service("goodInfoService")
public class GoodInfoService {
	
	private final static int BATCH_SIZE = 100;
	
	private GoodInfoRepository goodInfoRepository;


	public List<GoodInfo> getGoodInfoByProvider(String name) {
		if (!"".equals(name) && name != null) {
			return goodInfoRepository.selectByProvider(name);
		}
		return null;
	}

	public List<String> getAllGoodName() {
		return goodInfoRepository.selectAllGoodName();
	}

	public boolean batchRemove(List<String> id) {
		if (id.size() > 0) {
			if (id.size() <= BATCH_SIZE) {
				goodInfoRepository.batchDelete(id);
			} else {
				int count = id.size() / BATCH_SIZE;
				if (id.size() % BATCH_SIZE != 0) {
					count += 1;
				}
				List<String> temp = null;
				int startIndex = 0;
				int endIndex = 0;
				for (int i = 0; i < count; i++) {
					startIndex = i * BATCH_SIZE;
					endIndex = startIndex + BATCH_SIZE;
					if (endIndex > id.size()) {
						endIndex = id.size();
					}
					System.out.println("=========== 批次：" + (i + 1)
							+ ", startIndex:" + startIndex + ", endIndex:"
							+ endIndex);
					temp= id.subList(startIndex, endIndex);
					goodInfoRepository.batchDelete(temp);
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean batchInsert(List<GoodInfo> goodInfos){
		if (goodInfos.size() > 0) {
			if (goodInfos.size() <= BATCH_SIZE) {
				goodInfoRepository.batchInsert(goodInfos);
			} else {
				int count = goodInfos.size() / BATCH_SIZE;
				if (goodInfos.size() % BATCH_SIZE != 0) {
					count += 1;
				}
				@SuppressWarnings("unused")
				List<GoodInfo> temp = null;
				int startIndex = 0;
				int endIndex = 0;
				for (int i = 0; i < count; i++) {
					startIndex = i * BATCH_SIZE;
					endIndex = startIndex + BATCH_SIZE;
					if (endIndex > goodInfos.size()) {
						endIndex = goodInfos.size();
					}
					System.out.println("=========== 批次：" + (i + 1)
							+ ", startIndex:" + startIndex + ", endIndex:"
							+ endIndex);
					temp = goodInfos.subList(startIndex, endIndex);
					goodInfoRepository.batchInsert(goodInfos);
				}
			}
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

	public boolean saveGoodInfo(GoodInfo goodInfo) {
		if (goodInfo != null) {
			if (goodInfo.getTime() == null) {
				goodInfo.setTime(goodInfoRepository.getCurrentTime());
			}
			String name = goodInfo.getName();
			int countByGoodName = goodInfoRepository.countByGoodName(name);
			if(countByGoodName == 0){
				try {
					goodInfoRepository.insert(goodInfo);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
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
			goodInfoRepository.deleteByPK(id);
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

}
