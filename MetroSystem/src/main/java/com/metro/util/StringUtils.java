package com.metro.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/28
 * @Content:字符串工具类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
    public static String replaceNull(String target){
        return target == null ? "" : target;

    }

    /**
     * 获取32位随机字符串
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    /***
     * Unicode转中文方法 青舟路径的u300d转换
     * @param unicode
     * @return
     */
    public static String unicodeu300dConventEq(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u003d");
        String returnStr = strs[0]+"="+strs[1];
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        return returnStr;
    }

    /***
     * 中文转uncode
     * @param cn
     * @return
     */
    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }

    public static boolean isInteger(String str) {

        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

        return pattern.matcher(str).matches();

    }


    public static List<String> getSubUtil(String soap, String rgex){
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

}
