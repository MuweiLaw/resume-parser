package com.dc.framework.web;

/**
 * @author wx
 * @version v1.0.0
 * @className ReturnResult
 * @description TODO
 * @date 2019/12/25 11:49
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class ReturnResult<T> {

    private Integer code;

    //返回信息
    private String msg;

    //返回数据
    private T data;


    public ReturnResult() {
        super();
    }


    /**
     * 不返回null，默认为成功
     * @param code
     * @param msg
     * @param data
     */
    public ReturnResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ReturnResult<T> getSuccessResult(T data){
        return new ReturnResult<T>(0, "操作成功", data);
    }

    public static <T> ReturnResult<T> getErrorResult(T data){
        return new ReturnResult<T>(1, "操作失败", data);
    }

    public static <T> ReturnResult<T> getErrorResult(String msg){
        return new ReturnResult<T>(1, msg, null);
    }

    public Integer getCode() {
        return code==null?0:1;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg==null?"":msg;
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
}
