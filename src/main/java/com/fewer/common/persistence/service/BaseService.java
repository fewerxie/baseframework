package com.fewer.common.persistence.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 所有service基类
 * @Author: xiezy
 * @Date: 2020/10/15 17:02
 */
@Transactional(readOnly = true)
public abstract class BaseService {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

}
