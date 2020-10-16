package com.fewer.user.utils;

import com.fewer.common.utils.CacheUtils;
import com.fewer.user.pojo.UserPOJO;
import com.fewer.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @Description: 用户工具类
 * @Author: xiezy
 * @Date: 2020/10/16 10:02
 */
public class UserUtils {

    @Autowired
    private static UserService userService;

    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "loginName_";

    /**
     * 获取当前用户
     *
     * @return 取不到返回 new UserPOJO()
     */
    public static UserPOJO getUser() {
        UserPOJO userPOJO = getCache();
        if (userPOJO != null) {
            return userPOJO;
        }
        return new UserPOJO();
    }

    /**
     * 获取当前用户缓存
     */
    public static UserPOJO getCache() {
        return UserUtils.getCache(getUser());
    }

    /**
     * 获取指定用户缓存
     *
     * @param userPOJO
     */
    public static UserPOJO getCache(UserPOJO userPOJO) {
        UserPOJO userPOJOCache = (UserPOJO) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + userPOJO.getId());
        return Objects.isNull(userPOJOCache) ? (UserPOJO) CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + userPOJO.getLoginName()) : null;
    }

    /**
     * 添加当前用户缓存
     */
    public static void addCache() {
        UserUtils.addCache(getUser());
    }

    /**
     * 添加指定用户缓存
     *
     * @param userPOJO
     */
    public static void addCache(UserPOJO userPOJO) {
        CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + userPOJO.getId(), userPOJO);
        CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + userPOJO.getLoginName(), userPOJO);
    }

    /**
     * 清除当前用户缓存
     */
    public static void clearCache() {
        UserUtils.clearCache(getUser());
    }

    /**
     * 清除指定用户缓存
     *
     * @param userPOJO
     */
    public static void clearCache(UserPOJO userPOJO) {
        CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + userPOJO.getId());
        CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + userPOJO.getLoginName());
    }

}
