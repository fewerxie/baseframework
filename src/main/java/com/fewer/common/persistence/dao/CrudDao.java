package com.fewer.common.persistence.dao;

import tk.mybatis.mapper.common.Mapper;

/**
 * @Description: 数据库dao层基类
 * @Author: xiezy
 * @Date: 2020/10/15 17:01
 */
public interface CrudDao<T> extends BaseDao, Mapper<T> {

}