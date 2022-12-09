package com.lu.workManageSystem.exceptions;

/**
 * @ClassName: LoginsException
 * @Description:
 * @Author: luning
 * @Date: 2021/11/8 14:46
 * @Version: v1.0
 */
public class LoginsException extends Exception{


    private final Integer code = 300;

    private String message="";

    public LoginsException(){
        super();
    }
    public LoginsException(String msg) {
        super(msg);
        this.message=msg;
    }
    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }
}
