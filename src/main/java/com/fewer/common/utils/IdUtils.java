package com.fewer.common.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 *
 * @author DHC
 * @version 2013-01-15
 */
@Service
@Lazy(false)
public class IdUtils {

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
