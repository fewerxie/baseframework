package com.fewer.common.config;

import com.fewer.common.utils.PropertiesLoader;
import com.fewer.common.utils.StringUtils;
import com.google.common.collect.Maps;
import org.springframework.web.context.ContextLoader;

import java.util.Map;

/**
 * @Description: 全局配置类
 * @Author: xiezy
 * @Date: 2020/10/15 10:25
 */
public class GlobalConfig {

    /**
     * 当前对象实例
     */
    private static GlobalConfig global = new GlobalConfig();

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader = new PropertiesLoader("properties/global.properties");

    /**
     * 获取当前对象实例
     */
    public static GlobalConfig getInstance() {
        return global;
    }

    /**
     * 获取配置
     *
     * @see${fns:getConfig('adminPath')}
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null) {
            value = loader.getProperty(key);
            map.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }

    /**
     * 获取配置
     *
     * @param propertiesName 配置文件名字
     * @param key
     * @return
     */
    public static String getConf(String propertiesName, String key) {
        PropertiesLoader loaderForField = new PropertiesLoader(propertiesName);
        String value = loaderForField.getProperty(key);
        return value;
    }

    /**
     * 页面获取常量
     *
     * @see${fns:getConst('YES')}
     */
    public static Object getConst(String field) {
        try {
            return GlobalConfig.class.getField(field).get(null);
        } catch (Exception e) {
            // 异常代表无配置，这里什么也不做
        }
        return null;
    }

    /**
     * 获取上传文件的根目录
     *
     * @return
     */
    public static String getUserfilesBaseDir() {
        String dir = getConfig("userfiles.basedir");
        if (StringUtils.isBlank(dir)) {
            try {
                dir = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
            } catch (Exception e) {
                return "";
            }
        }
        if (!dir.endsWith("/")) {
            dir += "/";
        }
        return dir;
    }

}
