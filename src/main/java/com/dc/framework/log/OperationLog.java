package com.dc.framework.log;

import java.io.Serializable;
import java.util.List;

/**
 * 操作日志模型接口，只是抽象出审计要求记录的信息，不限制具体表，由具体项目实现
 */
public interface OperationLog extends Serializable {
    
    public String getClientIp();
    
    public String getServerIp();
    
    public String getSensitivity();
    
    public String getSystemCode();
    
    public String getModuleCode();
    
    public String getModuleName();
    
    public String getOperateTime();
    
    public String getOperator();
    
    public String getOperateType();
    
    public String getStatus();
    
    public String getOperateDesc();
    
    public String getOperatePath();
    
    public List<OperationSql> getOperationSqls();
    
    public void addOperationSql(OperationSql sql);
    
}
