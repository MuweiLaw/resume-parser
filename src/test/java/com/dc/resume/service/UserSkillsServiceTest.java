package com.dc.resume.service;


import com.dc.common.domain.UserSkills;
import com.dc.common.resume.service.BaseServiceTest;
import com.dc.framework.page.Page;
import com.dc.framework.page.PageContext;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSkillsServiceTest extends BaseServiceTest {

    @Autowired
    private UserSkillsService userSkillsService;

    @Test
    public void findPage(){
        PageContext pageContext = new PageContext();
        RowBounds rowBounds = new RowBounds(10,10);
        pageContext.setRowBounds(rowBounds);
        Page<UserSkills> page = userSkillsService.findPage(pageContext);

        System.out.println("page = " + page);

    }

}
