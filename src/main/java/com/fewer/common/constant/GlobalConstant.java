package com.fewer.common.constant;

/**
 * @Description: 常量类
 * @Author: xiezy
 * @Date: 2020/10/15 10:28
 */
public class GlobalConstant {

    public enum WhetherString {
        YES("1"),
        NO("0");
        private String value;

        WhetherString(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public enum WhetherInteger {
        YES(1),
        NO(0);
        private Integer value;

        WhetherInteger(Integer value) {
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }
    }

}
