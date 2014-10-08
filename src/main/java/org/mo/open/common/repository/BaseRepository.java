package org.mo.open.common.repository;

import java.io.Serializable;

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
	public void insert(T entity);

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

}
