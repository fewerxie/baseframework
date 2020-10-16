package com.fewer.testframework.service;

import com.fewer.common.persistence.service.CrudService;
import com.fewer.testframework.dao.TestDao;
import com.fewer.testframework.domain.TestPOJO;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestService
 * @Description 测试Service
 * @Author xiezy
 * @Date 2020/10/10 15:07
 * @Version V1.0
 **/
@Service("testService")
public class TestService extends CrudService<TestDao, TestPOJO> {

}

