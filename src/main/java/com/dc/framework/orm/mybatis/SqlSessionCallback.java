
package com.dc.framework.orm.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * @author wx
 * @version v1.0.0
 * @className SqlSessionCallback
 * @description SqlSessionCallback
 * @date 2019/12/14 20:51
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface SqlSessionCallback {
    
    public Object doInSession(SqlSession session);
    
}
