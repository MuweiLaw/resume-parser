package com.dc.common.util.base;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class NetworkUtils {

	public static List<String> getLocalIp(){
		List<String> ipList = new ArrayList<String>();
		try{
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();  
		    while (interfaces.hasMoreElements()) {  
		        NetworkInterface ni = interfaces.nextElement();  
		        for (InterfaceAddress address : ni.getInterfaceAddresses()) { 
		            if (address.getAddress() instanceof Inet4Address) { 
		                Inet4Address inet4Address = (Inet4Address) address.getAddress();
		                ipList.add(inet4Address.getHostAddress());
		            }
		        }
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return ipList;
	}
	
	
	/**
     * 
     * 功能描述：获取真实的IP地址
     * @param request
     * @return
     * @author guoyx
     */
    public static String getIpAddr(HttpServletRequest request)
    {
        //通过前端的负载均衡服务器时，请求对象中的IP会变成负载均衡服务器的IP，因此需要特殊处理，下同。
        String X_REAL_IP = "X-Real-IP";
        String X_FORWARDED_FOR = "X-Forwarded-For";

        String remoteIp = request.getHeader(X_FORWARDED_FOR);//apache反射代理
        if (StringUtils.isNotBlank(remoteIp)) {
        	String[] ips = remoteIp.split(",");
            for (String ip : ips) {
                if (!"null".equalsIgnoreCase(ip)) {
                    return ip;
                }
            }
        } else {
            remoteIp = request.getHeader(X_REAL_IP); //nginx反向代理
            if(StringUtils.isNotBlank(remoteIp)) {
            	return remoteIp;
            }
        }
        return request.getRemoteAddr();
    }
}
