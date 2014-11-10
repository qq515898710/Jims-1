package org.mo.open.common.repository;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author moziqi
 *
 * @param <T>
 * @param <PK>
 */
public interface BaseRepository<T extends Serializable, PK extends Serializable> {
	/**
	 * 通过主键查询
	 * 
	 * @param id
	 * @return
	 */
	public T selectByPK(PK id);

	/**
	 * 插入数据
	 * 
	 * @param entity
	 */
	public int insert(T entity);

	/**
	 * 通过主键更新数据
	 * 
	 * @param entity
	 */
	public void updateByPK(T entity);

	/**
	 * 通过主键删除数据
	 * 
	 * @param entity
	 */
	public void deleteByPK(PK id);
	
	
	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public Date getCurrentTime();
	
	/**
	 * 获取最后插入的一条数据
	 * @return
	 */
	public T getLatestInsert();
	
	/**
	 * 获取最后插入的一条数据id
	 * @return
	 */
	public PK getLatestInsertId();

}
