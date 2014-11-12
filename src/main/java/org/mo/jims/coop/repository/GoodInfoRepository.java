package org.mo.jims.coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.jims.coop.entity.ProviderGood;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("goodInfoRepository")
public interface GoodInfoRepository extends BaseRepository<GoodInfo, String> {

	public GoodInfo selcetByName(@Param("name") String name);

	public int countAllByCriteria(@Param("name") String param,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

	public List<GoodInfo> selectAllByCriteria(
			@Param("name") String param, @Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime, @Param("offset") int offset,
			@Param("size") int size);

	public void batchDelete(String[] ids);// 单参数的不需要@Param

	/**
	 * 根据供应商查询货物
	 * 
	 * @param name
	 * @return
	 */
	public List<GoodInfo> selectByProvider(String name);
	
	public void saveRelativity(ProviderGood providerGood);
}
