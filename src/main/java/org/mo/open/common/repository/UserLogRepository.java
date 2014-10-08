package org.mo.open.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.open.common.entity.UserLog;
import org.springframework.stereotype.Repository;

@Repository("userLogRepository")
public interface UserLogRepository extends BaseRepository<UserLog, Long> {

	public int countByAccount(@Param("account") String account);

	public List<UserLog> selectByAccount(@Param("account") String account,
			@Param("offset") int offset, @Param("size") int size);

	public int countByLikeAccount(@Param("account") String account);

	public List<UserLog> selectByLikeAccount(@Param("account") String account,
			@Param("offset") int offset, @Param("size") int size);

}
