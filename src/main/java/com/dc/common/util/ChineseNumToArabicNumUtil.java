package com.dc.common.util;

/**
 * @author wx
 * @version 1.0.0
 * @className ChineseNumToArabicNumUtil
 * @description 工具类，用于将汉语的数字转换为阿拉伯数字
 * @date 2019/12/9 10:44
 */
public class ChineseNumToArabicNumUtil {

    static char[] cnArr = new char [] {'一','二','三','四','五','六','七','八','九'};
    static char[] chArr = new char [] {'十','百','千','万','亿'};
    static String allChineseNum = "零一二三四五六七八九十百千万亿";

    /**
     * 将汉字中的数字转换为阿拉伯数字
     * @param chineseNum
     * @return
     */
    public static int chineseNumToArabicNum(String chineseNum) {
        int result = 0;
        int temp = 1;//存放一个单位的数字如：十万
        int count = 0;//判断是否有chArr
        for (int i = 0; i < chineseNum.length(); i++) {
            boolean b = true;//判断是否是chArr
            char c = chineseNum.charAt(i);
            for (int j = 0; j < cnArr.length; j++) {//非单位，即数字
                if (c == cnArr[j]) {
                    if(0 != count){//添加下一个单位之前，先把上一个单位值添加到结果中
                        result += temp;
                        temp = 1;
                        count = 0;
                    }
                    // 下标+1，就是对应的值
                    temp = j + 1;
                    b = false;
                    break;
                }
            }
            if(b){//单位{'十','百','千','万','亿'}
                for (int j = 0; j < chArr.length; j++) {
                    if (c == chArr[j]) {
                        switch (j) {
                            case 0:
                                temp *= 10;
                                break;
                            case 1:
                                temp *= 100;
                                break;
                            case 2:
                                temp *= 1000;
                                break;
                            case 3:
                                temp *= 10000;
                                break;
                            case 4:
                                temp *= 100000000;
                                break;
                            default:
                                break;
                        }
                        count++;
                    }
                }
            }
            if (i == chineseNum.length() - 1) {//遍历到最后一个字符
                result += temp;
            }
        }
        return result;
    }

    /**
     * @param intInput
     * @return
     */
    public static String arabicNumToChineseNum(int intInput) {
        String si = String.valueOf(intInput);
        String sd = "";
        if (si.length() == 1) {
            if (intInput == 0) {
                return sd;
            }
            sd += cnArr[intInput - 1];
            return sd;
        } else if (si.length() == 2) {
            if (si.substring(0, 1).equals("1")) {
                sd += "十";
                if (intInput % 10 == 0) {
                    return sd;
                }
            }
            else
                sd += (cnArr[intInput / 10 - 1] + "十");
            sd += arabicNumToChineseNum(intInput % 10);
        } else if (si.length() == 3) {
            sd += (cnArr[intInput / 100 - 1] + "百");
            if (String.valueOf(intInput % 100).length() < 2) {
                if (intInput % 100 == 0) {
                    return sd;
                }
                sd += "零";
            }
            sd += arabicNumToChineseNum(intInput % 100);
        } else if (si.length() == 4) {
            sd += (cnArr[intInput / 1000 - 1] + "千");
            if (String.valueOf(intInput % 1000).length() < 3) {
                if (intInput % 1000 == 0) {
                    return sd;
                }
                sd += "零";
            }
            sd += arabicNumToChineseNum(intInput % 1000);
        } else if (si.length() == 5) {
            sd += (cnArr[intInput / 10000 - 1] + "万");
            if (String.valueOf(intInput % 10000).length() < 4) {
                if (intInput % 10000 == 0) {
                    return sd;
                }
                sd += "零";
            }
            sd += arabicNumToChineseNum(intInput % 10000);
        }

        return sd;
    }

    /**
     * 判断传入的字符串是否全是汉字数字
     * @param chineseStr
     * @return
     */
    public static boolean isChineseNum(String chineseStr) {
        char [] ch = chineseStr.toCharArray();
        for (char c : ch) {
            if (!allChineseNum.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断数字字符串是否是整数字符串
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        String reg = "[0-9]+";
        return str.matches(reg);
    }

}
