package com.fewer.testframework.domain;

import com.fewer.common.persistence.pojo.CrudPOJO;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName TestPOJO
 * @Description 测试实体
 * @Author xiezy
 * @Date 2020/10/10 15:07
 * @Version V1.0
 **/
@Data
@Table(name = "BASE_TEST")
public class TestPOJO extends CrudPOJO<TestPOJO> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JDBC")
    private String id;
    private String name;
    private Integer age;

}