package com.dc.framework.exception;

/**
 * 错误信息对象。
 */
public class ErrorInfo {
    
    private String code;
    private String message;
    private String detail;
    
    public ErrorInfo() {

    }
    
    public ErrorInfo(String code, String message, String detail) {

        super();
        this.code = code;
        this.message = message;
        this.detail = detail;
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
    
    public String getDetail() {

        return detail;
    }
    
    public void setDetail(String detail) {

        this.detail = detail;
    }
    
    public String toString() {

        return String.format("错误代码：%s\n错误信息：%s\n错误详细信息：%s\n", code, message, detail);
    }
}
