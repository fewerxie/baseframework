package com.fewer.common.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.util.Date;

/**
 * Cache工具类
 *
 * @author DHC
 * @version 2013-5-29
 */
public class CacheUtils {

    private static CacheManager cacheManager = SpringContextHolder.getBean("cacheManager");

    private static final String CACHE_TIME_STAMP = "4028811_CACHE_TIME_STAMP";

    /**
     * 获取缓存
     *
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        Element element = getCache(cacheName).get(key);
        return element == null ? null : element.getObjectValue();
    }

    /**
     * 获取带时间戳控制的缓存 --目前设置为今天内
     *
     * @param cacheName
     * @param key
     * @param defaultValue
     * @return
     */
    public static Object getTodayCache(String cacheName, String key, Object defaultValue) {
        Element timeStamp = getCache(cacheName).get(CACHE_TIME_STAMP);
        Element element = null;
        Date nowDate = new Date();
        if (timeStamp == null || !DateUtils.isSameDay(nowDate, (Date) timeStamp.getObjectValue())) {
            removeCacheType(cacheName);
            put(cacheName, CACHE_TIME_STAMP, nowDate);
        } else {
            element = getCache(cacheName).get(key);
        }

        return element == null ? defaultValue : element.getObjectValue();
    }

    /**
     * 写入带时间戳控制的缓存 --目前设置为今天内
     *
     * @param cacheName
     * @param key
     * @param value
     */
    public static void putTodayCache(String cacheName, String key, Object value) {
        // 具有副作用的get语句
        getTodayCache(cacheName, CACHE_TIME_STAMP, null);
        put(cacheName, key, value);
    }

    /**
     * 写入缓存
     *
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        Element element = new Element(key, value);
        getCache(cacheName).put(element);
    }

    /**
     * 从缓存中移除
     *
     * @param cacheName
     * @param key
     */
    public static void remove(String cacheName, String key) {
        getCache(cacheName).remove(key);
    }

    /**
     * 从缓存中移除
     *
     * @param cacheName
     */
    public static void removeCacheType(String cacheName) {
        cacheManager.removeCache(cacheName);
    }

    /**
     * 获得一个Cache，没有则创建一个。
     *
     * @param cacheName
     * @return
     */
    private static Cache getCache(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            cacheManager.addCache(cacheName);
            cache = cacheManager.getCache(cacheName);
            cache.getCacheConfiguration().setEternal(true);
        }
        return cache;
    }

    public static CacheManager getCacheManager() {
        return cacheManager;
    }

}
