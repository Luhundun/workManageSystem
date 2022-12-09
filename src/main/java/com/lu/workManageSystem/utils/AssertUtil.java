package com.lu.workManageSystem.utils;



import com.lu.workManageSystem.exceptions.LoginsException;


/**
 * @ClassName: AssertUtil
 * @Description:
 * @Author: luning
 * @Date: 2021/11/8 13:36
 * @Version: v1.0
 */
public class AssertUtil {


    //如果错误抛出参数异常
    public static void isTureForLogin(Boolean flag, String msg) throws Exception {
        if(flag){
            throw new LoginsException(msg);
        }
    }
}
