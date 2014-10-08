package org.mo.jims.coop.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.jims.coop.entity.GoodInfo;
import org.mo.open.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("goodInfoRepository")
public interface GoodInfoRepository extends BaseRepository<GoodInfo, String> {

	public GoodInfo selcetByName(@Param("name") String name);

	public int countAllByNameOrAbbreviation(@Param("name") String param);

	public List<GoodInfo> selectAllByNameOrAbbreviation(@Param("name") String param,
			@Param("offset") int offset, @Param("size") int size);
}
