package com.lu.workManageSystem.utils;

/**
 * @ClassName: ResultInfo
 * @Description:
 * @Author: luning
 * @Date: 2021/11/8 15:01
 * @Version: v1.0
 */

public class ResultInfo {


    Integer code = 200;
    String message;
    Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
