package com.fewer.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName StringUtils
 * @Description 字符串处理工具
 * @Author xiezy
 * @Date 2020/10/14 15:48
 * @Version V1.0
 **/

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static int getMaxContinuity(String s, char c) {
        int max = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                n++;
            } else {
                n = 0;
            }
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    /**
     * 将Double格式化转化为String
     *
     * @param data
     * @return
     */
    public static String StrDouble(Double data) {
        DecimalFormat df = new DecimalFormat("###,###,###");
        if (data == null) {
            return "";
        }
        return df.format(data);
    }

    /**
     * 将Double格式化转化为String
     *
     * @param data
     * @return
     */
    public static String StrDouble1(Double data) {
        DecimalFormat df = new DecimalFormat("#");
        if (data == null) {
            return "";
        }
        return df.format(data);
    }

    /**
     * 将字符串中的'转为''
     *
     * @param sql
     * @return
     */
    public static String StrSql(String sql) {
        if (sql == null) {
            return "";
        }
        return sql.replaceAll("'", "''");
    }

    /**
     * 判断str是否为空，如果str是null返回空，如果str是""返回空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if (null == str) {
            return false;
        }
        if ("".equals(trim(str))) {
            return false;
        }
        return true;
    }

    /**
     * 判断str是否为空，如果str是null返回空，如果str是""返回空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (null == str) {
            return true;
        }
        if ("".equals(trim(str))) {
            return true;
        }
        return false;
    }

    /**
     * 判断strs是否包含str
     *
     * @param str
     * @return
     */
    public static boolean inString(String str, String... strs) {
        if (isNotEmpty(str)) {
            for (String s : strs) {
                if (str.equals(s.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 去掉HTML标签
     *
     * @param input
     * @return
     */
    public static String escapeHTMLTags(String input) {
        //检查input是否为空
        if (StringUtils.isEmpty(input)) {
            return input;
        }

        //去掉脚本代码
        input = RegexPattern("<script.*?</script>", "", input);
        //去掉样式代码
        input = RegexPattern("<style.*?</style>", "", input);
        //去掉注释
        input = RegexPattern("<!--.*?-->", "", input);
        //去掉tag
        input = RegexPattern("<[^>]+()>", "", input);
        input = input.replaceAll("&nbsp;", " ");
        input = input.replaceAll("&rdquo;", "\u201D");
        input = input.replaceAll("&ldquo;", "\u201C");
        input = input.replaceAll("&mdash;", "\u2014");
        input = input.replaceAll("<br>", " ");
        input = input.replaceAll("<br/>", " ");
        input = input.replaceAll("<br />", " ");
        return input.trim();
    }

    /**
     * 将content中的符合pattern正则表达式的内容用str来替换
     *
     * @param pattern
     * @param str
     * @param content
     * @return
     */
    public static String RegexPattern(String pattern, String str, String content) {
        if (pattern != null && !pattern.equals("")) {
            Pattern p = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(content);
            content = m.replaceAll(str);
        }
        return content;
    }

    /**
     * 正则表达式字符转义
     *
     * @param original
     * @return
     */
    public static String escapeDollarBackslash(String original) {
        StringBuffer buffer = new StringBuffer(original.length());
        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (c == '\\' || c == '$' || c == '.' || c == '*' || c == '?'
                    || c == '(' || c == ')' || c == '+' || c == '|' || c == '{'
                    || c == '[' || c == '^') {
                buffer.append("\\").append(c);
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    /**
     * 由当前时间生成一个字符串
     *
     * @return
     */
    public static String currentTimeMillis() {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 精确截取字符串
     *
     * @param source 待精确截取的字符串
     * @param len    截取长度，长度是以byte为单位的，一个汉字是2个byte
     * @param symbol 省略的信息的字符，如“...”,“>>>”等
     * @return
     */
    public static String BiteOffString(String source, int len, String symbol) {
        int counterOfDoubleByte = 0;
        byte b[];
        String temp = "";

        try {
            b = source.getBytes("GBK");
            if (b.length <= len) {
                return source;
            }
            for (int i = 0; i < len; i++) {
                if (b[i] < 0) {
                    counterOfDoubleByte++;
                }
            }
            if (counterOfDoubleByte % 2 == 0) {
                temp = new String(b, 0, len, "GBK") + symbol;
            } else {
                temp = new String(b, 0, len - 1, "GBK") + symbol;
            }
        } catch (UnsupportedEncodingException e) {

        }
        return temp;
    }

    /**
     * lucene搜索时需要去掉的特殊字符
     *
     * @param src
     * @return
     */
    public static String refuseLucene(String src) {
        String[] refuse = {"+", "-", "&&", "||", "!", "(", ")", "{", "}", "[", "]", "^", "\"", "~", "*", "?", ":", "\\"};
        for (int i = 0; i < refuse.length; i++) {
            src = src.replace(refuse[i], "");
        }
        return src;
    }

    /**
     * 得到文件扩展名
     *
     * @param filename
     * @return
     */
    public static String getExt(String filename) {
        String ext = "";
        final String invaild = "gif,bmp,jpg,png";
        int i = filename.lastIndexOf('.');
        if (i != -1) {
            ext = filename.substring(i + 1, filename.length()).toLowerCase();
            if (invaild.indexOf(ext) == -1) {
                return "";
            } else {
                return ext;
            }
        }
        return ext;
    }

    /**
     * 对url进行编码
     *
     * @param url
     * @param encode
     * @return
     */
    public static String urlEncode(String url, String encode) {
        String temp = "";
        try {
            temp = URLEncoder.encode(url, encode);
        } catch (UnsupportedEncodingException e) {
        }
        return temp;
    }

    /**
     * 对url进行解码
     *
     * @param url
     * @param encode
     * @return
     */
    public static String urlDecode(String url, String encode) {
        String temp = "";
        try {
            temp = URLDecoder.decode(url, encode);
        } catch (UnsupportedEncodingException e) {
        }
        return temp;
    }

    /**
     * 字符串转换成数组
     *
     * @param c
     * @return
     */
    public static String getWordKey(String url, String c) {
        String temp = "";
        c = c.replace("　", " ");
        c = c.replace("、", " ");
        c = c.replace("/", "");
        c = c.replace("|", "");
        c = c.trim();
        if (c.length() > 0) {
            String[] cc = c.split(" ");
            for (String a : cc) {
                temp = temp + "<a href='" + url + a + ".html' title='标签' target='_blank'>" + a + "</a> ";
            }
        }
        return temp;
    }

    /**
     * 按照###,###格式化数据
     *
     * @param d
     * @return
     */
    public static String format(int d) {
        DecimalFormat nf = new DecimalFormat("###,###");
        try {
            return nf.format(d);
        } catch (Exception e) {
            return String.valueOf(d);
        }
    }

    /**
     * 数字字符串转换为日期类型字符串
     * 20180112 === 2018-01-12
     *
     * @param str
     * @return
     */
    public static String dateStr(String str) {
        StringBuffer newStr = new StringBuffer();
        newStr.append(str.substring(0, 4));
        newStr.append("-");
        newStr.append(str.substring(4, 6));
        newStr.append("-");
        newStr.append(str.substring(6, 8));
        return newStr.toString();
    }

    /**
     * 转换占位符
     *
     * @param hql
     * @return
     */
    public static String changePla(String hql) {
        String[] h = hql.split(" ");
        StringBuilder sb = new StringBuilder();
        Integer num = 0;
        for (String s : h) {
            if (s.contains("?")) {
                s = s.replace("?", "?" + num.toString());
                num++;
            }
            sb.append(s + " ");
        }
        return sb.toString();
    }
}