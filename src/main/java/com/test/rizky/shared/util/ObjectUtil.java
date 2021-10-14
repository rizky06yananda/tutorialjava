package com.test.rizky.shared.util;


public class ObjectUtil {
    @SuppressWarnings("rawtypes")
    public static boolean isExist(Object object){
        if (object != null){
            return true;
        }else {
            return false;
        }
    }
}
