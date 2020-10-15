package com.fewer.common.persistence.returnmessage;


import com.fewer.common.constant.GlobalConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 前台返回消息格式(messageStatus : 返回消息是否成功 ， message ： 返回消息内容)
 * @Author: xiezy
 * @Date: 2020/10/15 10:23
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("messageStatus", GlobalConstant.WhetherString.YES);
        put("message", "操作成功");
    }

    public R(String status, String msg) {
        put("messageStatus", status);
        put("message", msg);
    }

    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("message", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R error() {
        R r = new R();
        r.put("messageStatus", GlobalConstant.WhetherString.NO);
        r.put("message", "操作错误！");
        return r;
    }

    public static R error(String msg) {
        R r = new R();
        r.put("messageStatus", GlobalConstant.WhetherString.NO);
        r.put("message", msg);
        return r;
    }

    public boolean isSuccess() {
        return GlobalConstant.WhetherString.YES.equals(this.get("messageStatus"));
    }

    public boolean isError() {
        return !isSuccess();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

