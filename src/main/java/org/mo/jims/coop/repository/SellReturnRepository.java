package org.mo.jims.coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.SellReturn;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("sellReturnRepository")
public interface SellReturnRepository extends BaseRepository<SellReturn, String> {
	
	public int countAllByCriteria(@Param("goodName") String goodName,
			@Param("customerName") String customerName,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

	public List<SellReturn> selectAllByCriteria(
			@Param("goodName") String goodName,
			@Param("customerName") String customerName,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
			@Param("offset") int offset, @Param("size") int size);
}
