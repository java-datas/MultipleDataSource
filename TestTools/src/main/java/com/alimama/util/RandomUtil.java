package com.alimama.util;

import java.util.Random;

/**
 * @author zhangkun
 * @create 2018-12-24 4:12 PM
 * @desc 生成随机字符串工具类
 **/

public class RandomUtil {

    private static final Random random = new Random();

    private static final String digit = "0123456789";
    private static final String alpha = "qwertyuiopasdfghjklzxcvbnm";
    private static final String alphaDigit = "qw3e0r-1tyui-opasd-f798ghj4k-l5z2xcv6bnm";

    /**
     * 获取随机指定长度的数字随机数
     *
     * @param len
     * @return 数字随机数
     */
    public static String rand09(int len) {
        return rand(len, digit);
    }

    /**
     * 获取存字母指定长度的随机数
     *
     * @param len
     * @return 字母随机数
     */
    public static String randAz(int len) {
        return rand(len, alpha);
    }


    /**
     * 获取混合指定长度随机数
     *
     * @param len
     * @return 混合随机数
     */
    public static String randAz09(int len) {
        return rand(len, alphaDigit);
    }


    public static String rand(int len, CharSequence candidate) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int r = random.nextInt(candidate.length());
            sb.append(candidate.charAt(r));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(randAz(23));
        System.out.println(rand09(9));
        System.out.println(randAz09(31));
    }


}
