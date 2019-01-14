package com.alimama.typehandler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class StringTool.
 */
public class StringTool {

    private StringTool(){}

    /**
     * list转成String.<br>
     * 分隔符为","
     * 
     * @param list the list
     * @return the string by list
     */
    public static String getStringByList(List<String> list) {
        if (!CollectionUtils.isEmpty(list)) {
            StringBuilder builder = new StringBuilder();
            for (String str : list) {
                builder.append(str);
                builder.append(",");
            }

            return builder.substring(0, builder.length() - 1);
        }
        return StringUtils.EMPTY;
    }

    /**
     * string 转成List<String>.<br>
     * 分隔符为","
     * 
     * @param arrayStr the array str
     * @return the string list by str
     */
    public static List<String> getStringListByStr(String arrayStr) {

        if (StringUtils.isNotEmpty(arrayStr)) {
            List<String> list = new ArrayList<>();
            String[] array = arrayStr.split(",");
            for (String s : array) {
                list.add(s);
            }
            return list;
        } else {
            return Collections.emptyList();
        }
    }
}
