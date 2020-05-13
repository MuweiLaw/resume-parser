package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.Certificate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 证书解析类
 * @author:MuweiLaw
 * @Date:2019/12/8 13:27
 */

public class CertificateParser extends BaseParser {
    public CertificateParser(String content) {
        super(content);
    }

    public List<Certificate> parse() {
        ArrayList<Certificate> list = new ArrayList<>();
        getCertificatceElesWithZhiLian(list);
        getCertificatceElesWith51Job(list);
        getCertificatceElesWithRenCai(list);
        return list;
    }

    //获取51job的证书列表
    private void getCertificatceElesWith51Job(ArrayList<Certificate> list) {
        //找到51job的技能特长模块全部元素
        Elements skills51Eles = root.getElementsMatchingOwnText("^技能特长$");
        if (skills51Eles.size() > 0 && skills51Eles.first().getElementsByAttributeValue("class", "plate1").size() > 0) {
            Element educationEleParent = skills51Eles.first().parent().nextElementSibling();
//            Elements skillOrCertificateNameEle = educationEleParent.getElementsByAttributeValue("style", "text-align:right;width:120px;font-size:13px;font-weight:bold;color:#666;word-break:break-all;");
//            Elements skillProficiencyEle = educationEleParent.getElementsByAttributeValue("class", "skco");
            Elements certificateEles = educationEleParent.getElementsMatchingOwnText("\\d{4,4}/\\d{1,2}");
            if (certificateEles.size() > 0) {
                if (educationEleParent.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}-\\d{2,4}/\\d{1,2}").size() == 0) {
                    certificateEles.stream().forEach(element -> {
                        Certificate certificate = new Certificate();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
                        String s = element.text();
                        try {
                            certificate.setCertificateDate(sdf.parse(s));

                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }

                        String[] arr = element.nextElementSibling().text().split(" （");
                        certificate.setCertificateName(arr[0]);
                        if (arr.length == 2) {
                            certificate.setCertificateGrade(arr[1].replace("）", ""));
                        }
                        list.add(certificate);
                    });
                }
            }
        }
    }

    //获取人才的证书列表
    private void getCertificatceElesWithRenCai(ArrayList<Certificate> list) {
        //找到人才热线的获得证书模块全部元素
        Elements renCaiCertificatCeEles = root.getElementsMatchingOwnText("^获得证书$");

        //人才热线证书
        if (renCaiCertificatCeEles.size() > 0) {
            Elements elements = renCaiCertificatCeEles.first().parent().nextElementSibling().getElementsByAttributeValue("style", "font:12px/20px Arial; color:#333333;");
            if (elements.size() > 0) {
                elements.stream().forEach(element -> {
                    Certificate certificate = new Certificate();
                    String[] arr = element.text().split(" ");
                    certificate.setCertificateName(arr[0]);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
                    try {
                        certificate.setCertificateDate(sdf.parse(arr[1]));
                    } catch (ParseException e) {
                        System.out.println(e.getMessage());
                    }
                    list.add(certificate);
                });
            }
        }
    }

    //获取智联,卓聘的证书列表
    private void getCertificatceElesWithZhiLian(ArrayList<Certificate> list) {
        //找到智联/卓聘证书模块全部元素
        Elements zhiLianCertificatCeEles = root.getElementsMatchingOwnText("^证书$");
        //获取智联和卓聘的证书列表
        if (zhiLianCertificatCeEles.size() > 0) {
            if (zhiLianCertificatCeEles.first().getElementsByAttributeValue("style", "font-size:15.0pt;font-family:宋体;mso-ascii-font-family:\n" +
                    "Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:\n" +
                    "minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;\n" +
                    "background:#D9D9D9;mso-shading:white;mso-pattern:gray-15 auto").size() > 0 || zhiLianCertificatCeEles.first().getElementsByAttributeValue("style", "font-size:15.0pt;font-family:宋体;mso-ascii-font-family:\r\n" +
                    "Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:\r\n" +
                    "minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;\r\n" +
                    "background:#D9D9D9;mso-shading:white;mso-pattern:gray-15 auto").size() > 0) {
                Element zhiLianCertificatCeEle = zhiLianCertificatCeEles.first().parent().parent().nextElementSibling();
                //智联
                zhiLianCertificatCeEles = zhiLianCertificatCeEle.getElementsByAttributeValue("style", "font-size:9.0pt;font-family:\n" +
                        "  宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:\n" +
                        "  宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;\n" +
                        "  mso-hansi-theme-font:minor-latin");
                zhiLianCertificatCeEles.stream().forEach(certificatCeEle -> {
                    listAdd(list, certificatCeEle);
                });
                //智联1
                zhiLianCertificatCeEles = zhiLianCertificatCeEle.getElementsByAttributeValue("style", "font-size:9.0pt;font-family:\r\n" +
                        "  宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:\r\n" +
                        "  宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;\r\n" +
                        "  mso-hansi-theme-font:minor-latin");
                zhiLianCertificatCeEles.stream().forEach(certificatCeEle -> {
                    listAdd(list, certificatCeEle);
                });
            } else {
                //卓聘
                if (zhiLianCertificatCeEles.first().getElementsByAttributeValue("face", "宋体").size() > 0) {
                    Element zhuoPinCertificatCeEle = zhiLianCertificatCeEles.first().parent().parent().parent().nextElementSibling();
                    while ("table".equals(zhuoPinCertificatCeEle.tagName())) {
                        listAdd(list, zhuoPinCertificatCeEle);
                        zhuoPinCertificatCeEle = zhuoPinCertificatCeEle.nextElementSibling().nextElementSibling();
                        if (null == zhuoPinCertificatCeEle) {
                            break;
                        }
                    }
                }
            }
        }
    }

    //智联添加元素进入列表
    private void listAdd(ArrayList<Certificate> list, Element zhuoPinCertificatCeEle) {
        String[] arr = zhuoPinCertificatCeEle.text().split(" ");
        Certificate certificate = new Certificate();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
            certificate.setCertificateDate(sdf.parse(arr[0]));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        certificate.setCertificateName(arr[1]);
        list.add(certificate);
    }

}