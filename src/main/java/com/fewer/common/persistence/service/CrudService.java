package com.fewer.common.persistence.service;

import com.fewer.common.constant.GlobalConstant;
import com.fewer.common.persistence.dao.CrudDao;
import com.fewer.common.persistence.pojo.CrudPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 数据库service基类
 * @Author: xiezy
 * @Date: 2020/10/15 17:02
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends CrudPOJO<T>> extends BaseService {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    public T selectOne(String id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    public T selectOne(T entity) {
        return dao.selectOne(entity);
    }

    /**
     * 查询列表数据(无参)
     *
     * @return
     */
    public List<T> findList() {
        return dao.selectAll();
    }

    /**
     * 查询列表数据(带参)
     *
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return dao.select(entity);
    }

    /**
     * 根据条件查询记录数
     *
     * @param entity
     * @return
     */
    public Integer selectCount(T entity) {
        return dao.selectCount(entity);
    }

    /**
     * 保存数据（插入或更新，空值忽略）
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public Boolean save(T entity) {
        int successCount;
        if (entity.getIsNewRecord()) {
            entity.preInsert();
            successCount = dao.insertSelective(entity);
        } else {
            entity.preUpdate();
            successCount = dao.updateByPrimaryKeySelective(entity);
        }
        return (successCount == GlobalConstant.WhetherInteger.YES.getValue());
    }

    /**
     * 保存数据（插入或更新,空值覆盖）
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public Boolean saveNull(T entity) {
        int successCount;
        if (entity.getIsNewRecord()) {
            entity.preInsert();
            successCount = dao.insert(entity);
        } else {
            entity.preUpdate();
            successCount = dao.updateByPrimaryKey(entity);
        }
        return (successCount == GlobalConstant.WhetherInteger.YES.getValue());
    }

    /**
     * 删除数据(根据主键)
     *
     * @param id
     */
    @Transactional(readOnly = false)
    public Boolean delete(String id) {
        return (dao.deleteByPrimaryKey(id) == GlobalConstant.WhetherInteger.YES.getValue());
    }

    /**
     * 删除数据(根据条件)
     *
     * @param entity
     */
    @Transactional(readOnly = false)
    public Boolean delete(T entity) {
        return (dao.delete(entity) == GlobalConstant.WhetherInteger.YES.getValue());
    }

}
