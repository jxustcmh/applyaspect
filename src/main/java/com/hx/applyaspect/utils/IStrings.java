package com.hx.applyaspect.utils;

/**
 * created by Allen.Huang on 2019/7/3
 */
public class IStrings {

    public static String splice(Object... obj) {
        if (obj != null) {
            StringBuilder sb = new StringBuilder(obj.length);
            for (Object o : obj) {
                sb.append(o);
            }
            return sb.toString();
        }
        return "";
    }

}
