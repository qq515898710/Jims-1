package org.mo.open.common.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author moziqi
 *
 * @param <T>
 * @param <PK>
 */
public interface BaseRepository<T extends Serializable, PK extends Serializable> {
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
	 * 通过主键查询
	 * 
	 * @param id
	 * @return
	 */
	public T selectByPK(PK id);

	/**
	 * 获取系统时间
	 * 
	 * @return
	 */
	public Date getCurrentTime();

	/**
	 * 获取最后插入的一条数据
	 * 
	 * @return
	 */
	public T getLatestInsert();

	/**
	 * 获取最后插入的一条数据id
	 * 
	 * @return
	 */
	public PK getLatestInsertId();

	/**
	 * 今天
	 * 
	 * @return
	 */
	public List<T> selectToday();

	/**
	 * 昨天
	 * 
	 * @return
	 */
	public List<T> selectYesterday();

	/**
	 * 本周
	 * 
	 * @return
	 */
	public List<T> selectThisWeek();

	/**
	 * 上周
	 * 
	 * @return
	 */
	public List<T> selectLastWeek();

	/**
	 * 本月
	 * 
	 * @return
	 */
	public List<T> selectThisMonth();

	/**
	 * 上一个月
	 * 
	 * @return
	 */
	public List<T> selectLastMonth();

	/**
	 * 本年
	 * 
	 * @return
	 */
	public List<T> selectThisYear();

	/**
	 * 上一年
	 * 
	 * @return
	 */
	public List<T> selectLastYear();

	/**
	 * 所有数据
	 * 
	 * @return
	 */
	public List<T> selectAll();

	/**
	 * 统计今天
	 * 
	 * @return
	 */
	public int countToday();

	/**
	 * 统计昨天
	 * 
	 * @return
	 */
	public int countYesterday();

	/**
	 * 统计本周
	 * 
	 * @return
	 */
	public int countThisWeek();

	/**
	 * 统计上周
	 * 
	 * @return
	 */
	public int countLastWeek();

	/**
	 * 统计本月
	 * 
	 * @return
	 */
	public int countThisMonth();

	/**
	 * 统计上个月
	 * 
	 * @return
	 */
	public int countLastMonth();

	/**
	 * 统计本年
	 * 
	 * @return
	 */
	public int countThisYear();

	/**
	 * 统计上一年
	 * 
	 * @return
	 */
	public int countLastYear();

	/**
	 * 所有记录总数
	 * 
	 * @return
	 */
	public int countAll();

}
