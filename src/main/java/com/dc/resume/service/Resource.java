
package com.dc.resume.service;

import com.dc.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;

/**
 * @Description: 职位/职能/专业的资源类
 * @ClassName: Resource
 * @Version:
 * @Author: Murray Law
 * @Date 2020/1/9 18:08
 */
@Service("resource")
public class Resource {
    @Autowired
    private UserJobService userJobService;
    @Autowired
    private UserMajorService userMajorService;
    @Autowired
    private UserIndustryService userIndustryService;
    @Autowired
    private UserLocationService userLocationService;
    private static Map<String, String> jobTitles = new HashMap<>();
    private static Map<String, String> marjorMap = new HashMap<>();
    public static List<String> industrys = new ArrayList<>();
    public static List<String> locations = new ArrayList<>();


    @PostConstruct
    public void init() {
        System.out.println("系统启动中。。。加载职位,专业等信息");
        userJobService.addJobTitles(jobTitles);
        userMajorService.addMarjorMap(marjorMap);
        userIndustryService.addIndustrys(industrys);
        userLocationService.addLocations(locations);
    }


    public static String getJobTitles(String jobTitle) {
        return getString(jobTitle, jobTitles);
    }

    public static String getMajor(String content) {
        return getString(content, marjorMap);
    }


    public static String getJobFunction(String jobTitle) {
        Map.Entry<String, String> entry = null;
        Iterator<Map.Entry<String, String>> iterator = jobTitles.entrySet().iterator();
        while (iterator.hasNext()) {
            entry = iterator.next();
            if (jobTitle.toLowerCase().contains(entry.getKey().toLowerCase())) {
                return entry.getValue();
            }
        }
        return "";
    }

    public static String getOneLocation(String content) {
        List<String> locations = getAllLocation(content);
        if (locations.size() > 0) {
            return locations.get(0);
        }
        return "";
    }


    public static String getAtMost3Location(String content) {
        List<String> locations = getAllLocation(content);
        List<String> lt = locations.subList(0, locations.size() >= 3 ? 3 : locations.size());
        return StringUtils.collectionToDelimitedString(lt, "|", "", "");
    }

    private static List<String> getAllLocation(String content) {
        List<String> locations = new ArrayList<>();
        for (int i = 0; i < locations.size(); i++) {
            if (content.contains(locations.get(i))) {
                locations.add(locations.get(i));
            }
        }
        return locations;
    }

    public static String getIndustry(String content) {
        if (StringUtils.isBlank(content)) {
            return "";
        }
        Iterator<String> iterator = industrys.iterator();
        StringBuilder industrySB = new StringBuilder();
        List<String> industry = new ArrayList<>();
        for (int i = 0; i < industrys.size(); i++) {
            if (content.contains(industrys.get(i))) {
                if (industry.size() > 3) {
                    break;
                }
                industry.add(industrys.get(i));
            }
        }
        return StringUtils.collectionToDelimitedString(industry, "|", "", "");
    }

    private static String getString(String jobTitle, Map<String, String> jobTitles) {
        String job = "";
        Iterator<String> iterator = jobTitles.keySet().iterator();
        while (iterator.hasNext()) {
            job = iterator.next();
            if (jobTitle.toLowerCase().contains(job.toLowerCase())) {
                return job;
            }
        }
        return "";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("系统运行结束");
    }
//    static {
//        marjorMap.put("电子信息工程", "电子信息工程");
//        marjorMap.put("计算机科学与技术", "计算机科学与技术");
//        marjorMap.put("电气工程及其自动化", "电气工程及其自动化");
//        marjorMap.put("通信工程", "通信工程");
//        marjorMap.put("电子科学与技术", "电子科学与技术");
//        marjorMap.put("集成电路设计与集成系统", "集成电路设计与集成系统");
//        marjorMap.put("计算机科学", "计算机科学");
//        marjorMap.put("计算机工程", "计算机工程");
//        marjorMap.put("计算机网络", "计算机网络");
//        marjorMap.put("计算机应用", "计算机应用");
//        marjorMap.put("软件工程", "软件工程");
//        marjorMap.put("软件技术", "软件技术");
//        marjorMap.put("计算机信息管理", "计算机信息管理");
//        marjorMap.put("网络工程", "网络工程");
//        marjorMap.put("计算机辅助设计", "计算机辅助设计");
//        marjorMap.put("机械设计制造及其自动化", "机械设计制造及其自动化");
//        marjorMap.put("机械电子工程/机电一体化", "机械电子工程/机电一体化");
//        marjorMap.put("机械工程及自动化", "机械工程及自动化");
//        marjorMap.put("机械制造工艺与设备", "机械制造工艺与设备");
//        marjorMap.put("制造自动化与测控技术", "制造自动化与测控技术");
//        marjorMap.put("材料成型及控制工程", "材料成型及控制工程");
//        marjorMap.put("过程装备与控制工程", "过程装备与控制工程");
//        marjorMap.put("模具设计与制造", "模具设计与制造");
//        marjorMap.put("微机电系统工程", "微机电系统工程");
//        marjorMap.put("车辆工程", "车辆工程");
//        marjorMap.put("建筑工程", "建筑工程");
//        marjorMap.put("道路与桥梁", "道路与桥梁");
//        marjorMap.put("工业与民用建筑", "工业与民用建筑");
//        marjorMap.put("工程造价管理", "工程造价管理");
//        marjorMap.put("建筑环境与设备工程", "建筑环境与设备工程");
//        marjorMap.put("艺术设计", "艺术设计");
//
//    }
//    static{
//        industrys.add("互联网");
//        industrys.add("游戏");
//        industrys.add("多媒体");
//        industrys.add("广告营销");
//        industrys.add("数据服务");
//        industrys.add("社交网络");
//        industrys.add("医疗健康");
//        industrys.add("生活服务");
//        industrys.add("O2O");
//        industrys.add("音乐/视频/阅读");
//        industrys.add("在线教育");
//        industrys.add("电子商务");
//        industrys.add("电子通讯");
//        industrys.add("人力资源");
//        industrys.add("企业服务");
//        industrys.add("信息安全");
//        industrys.add("新零售");
//        industrys.add("智能硬件");
//        industrys.add("区块链");
//        industrys.add("人工智能");
//        industrys.add("计算机软件");
//        industrys.add("计算机硬件");
//        industrys.add("计算机服务");
//        industrys.add("通信/网络设备");
//        industrys.add("运营商/增值服务");
//        industrys.add("电子/半导体/集成电路");
//        industrys.add("移动互联网");
//        industrys.add("网游");
//        industrys.add("web前端开发工程师");
//        industrys.add("游戏测试");
//        industrys.add("软件测试");
//        industrys.add("系统测试");
//    }
//static {
//    LOCATIONS.add("深圳");
//    LOCATIONS.add("广州");
//    LOCATIONS.add("珠海");
//    LOCATIONS.add("汕头");
//    LOCATIONS.add("佛山");
//    LOCATIONS.add("韶关");
//    LOCATIONS.add("湛江");
//    LOCATIONS.add("肇庆");
//    LOCATIONS.add("江门");
//    LOCATIONS.add("茂名");
//    LOCATIONS.add("惠州");
//    LOCATIONS.add("梅州");
//    LOCATIONS.add("汕尾");
//    LOCATIONS.add("河源");
//    LOCATIONS.add("阳江");
//    LOCATIONS.add("清远");
//    LOCATIONS.add("东莞");
//    LOCATIONS.add("中山");
//    LOCATIONS.add("潮州");
//    LOCATIONS.add("揭阳");
//    LOCATIONS.add("云浮");
//}

}
