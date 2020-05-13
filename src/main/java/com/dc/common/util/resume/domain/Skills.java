package com.dc.common.util.resume.domain;

import lombok.Data;
import lombok.ToString;


/**
 * @Description:技能/语言类
 * @author:MuweiLaw
 * @Date:2019/12/8 13:16
 */
@Data
@ToString
public class Skills {
    //    技能或证书名称
    private String skillOrCertificateName;
    //    技能水平
    private String skillProficiency;
    //    使用时间
    private String usageTime;
}
