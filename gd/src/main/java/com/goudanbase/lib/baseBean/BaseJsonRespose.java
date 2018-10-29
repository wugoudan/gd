package com.goudanbase.lib.baseBean;

import java.io.Serializable;

/**
 * Conpany:lhxy
 * Auther:wulog
 * Date: 2018/5/3
 * mail:wulog@outlook.com
 * Effect:
 */

public class BaseJsonRespose implements Serializable {
    private String code;
    private String data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseJsonRespose{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
