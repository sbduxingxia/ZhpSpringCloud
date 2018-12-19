package com.zhp.springcloud.dao;

/**
 * @author zhp.dts
 * @date 2018/7/18.
 */
public interface SimpleDao<T> {
    int deleteByPrimaryKey(Object id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
