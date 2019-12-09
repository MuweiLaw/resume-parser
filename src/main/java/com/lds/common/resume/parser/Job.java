
package com.lds.common.resume.parser;

import java.util.*;

/**
 * 职位
 */
public class Job {

    private static Map<String,String> jobTitles = new HashMap();

    static {
        jobTitles.put("Java开发工程师","Java");
        jobTitles.put("软件测试工程师","测试工程师");
        jobTitles.put("UI设计","UI");
        jobTitles.put("商务助理","商务助理");
        jobTitles.put("网格优化员","网格优化员");
        jobTitles.put("web前端开发工程师","web前端开发工程师");

    }

    public static String getJobTitles(String jobTitle){
        String job = "";
        Iterator<String> iterator = jobTitles.keySet().iterator();
        while (iterator.hasNext()){
            job = iterator.next();
            if( jobTitle.toLowerCase().contains(job.toLowerCase())){
                return job;
            }
        }
        return "";
    }

    public static String getJobFunction(String jobTitle){
        Map.Entry<String,String> entry = null;
        Iterator<Map.Entry<String,String>> iterator = jobTitles.entrySet().iterator();
        while (iterator.hasNext()){
            entry = iterator.next();
            if( jobTitle.toLowerCase().contains(entry.getKey().toLowerCase())){
                return entry.getValue();
            }
        }
        return "";
    }
}
