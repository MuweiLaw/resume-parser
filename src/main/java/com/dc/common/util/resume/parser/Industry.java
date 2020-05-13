package com.dc.common.util.resume.parser;//package com.dc.common.util.resume.parser;
//
//
//import com.dc.common.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * 行业
// */
//public class Industry {
//
//    public static List<String> industrys = new ArrayList<>();
//
//    public static String getIndustry(String content){
//        if(StringUtils.isBlank(content)){
//            return "";
//        }
//        Iterator<String> iterator = industrys.iterator();
//        StringBuilder industrySB = new StringBuilder();
//        List<String>  industry = new ArrayList<>();
//        for (int i = 0; i < industrys.size(); i++) {
//            if( content.contains(industrys.get(i))){
//                if( industry.size() > 3){
//                    break;
//                }
//                industry.add(industrys.get(i));
//            }
//        }
//        return StringUtils.collectionToDelimitedString(industry,"|","","");
//    }
//
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
//
//}
