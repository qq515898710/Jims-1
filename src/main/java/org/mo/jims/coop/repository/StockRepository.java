package org.mo.jims.coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.Stock;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 入库repository
 * 
 * @author moziqi
 *
 */
@Repository("stockRepository")
public interface StockRepository extends BaseRepository<Stock, String> {

	/**
	 * @param ProviderName 提供商h
	 * @param GoodName 货物
	 * @param UserName 操作员
	 * @param startTime 起始时间
	 * @param endTime 起始时间
	 * @return 大小
	 */
	public int countAllByCriteria(
			@Param("ProviderName") String ProviderName,
			@Param("GoodName") String GoodName,
			@Param("UserName") String UserName,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime);

	public List<Stock> selectAllByCriteria(
			@Param("ProviderName") String ProviderName,
			@Param("GoodName") String GoodName,
			@Param("UserName") String UserName,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime,
			@Param("offset") int offset, @Param("size") int size);
}
