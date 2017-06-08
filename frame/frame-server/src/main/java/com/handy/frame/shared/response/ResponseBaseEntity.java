package com.handy.frame.shared.response;

import java.io.Serializable;

/**
 * @author lhr
 * @create 2016/12/12 10:12
 */
public class ResponseBaseEntity<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private boolean success;

    private String code;

    private String message;

    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
