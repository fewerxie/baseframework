package com.fewer.user.dao;

import com.fewer.common.persistence.annotation.MyBatisDao;
import com.fewer.common.persistence.dao.CrudDao;
import com.fewer.user.pojo.UserPOJO;
import org.springframework.stereotype.Component;


/**
 * @ClassName UserDao
 * @Description 用户Dao
 * @Author xiezy
 * @Date 2020/10/10 15:07
 * @Version V1.0
 **/
@MyBatisDao
@Component
public interface UserDao extends CrudDao<UserPOJO> {

}
