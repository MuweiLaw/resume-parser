package com.dc.common.base;

import com.dc.common.util.base.DataUtil;

/**
 * @author wx
 * @version v1.0.0
 * @className BaseException
 * @date 2019/12/14 19:29
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得逞信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class BaseException {

    /**
     * 失败
     */
    public static final String FAIL = "fail";

    /**
     * 重复调用
     */
    public static final String DUPLICATEKEY_CODE = "duplicateError";
    /**
     * 需要前端显示的异常
     */
    public static final String SHOW_ERROR= "showError";

    /**
     * 无法获取到锁
     */
    public static final String CANNOT_GET_LOCK = "getLockError";

    /**
     * 调用接口因网络原因失败
     */
    public static final String INVOKE_ERROR = "invokeError";

    private String code;
    private String message;

    public BaseException(String message) {
        super();
        this.message = message;
    }

    public BaseException(String message, String code) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        if (DataUtil.isEmpty(code)) {
            return FAIL;
        }
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

}
