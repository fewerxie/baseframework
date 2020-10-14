package com.fewer.testframework.service;

import com.fewer.testframework.domain.TestPOJO;

import java.util.List;

/**
 * @ClassName TestService
 * @Description
 * @Author xiezy
 * @Date 2020/10/10 15:08
 * @Version V1.0
 **/
public interface TestService {

    List<TestPOJO> findList();

    int addData(TestPOJO testPOJO);

    int modifyData(TestPOJO testPOJO);

    int deleteData(TestPOJO testPOJO);

}
