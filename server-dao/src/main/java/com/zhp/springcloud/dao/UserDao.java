package com.zhp.springcloud.dao;

import com.zhp.springcloud.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 *create by zhp used generate
 */
@Mapper
public interface UserDao extends SimpleDao<User> {

    @ResultMap("BaseResultMap")
    @Select("select * from t_user where id = #{id}")
    User getUserById(String id);
}