package com.goudanbase.lib.baseBean;

import java.io.Serializable;

/**
 * Effect:封装服务器返回数据
 */

public class BaseRespose<T> implements Serializable {
    private String code;
    private String msg;

    private T data;

    public boolean success() {
        // TODO: 2017/4/13
        return "".equals("");
    }

    public BaseRespose(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
