package com.dc.common.util.resume.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Description:
 * @author:MuweiLaw
 * @Date:2020/1/9 10:40
 */
@Data
@ToString
public class Certificate {
    //    技能或证书名称
    private String CertificateName;
    //    证书日期
    private Date certificateDate;
    //    使用时间
    private String usageTime;
    //    证书成绩
    private String certificateGrade;
}
