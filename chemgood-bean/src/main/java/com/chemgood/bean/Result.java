package com.chemgood.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuyi on 3/11/17.
 * 返回结果封装
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1965506956212287739L;

    public final static int OK = 1;
    public final static int FAILURE = 0;
    public final static int DBFAILURE = -1;

    private Integer resultCode;

    private String message;

    @SuppressWarnings("unchecked")
    private Map resultMap;

    private T obj;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public boolean isOK() {
        if (this.resultCode.equals(Result.OK)) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public Map getResultMap() {
        return resultMap;
    }

    @SuppressWarnings("unchecked")
    public void setResultMap(Map resultMap) {
        if (resultMap == null) {
            resultMap = new HashMap();
        }
        this.resultMap = resultMap;
    }

    @SuppressWarnings("unchecked")
    public void put(String key, Object value) {
        if (this.resultMap == null) {
            this.resultMap = new HashMap();
        }
        this.resultMap.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static Result succResult() {
        Result r = new Result();
        r.setResultCode(Result.OK);
        return r;
    }

    /**
     * 创建一个有料的成功结果
     * @param obj
     * @param <T>
     * @return
     */
    public static<T> Result<T> succResult(T obj) {
        Result<T> r = new Result<T>();
        r.setResultCode(Result.OK);
        r.setObj(obj);
        return r;
    }

    @SuppressWarnings("unchecked")
    public static Result errorResult(String message) {
        Result r = new Result();
        r.setResultCode(Result.FAILURE);
        r.setMessage(message);
        return r;
    }

    @SuppressWarnings({ "unchecked" })
    public static Result errorResult(String message, Result result) {
        if (null == result) {
            result = new Result();
        }
        result.setResultCode(Result.FAILURE);
        result.setMessage(message);
        return result;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", resultMap=" + resultMap +
                ", obj=" + obj +
                '}';
    }
}
