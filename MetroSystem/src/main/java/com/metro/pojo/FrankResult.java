package com.metro.pojo;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Author:XARMIAN
 * @Date:2022/2/28
 * @Content:
 */
public class FrankResult<T> implements Serializable {

    private static final long serialVersionUID = 9191892693219217387L;
    public static final String RESP_CODE_SUCCESS = "00000000";
    public static final String RESP_MESG_SUCCESS = "success";
    private String code;
    private boolean success;
    private String message;
    private T data;

    public FrankResult() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static <T> FrankResult<T> success(T data) {
        FrankResult<T> result = new FrankResult();
        result.setCode("00000000");
        result.setMessage("success");
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> FrankResult<T> fail(String code, String message, T data) {
        FrankResult<T> result = new FrankResult();
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

    public static <T> FrankResult<T> fail(String code, String message) {
        FrankResult<T> result = new FrankResult();
        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(false);
        result.setData((T) null);
        return result;
    }
}
