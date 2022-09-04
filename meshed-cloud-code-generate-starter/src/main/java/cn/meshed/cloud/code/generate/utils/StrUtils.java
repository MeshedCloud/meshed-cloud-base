package cn.meshed.cloud.code.generate.utils;

/**
 * <h1></h1>
 *
 * @author hougq
 * @version 1.0
 */
public class StrUtils {


    public static String convertInitialUpper(String val){
        return val.substring(0,1).toUpperCase() + val.substring(1);
    }

    public static String convertInitialLower(String val){
        return val.substring(0,1).toLowerCase() + val.substring(1);
    }
}
