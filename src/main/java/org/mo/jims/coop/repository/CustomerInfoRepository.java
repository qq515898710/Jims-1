package org.mo.jims.coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.CustomerInfo;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("customerInfoRepository")
public interface CustomerInfoRepository extends BaseRepository<CustomerInfo, String> {

	public CustomerInfo selcetByName(@Param("name") String name);

	public int countAllByNameOrAbbreviation(@Param("name") String param);

	public List<CustomerInfo> selectAllByNameOrAbbreviation(@Param("name") String param,
			@Param("offset") int offset, @Param("size") int size);
}
