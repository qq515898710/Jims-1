package org.mo.open.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mo.open.common.entity.User;
import org.mo.open.common.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends BaseRepository<User, String> {
	
	public int countAllByCriteria(@Param("account") String account,
			@Param("username") String username);

	public List<User> selectAllByCriteria(@Param("account") String account,
			@Param("username") String username, @Param("offset") int offset,
			@Param("size") int size);

	public User selectUserByAccountAndPassword(@Param("account")String account, @Param("password")String password);
	
	public void deleteRelativity(UserRole userRole);

}
