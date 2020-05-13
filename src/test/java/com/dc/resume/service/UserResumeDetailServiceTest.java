package com.dc.resume.service;

import com.dc.common.domain.UserResumeDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserResumeDetailServiceTest extends ServiceBaseTest {
    @Autowired
    com.dc.resume.service.UserResumeDetailService UserResumeDetailService;

    @Test
    public void findListByPhoneNoAndName() {

        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("15665");
        map.put("list", list);
        final List<UserResumeDetail> by = UserResumeDetailService.findBy(map);

    }

}