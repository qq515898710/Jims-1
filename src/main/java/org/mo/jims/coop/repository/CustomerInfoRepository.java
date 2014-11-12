package org.mo.jims.coop.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("customerInfoRepository")
public interface CustomerInfoRepository extends
		BaseRepository<CustomerInfo, String> {

	public CustomerInfo selcetByName(@Param("name") String name);

	public int countAllByCriteria(@Param("name") String param,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

	public List<CustomerInfo> selectAllByCriteria(
			@Param("name") String param, @Param("beginTime") Date beginTime,
			@Param("endTime") Date endTime, @Param("offset") int offset,
			@Param("size") int size);

	public List<CustomerInfo> selectAllByPage(@Param("offset") int offset,
			@Param("size") int size);

	public void batchDelete(String[] ids);// 单参数的不需要@Param
}
