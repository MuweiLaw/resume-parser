package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wx
 * @version v1.0.0
 * @className StringSplitParser
 * @description TODO
 * @date 2019/12/23 16:11
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class StringSplitParser extends BaseParser {

    public StringSplitParser(String html) {
        super(html);
    }

    public Resume tikaAnalyResume(Map<String, Object> map) throws Exception {
        List<TikaResumeModule> list = (List<TikaResumeModule>) map.get("moduleList");
        List<String> linList = (List<String>) map.get("linList");
        int resumeNumber = (int) map.get("resumeNumber");
        Resume resume = new Resume();
        BasicInfo personalInformationDTO = null;
        CareerObjective userJobIntentionDTO = null;
        List<WorkExperience> listWorkExperienceDTO = null;
        SelfEvaluation userIntroduceDTO = null;
        List<ProjectExperience> listProjectExperienceDTO = null;
        List<TikaResumeModule> listTikaResumeModuleExperienceDTO = null;
        return resume;
    }



    public static String matcherWorkYear(String phone){
        String regex = "\\d{2}年工作经验";
        Pattern p = Pattern.compile(regex);	//获取正则表达式
        Matcher m = p.matcher(phone);
        while(m.find()){
            return m.group();
        }
        return null;
    }

    public static String matcherPhone(String phone){
        String regex = "1[3456789]\\d{9}";
        Pattern p = Pattern.compile(regex);	//获取正则表达式
        Matcher m = p.matcher(phone);
        while(m.find()){
            return m.group();
        }
        return null;
    }

    public static String matcherEmail(String email){
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern p = Pattern.compile(regex);	//获取正则表达式
        Matcher m = p.matcher(email);
        while(m.find()){
            return m.group();
        }
        return null;
    }

    /**时间处理*/
    public String matcherDate2(String str){
        String regex = null;
        if(str.contains("至今")){
            regex = "\\d{4}年\\d+月--至今";
        } else{
            regex = "\\d{4}年\\d+月--\\d{4}年\\d+月";
        }
        Pattern p = Pattern.compile(regex);	//获取正则表达式
        Matcher m = p.matcher(str);
        if(m.find()){
            return m.group();
        }
        return null;
    }

    /**时间处理*/
    public String matcherDate(String str,String type){
        String regex = null;
        if(str.contains("至今")){
            regex = "20\\d{2}[/.]\\d+-*至今";
        } else if (str.indexOf("月") > 0 && str.indexOf("年") > 0 && "01".equals(type)) {
            regex = "\\d{4}年\\d{1,2}月(\\d{1,2}日){0,1}";
        }else{
            regex = "\\d{4}[/.]\\d+[-至]\\d{4}[/.]\\d{1,2}";
        }
        Pattern p = Pattern.compile(regex);	//获取正则表达式
        Matcher m = p.matcher(str);
        if(m.find()){
            return m.group();
        }
        return null;
    }

    public static void main(String[] args) {
        //String regex = RegexType.EMAIL.value();
        String regex = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";
        regex ="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern p = Pattern.compile(regex);	//获取正则表达式
        Matcher m = p.matcher("邮箱：uvwxylyc@126.com");
        while(m.find()){
            System.out.println("222:"+m.group());
        }


		/*String str = "2018/4-至今深圳易佰网络科技有限公司";
		//手机号码正则
		String regex = "20\\d{2}[/.]\\d+-至今";
		
		Pattern p = Pattern.compile(regex);	//获取正则表达式
		Matcher m = p.matcher(str);			//获取匹配器
		//boolean b1 = m.matches();//看是否能匹配(获取功能用不到)

		while(m.find()){//看是否能在字符串中找到符合正则表达式的字符串，找到返回true，同时指针指向下一个子序列
			String phone = m.group();			//必须先找再获取
			System.out.println(phone);
		}*/

    }


}
