package org.mo.jims.coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.ProviderInfo;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("providerInfoRepository")
public interface ProviderInfoRepository extends BaseRepository<ProviderInfo, String> {

	public ProviderInfo selcetByName(@Param("name") String name);

	public int countAllByNameOrAbbreviation(@Param("name") String param);

	public List<ProviderInfo> selectAllByNameOrAbbreviation(@Param("name") String param,
			@Param("offset") int offset, @Param("size") int size);
}
