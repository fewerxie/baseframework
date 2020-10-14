package com.fewer.testframework.dao;

import com.fewer.common.persistence.annotation.MyBatisDao;
import com.fewer.testframework.domain.TestPOJO;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;


/**
 * @ClassName TestDao
 * @Description
 * @Author xiezy
 * @Date 2020/10/10 15:07
 * @Version V1.0
 **/
@MyBatisDao
@Component
public interface TestDao extends Mapper<TestPOJO> {

}
