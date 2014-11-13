package org.mo.jims.coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.StockReturn;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author moziqi
 *
 */
@Repository("stockReturnRepository")
public interface StockReturnRepository extends BaseRepository<StockReturn, String> {

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

	public List<StockReturn> selectAllByCriteria(
			@Param("ProviderName") String ProviderName,
			@Param("GoodName") String GoodName,
			@Param("UserName") String UserName,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
