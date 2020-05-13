package com.dc.framework.web;

import com.dc.framework.service.EntityFinder;

/**
 * @author wx
 * @version v1.0.0
 * @className FindController
 * @description TODO
 * @date 2019/12/15 22:11
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class FindController {

    protected EntityFinder finder;

    public void setEntityFinder(EntityFinder entityFinder) {

        this.finder = entityFinder;
    }
}
