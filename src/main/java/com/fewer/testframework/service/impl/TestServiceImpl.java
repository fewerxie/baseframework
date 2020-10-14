package com.fewer.testframework.service.impl;

import com.fewer.testframework.dao.TestDao;
import com.fewer.testframework.domain.TestPOJO;
import com.fewer.testframework.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName TestServiceImpl
 * @Description
 * @Author xiezy
 * @Date 2020/10/10 15:09
 * @Version V1.0
 **/
@Service("testServiceImpl")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    @Transactional
    public List<TestPOJO> findList() {
        System.out.println("Service查询所有");
        return testDao.selectAll();
    }

    @Override
    public int addData(TestPOJO testPOJO) {
        System.out.println("Service新增数据");
        return testDao.insert(testPOJO);
    }

    @Override
    public int modifyData(TestPOJO testPOJO) {
        System.out.println("Service修改数据");
        return testDao.insert(testPOJO);
    }

    @Override
    public int deleteData(TestPOJO testPOJO) {
        System.out.println("Service删除数据");
        return testDao.delete(testPOJO);
    }

}

