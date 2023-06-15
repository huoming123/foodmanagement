package com.design.foodmanagement.pojo.res;

public class RestFulBean<T> {

    private int status;
    private T data;
    private String msg;

    public static <R>RestFulBean<R> error(Code code, String message) {
        return RestFulBean.error(code.code,message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <R> RestFulBean<R> succ(String msg, R data) {
        RestFulBean<R> rest = new RestFulBean<>();
        rest.setData(data);
        rest.setStatus(2000);
        return rest;
    }

    public static <R> RestFulBean<R> succ(R data) {
        return succ("", data);
    }
    public static <R> RestFulBean<R> succ(Code code,String message) {
        RestFulBean<R> rest = new RestFulBean<>();
        rest.setMsg(message);
        rest.setData(null);
        rest.setStatus(code.code);
        return rest;
    }


    public static RestFulBean error(Exception ex) {
        return RestFulBean.error("读出数据出错,错误为:" + ex.getLocalizedMessage());
    }

    public static RestFulBean error(String msg) {
        return RestFulBean.error(5000, msg, null);
    }

    public static RestFulBean error(String msg, Object data) {
        return RestFulBean.error(5000, msg, data);
    }

    public static RestFulBean error(int code, String msg) {
        return RestFulBean.error(code, msg, null);
    }

    public static RestFulBean error(Code code, String msg, Object data) {
        return RestFulBean.error(code.code,msg,data);
    }

    public static RestFulBean error(int code, String msg, Object data) {
        RestFulBean rest = new RestFulBean();
        rest.setData(data);
        rest.setMsg(msg);
        rest.setStatus(code);
        return rest;
    }
}
