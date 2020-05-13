package com.dc.resume.service;

import com.alibaba.fastjson.JSONObject;
import com.dc.common.constants.ResumePrivacyStatusConstants;
import com.dc.common.domain.*;
import com.dc.common.util.ResumeParseUtils;
import com.dc.common.util.StringUtils;
import com.dc.common.util.base.Keygenerator;
import com.dc.common.util.resume.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author wx
 * @version 1.0.0
 * @className ResumeParseService
 * @description 简历解析服务类
 * @date 2019/12/14 16:25
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳龙得水信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Service("resumeParseService")
public class ResumeParseService {

    private static final Logger log = LoggerFactory.getLogger(ResumeParseService.class);

    @Autowired
    private UserSkillsService userSkillsService;
    @Autowired
    private UserCertificatesService userCertificatesService;
    @Autowired
    private UserIntentionService userIntentionService;
    @Autowired
    private UserResumeDetailService userResumeDetailService;
    @Autowired
    private UserProjectExperienceService userProjectExperienceService;
    @Autowired
    private UserEducationExperienceService userEducationExperienceService;
    @Autowired
    private UserWorkExperienceService userWorkExperienceService;

    @Autowired
    private UserResumeService userResumeService;

    @Autowired
    private RabbitTemplate rabbitTeamplate;

    @Value("${rabbitmq.queue.routing-key}")
    private String key;

    @Value("${rabbitmq.exchange.topic}")
    private String exchange;

    /**
     * 解析简历
     *
     * @param in
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String parseResume(InputStream in) throws Exception {
        Resume resume = ResumeParseUtils.parseResume(in);
        String resumeId = null;
        String userId = null;
        String phone = resume.getPhone();
        String name = resume.getName();
        if (StringUtils.isBlank(phone)) {
            return "手机号码为空";
        }
        if (StringUtils.isBlank(name)) {
            return "姓名为空";
        }
        log.info("parseResume : %s", resume);
        try {
            //判断是否存在
            List<UserResumeDetail> detailList = userResumeDetailService.findListByPhoneNoAndName(resume.getPhone(), resume.getName());
            UserResumeDetail userResumeDetail = null;
            if (detailList.size() > 0) {
                userResumeDetail = detailList.get(0);
                resumeId = userResumeDetail.getResumeId();
                userId = userResumeDetail.getUserId();
                UserResume userResume0 = new UserResume();
                userResume0.setUpdatedBy("parser");
                userResume0.setResumeUpdateTime(new Date());
                userResume0.setResumeId(resumeId);
                userResumeService.update(userResume0);
                //删除旧数据
                deleteResume(resume, userResumeDetail);
            } else {
                UserResume userResume = new UserResume();
                userId = Keygenerator.generateUUID();
                resumeId = Keygenerator.generateRequestNo();
                buildBaseInfoData(resume, userResume, userId, resumeId);
                userResumeService.insert(userResume);
            }
            //插入简历基本信息
            insertResumeDetail(resume, userId, resumeId);
            //插入项目经验
            insertProjectExperiences(resume, userId, resumeId);
            //插入工作经验
            insertWorkExperiences(resume, userId, resumeId);
            //插入教育经历
            insertEducations(resume, userId, resumeId);
            //插入求职意向
            insertIntention(resume, userId, resumeId);
            //插入技能
            insertSkill(resume, userId, resumeId);
            //插入证书
            insertCertificate(resume, userId, resumeId);
            //发送注册用户的消息
            sendUserRigister(resume.getPhone());
        } catch (Exception e) {
            throw new Exception("简历解析异常,message=" + e.getMessage(), e);
        }

        return resumeId;
    }

    private void deleteResume(Resume resume, UserResumeDetail userResumeDetail) {
        List<Skills> listBySkills = resume.getSkills();
        List<Certificate> listByCertificate = resume.getCertificate();
        //更新简历基本信息
        userResumeDetailService.delete(getUserResumeDetail(resume, userResumeDetail.getUserId(), userResumeDetail.getResumeId()));
        //删除技能信息
        if (listBySkills.size() > 0) {
            userSkillsService.delete(getUserSkills(listBySkills.get(0), userResumeDetail.getUserId(), userResumeDetail.getResumeId()));
        }
        //删除证书信息
        if (listByCertificate.size() > 0) {
            userCertificatesService.delete(getUserCertificates(listByCertificate.get(0), userResumeDetail.getUserId(), userResumeDetail.getResumeId()));
        }
        //删除教育经历
        List<Education> listByEducation = resume.getEducations();
        if (listByEducation.size() > 0) {
            //删除
            userEducationExperienceService.delete(getUserEducationExperience(listByEducation.get(0), userResumeDetail.getUserId(), userResumeDetail.getResumeId()));
        }
        //删除求职意向
        userIntentionService.delete(getUserIntention(resume, userResumeDetail.getUserId(), userResumeDetail.getResumeId()));
        //删除项目经历
        List<ProjectExperience> listByProjectExperience = resume.getProjectExperiences();
        if (listByProjectExperience.size() > 0) {
            userProjectExperienceService.delete(getUserProjectExperience(listByProjectExperience.get(0), userResumeDetail.getUserId(), userResumeDetail.getResumeId()));
        }
        //更新工资经验
        List<WorkExperience> listByWorkExperience = resume.getWorkExperiences();
        if (listByWorkExperience.size() > 0) {
            userWorkExperienceService.delete(getUserWorkExperience(listByWorkExperience.get(0), userResumeDetail.getUserId(), userResumeDetail.getResumeId()));
        }
    }

    private void buildBaseInfoData(Resume resume, UserResume userResume, String userId, String resumeId) {
        userResume.setUserId(userId);
        userResume.setResumeId(resumeId);
        userResume.setResumeUpdateTime(new Date());
        userResume.setDelete("N");
        userResume.setResumeName(resume.getName());
        userResume.setIsPublished("Y");
        userResume.setIsDefault("Y");
        userResume.setPrivacyPolicy(ResumePrivacyStatusConstants.RESUME_PRIVACY_STATUS_PUBLIC);
        userResume.setCreatedBy("parser");
        userResume.setUpdatedBy("parser");
        userResume.setSnapshotId(Keygenerator.generateIdWithPrefix("SNAP-"));
    }

    //注册用户
    private void sendUserRigister(String phone) {
        JSONObject dataJSON = new JSONObject();
        dataJSON.put("phone", phone);
        rabbitTeamplate.convertAndSend(exchange, key, dataJSON.toJSONString());
        log.info("MQ发送消息注册用户,用户手机号:" + phone);
    }

    //插入项目经历
    private void insertProjectExperiences(Resume resume, String userId, String resumeId) {
        resume.getProjectExperiences().forEach(pE -> {
            UserProjectExperience uPE = getUserProjectExperience(pE, userId, resumeId);
            userProjectExperienceService.insert(uPE);
        });
    }

    //插入工作经历
    private void insertWorkExperiences(Resume resume, String userId, String resumeId) {
        resume.getWorkExperiences().forEach(wE -> {
            UserWorkExperience uWE = getUserWorkExperience(wE, userId, resumeId);
            userWorkExperienceService.insert(uWE);
        });
    }

    //插入用户基本信息
    private void insertResumeDetail(Resume resume, String userId, String resumeId) {
        UserResumeDetail uRD = getUserResumeDetail(resume, userId, resumeId);
        userResumeDetailService.insert(uRD);
    }

    //插入求职意向
    private void insertIntention(Resume resume, String userId, String resumeId) {
        UserIntention uI = getUserIntention(resume, userId, resumeId);
        userIntentionService.insert(uI);
    }

    //插入技能
    private void insertSkill(Resume resume, String userId, String resumeId) {
        resume.getSkills().forEach(skills -> {
            userSkillsService.insert(getUserSkills(skills, userId, resumeId));
        });
    }

    //插入证书
    private void insertCertificate(Resume resume, String userId, String resumeId) {
        resume.getCertificate().forEach(certificate -> {
            userCertificatesService.insert(getUserCertificates(certificate, userId, resumeId));
        });
    }

    //获取简历基本信息
    private UserResumeDetail getUserResumeDetail(Resume resume, String userId, String resumeId) {
        UserResumeDetail uRD = new UserResumeDetail();
        uRD.setResumeId(resumeId);
        uRD.setUserId(userId);
        uRD.setRealName(resume.getName());
        uRD.setPhoneNo(resume.getPhone());
        uRD.setBirthday(resume.getBirthday());
        uRD.setMaritalStatus(resume.getMaritalStatus());
        uRD.setEmail(resume.getMail());
        uRD.setJobStatus(resume.getJobStatus());
        uRD.setHeight(resume.getHeight());
        uRD.setResidentialAddress(resume.getCurrentLocation());
        uRD.setHomeAddress(resume.getRegisterResidency());
        uRD.setWorkingYears(resume.getYearOfWorkExperience());
        uRD.setSex(resume.getSex());
        uRD.setSelfDescription(resume.getSelfEvaluation().getSelfEvaluation());
        uRD.setBasePay(resume.getBasePay());
        uRD.setAnnualIncome(resume.getAnnualIncome());
        uRD.setAllowance(resume.getAllowance());
        uRD.setCommission(resume.getCommission());

        uRD.setCreatedBy("parser");
        uRD.setUpdatedBy("parser");
        return uRD;
    }

    //获取用户技能
    private UserSkills getUserSkills(Skills skills, String userId, String resumeId) {
        UserSkills userSkills = new UserSkills();
        userSkills.setResumeId(resumeId);
        userSkills.setUserId(userId);
        userSkills.setSkillId(Keygenerator.generateRequestNo());
        userSkills.setSkillLevel(skills.getSkillProficiency());
        userSkills.setSkill(skills.getSkillOrCertificateName());
//                userSkills.setWorkExpId(workExpId);
        userSkills.setCreatedBy("parser");
        userSkills.setUpdatedBy("parser");
        return userSkills;
    }

    //获取用户证书
    private UserCertificates getUserCertificates(Certificate certificate, String userId, String resumeId) {
        UserCertificates userCertificates = new UserCertificates();
        userCertificates.setResumeId(resumeId);
        userCertificates.setUserId(userId);
        userCertificates.setCertificateId(Keygenerator.generateRequestNo());
        userCertificates.setCertificate(certificate.getCertificateName());
        userCertificates.setCreatedBy("parser");
        userCertificates.setUpdatedBy("parser");
        userCertificates.setGainDate(certificate.getCertificateDate());
        if (null != certificate.getCertificateGrade()) {
            userCertificates.setLevel(certificate.getCertificateGrade());
        } else {
            if (null != certificate.getUsageTime()) {
                userCertificates.setLevel(certificate.getUsageTime());
            } else {
                if (null != certificate.getCertificateDate()) {
                    userCertificates.setLevel((double) ((new Date().getTime() - certificate.getCertificateDate().getTime()) / (24 * 60 * 60 * 1000) / 30) + "个月");
                } else {
                    userCertificates.setLevel("其他");
                }
            }
        }
        return userCertificates;
    }

    //获取用户教育经历
    private UserEducationExperience getUserEducationExperience(Education EE, String userId, String resumeId) {
        UserEducationExperience uEE = new UserEducationExperience();
        uEE.setResumeId(resumeId);
        uEE.setUserId(userId);
        uEE.setEducationExpId(Keygenerator.generateRequestNo());
        uEE.setBeginDate(EE.getStartDate());
        uEE.setEndDate(EE.getEndDate());
        uEE.setSchoolName(EE.getUniversity());
        uEE.setSpecialty(EE.getMajor());
        uEE.setSpecialtyDescription(EE.getDescription());
        uEE.setEducationLevel(EE.getDegree());
        uEE.setCreatedBy("parser");
        uEE.setUpdatedBy("parser");
        return uEE;
    }

    //获取用户求职意向
    private UserIntention getUserIntention(Resume resume, String userId, String resumeId) {
        CareerObjective careerObjective = resume.getCareerObjective();
        UserIntention uI = new UserIntention();
        uI.setResumeId(resumeId);
        uI.setUserId(userId);
        uI.setExpectSalary(careerObjective.getExpectingSalary());
        uI.setWorkAddress(careerObjective.getExpectingLocation());
        uI.setWorkPosition(careerObjective.getExpectingPosition());
        uI.setIndustry(careerObjective.getExpectingIndustry());
        uI.setWorkType(careerObjective.getJobType());
        uI.setCreatedBy("parser");
        uI.setUpdatedBy("parser");
        return uI;
    }

    //获取用户的项目经历
    private UserProjectExperience getUserProjectExperience(ProjectExperience pE, String userId, String resumeId) {
        UserProjectExperience uPE = new UserProjectExperience();
        uPE.setResumeId(resumeId);
        uPE.setUserId(userId);
        uPE.setProjectExpId(Keygenerator.generateRequestNo());
        uPE.setBeginDate(pE.getBeginDate());
        uPE.setEndDate(pE.getEndDate());
        uPE.setCompanyName(pE.getCompanyName());
        uPE.setProjectName(pE.getProjectName());
        uPE.setProjectDescription(pE.getProjectDescription());
        uPE.setDutyDescription(pE.getDutyDescription());
        uPE.setProjectRole(pE.getProjectRole());
        uPE.setProjectLink(pE.getProjectLink());
        uPE.setCreatedBy("parser");
        uPE.setUpdatedBy("parser");
        return uPE;
    }

    //获取用户工作经历
    private UserWorkExperience getUserWorkExperience(WorkExperience wE, String userId, String resumeId) {
        UserWorkExperience uWE = new UserWorkExperience();
        uWE.setResumeId(resumeId);
        uWE.setUserId(userId);
        uWE.setWorkExpId(Keygenerator.generateRequestNo());
        uWE.setCompanyName(wE.getCompany());
        uWE.setBeginDate(wE.getStartDate());
        uWE.setEndDate(wE.getEndDate());
        uWE.setCompanySize(wE.getCompanySize());
        uWE.setFunction(wE.getJobFunction());
        uWE.setDepartment(wE.getDepartment());
        uWE.setMonthlySalary(wE.getSalary());
        uWE.setPosition(wE.getJobTitle());
        uWE.setJobDescription(wE.getDescription());
        uWE.setIndustry(wE.getCurrentIndustry());
        uWE.setCompanySize(wE.getCompanySize());
        uWE.setCreatedBy("parser");
        uWE.setUpdatedBy("parser");
        return uWE;
    }

    public void insertEducations(Resume resume, String userId, String resumeId) {
        resume.getEducations().forEach(EE -> {
            userEducationExperienceService.insert(getUserEducationExperience(EE, userId, resumeId));
        });
    }

}
