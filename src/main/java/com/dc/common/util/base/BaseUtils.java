package com.dc.common.util.base;

import com.dc.common.constants.UserInfoExpireTime;
import com.dc.common.util.StringUtils;
import com.dc.framework.lang.Strings;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class BaseUtils {

    //判断该请求是否是APP请求
    public static boolean requestIsMobile(HttpServletRequest request ){
        if(request==null) return false;
        String user_agent = request.getHeader("user-agent");
        if(Strings.isEmpty(user_agent)) return false;
        String userAgent = user_agent.toLowerCase();
        if(userAgent.contains("android" ) || userAgent.contains("iphone"))
        {
            return true;
        }
        return false;
    }

    //获取用户缓存过期时间(APP请求和PC端不同)
    public static AtomicLong getUserInfoCacheExpireTime(HttpServletRequest request) {
        AtomicLong expireTime = new AtomicLong(UserInfoExpireTime.DEFAULT_USER_INFO_EXPIRE_TIME);
        if(BaseUtils.requestIsMobile(request)){
            expireTime.set(UserInfoExpireTime.APP_USER_INFO_EXPIRE_TIME);
        }else {
            expireTime.set(UserInfoExpireTime.PC_USER_INFO_EXPIRE_TIME);
        }
        return expireTime;
    }

    //通过请求获取用户token
    public static String getUserTokenFromHeader(HttpServletRequest request,String headerName) {
        String token = request.getHeader(headerName);
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(headerName);
        }
        return token;
    }
}
