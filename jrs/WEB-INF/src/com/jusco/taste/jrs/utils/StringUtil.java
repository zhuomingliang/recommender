package com.jusco.taste.jrs.utils;

import java.util.Collection;

public class StringUtil {
    public static String connectString(Collection<String> stringList, String split){
        StringBuilder builder = new StringBuilder();
        boolean flag = false;

        for (String string : stringList){
            if( flag ) {
                builder.append(split);
            } else {
                flag = true;
            }

            builder.append(string);
        }
        return builder.toString();
    }
}
