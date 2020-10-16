package com.fewer.user.pojo;

import com.fewer.common.persistence.pojo.CrudPOJO;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserDao
 * @Description 用户实体
 * @Author xiezy
 * @Date 2020/10/10 15:07
 * @Version V1.0
 **/
@Data
public class UserPOJO extends CrudPOJO<UserPOJO> {

    private static final long serialVersionUID = 1L;

    /**
     * @Description: 登录名
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String loginName;

    /**
     * @Description: 密码
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String password;

    /**
     * @Description: 姓名
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String name;

    /**
     * @Description: 性别
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String sex;

    /**
     * @Description: 邮箱
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String email;

    /**
     * @Description: 电话
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String phone;

    /**
     * @Description: 手机
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String mobile;

    /**
     * @Description: 最后登陆IP
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String loginIp;

    /**
     * @Description: 最后登陆日期
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private Date loginDate;

    /**
     * @Description: 是否允许登陆
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String loginFlag;

    /**
     * @Description: 头像
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String icon;

    /**
     * @Description: 新密码
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String newPassword;

    /**
     * @Description: 再次输入密码
     * @Author: xiezy
     * @Date: 2020/10/16 9:18
     */
    private String rePassword;


}