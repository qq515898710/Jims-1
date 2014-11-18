package org.mo.jims.coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.InventoryInfo;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("inventoryInfoRepository")
public interface InventoryInfoRepository extends BaseRepository<InventoryInfo, String> {

	public int countAllByCriteria(@Param("goodName") String goodName,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

	public List<InventoryInfo> selectAllByCriteria(@Param("goodName") String goodName,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
			@Param("offset") int offset, @Param("size") int size);

	public void batchDelete(String[] id);

	/**
	 * 根据用户名
	 * 
	 * @param username
	 * @return
	 */
	public List<InventoryInfo> selectByUser(String username);
	
	public List<InventoryInfo> selectByGoodName(String goodName);

}
