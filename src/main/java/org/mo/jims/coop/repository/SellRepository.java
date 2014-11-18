package org.mo.jims.coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.Sell;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("sellRepository")
public interface SellRepository extends BaseRepository<Sell, String> {
	
	public int countAllByCriteria(@Param("inventoryName") String inventoryName,
			@Param("customerName") String customerName,
			@Param("beginTime")Date beginTime,  @Param("endTime")Date endTime);

	public List<Sell> selectAllByCriteria(@Param("inventoryName") String inventoryName,
			@Param("customerName") String customerName,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
			@Param("offset") int offset, @Param("size") int size);
}
