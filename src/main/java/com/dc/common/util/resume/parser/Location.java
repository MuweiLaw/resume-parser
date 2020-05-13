package com.dc.common.util.resume.parser;//package com.dc.common.util.resume.parser;
//
//
//import com.dc.common.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author wx
// * @version 1.0.0
// * @className Location
// * @description TODO
// * @date 2019/12/8 16:18
// */
//public class Location {
//    public static final List<String> LOCATIONS = new ArrayList<>();
//
//    public static String getOneLocation(String content){
//        List<String> locations = getAllLocation(content);
//        if( locations.size() > 0){
//            return locations.get(0);
//        }
//        return "";
//    }
//
//
//    public static String getAtMost3Location(String content){
//        List<String> locations = getAllLocation(content);
//        List<String> lt = locations.subList(0, locations.size() >= 3 ? 3:locations.size());
//        return StringUtils.collectionToDelimitedString(lt,"|","","");
//    }
//
//    private static List<String> getAllLocation(String content){
//        List<String> locations = new ArrayList<>();
//        for (int i = 0; i < LOCATIONS.size(); i++) {
//            if (content.contains(LOCATIONS.get(i))) {
//                locations.add(LOCATIONS.get(i));
//            }
//        }
//        return locations;
//    }
//    static {
//        LOCATIONS.add("深圳");
//        LOCATIONS.add("广州");
//        LOCATIONS.add("珠海");
//        LOCATIONS.add("汕头");
//        LOCATIONS.add("佛山");
//        LOCATIONS.add("韶关");
//        LOCATIONS.add("湛江");
//        LOCATIONS.add("肇庆");
//        LOCATIONS.add("江门");
//        LOCATIONS.add("茂名");
//        LOCATIONS.add("惠州");
//        LOCATIONS.add("梅州");
//        LOCATIONS.add("汕尾");
//        LOCATIONS.add("河源");
//        LOCATIONS.add("阳江");
//        LOCATIONS.add("清远");
//        LOCATIONS.add("东莞");
//        LOCATIONS.add("中山");
//        LOCATIONS.add("潮州");
//        LOCATIONS.add("揭阳");
//        LOCATIONS.add("云浮");
//    }
//
//}
