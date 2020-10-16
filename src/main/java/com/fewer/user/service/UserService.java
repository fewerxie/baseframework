package com.fewer.user.service;

import com.fewer.common.persistence.service.CrudService;
import com.fewer.user.dao.UserDao;
import com.fewer.user.pojo.UserPOJO;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description 用户Service
 * @Author xiezy
 * @Date 2020/10/10 15:07
 * @Version V1.0
 **/
@Service("userService")
public class UserService extends CrudService<UserDao, UserPOJO> {

}

