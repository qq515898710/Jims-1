package org.mo.jims.coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.ProviderGood;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("providerInfoRepository")
public interface ProviderInfoRepository extends BaseRepository<ProviderInfo, String> {

	public ProviderInfo selectByName(@Param("name") String name);

	public int countAllByCriteria(@Param("name") String param,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

	public List<ProviderInfo> selectAllByCriteria(@Param("name") String param,
			@Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime, @Param("offset") int offset,
			@Param("size") int size);

	public void batchDelete(String[] id);
	
	public List<ProviderInfo> selectByGood(String name);
	
	public void deleteRelativity(ProviderGood providerGood);
	
	public List<String> selectAllProviderName();
}
