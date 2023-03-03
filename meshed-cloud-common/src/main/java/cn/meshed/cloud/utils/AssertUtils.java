package cn.meshed.cloud.utils;


import com.alibaba.cola.exception.SysException;

/**
 * <h1>断言类</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class AssertUtils {


    /**
     * 断言工具 - 判断是否是真的
     * 如果不是真的抛出异常
     *
     * @param flag
     * @param msg
     * @return void
     */
    public  static void isTrue(Boolean flag, String msg){
        if(!flag){
            throw  new SysException(msg);
        }
    }

}
