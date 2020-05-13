
package com.dc.framework.log.defaults;

import java.util.List;

import com.dc.framework.lang.collection.Lists;
import com.dc.framework.log.OperationLog;
import com.dc.framework.log.OperationSql;
import com.dc.framework.orm.id.ID;

/**
 * OperationLog的默认实现
 * 
 */
public class DefaultOperationLog implements OperationLog {
    
    @ID
    protected String id;
    protected String clientIp = "";
    protected String serverIp = "";
    protected String systemCode = "";
    protected String moduleCode = "";
    protected String moduleName = "";
    protected String operateType = "";
    protected String operateTime = "";
    protected String operateDesc = "";
    protected String operator = "";
    protected String sensitivity = "1";
    protected String status = "1";
    protected String operatePath = "";
    
    protected List<OperationSql> sqls = Lists.newList();
    
    public void addOperationSql(OperationSql sql) {

        if (sql instanceof DefaultOperationSql) {
            ((DefaultOperationSql) sql).setLog(this);
        }
        sqls.add(sql);
    }
    
    public String getOperatePath() {

        return operatePath;
    }
    
    public void setOperatePath(String operatePath) {

        this.operatePath = operatePath;
    }
    
    public List<OperationSql> getOperationSqls() {

        return sqls;
    }
    
    public String getClientIp() {

        return clientIp;
    }
    
    public void setClientIp(String clientIp) {

        this.clientIp = clientIp;
    }
    
    public String getSystemCode() {

        return systemCode;
    }
    
    public void setSystemCode(String systemCode) {

        this.systemCode = systemCode;
    }
    
    public String getModuleCode() {

        return moduleCode;
    }
    
    public void setModuleCode(String moduleCode) {

        this.moduleCode = moduleCode;
    }
    
    public String getModuleName() {

        return moduleName;
    }
    
    public void setModuleName(String moduleName) {

        this.moduleName = moduleName;
    }
    
    public String getOperator() {

        return operator;
    }
    
    public void setOperator(String operator) {

        this.operator = operator;
    }
    
    public String getSensitivity() {

        return sensitivity;
    }
    
    public void setSensitivity(String sensitivity) {

        this.sensitivity = sensitivity;
    }
    
    public String getStatus() {

        return status;
    }
    
    public void setStatus(String status) {

        this.status = status;
    }
    
    public String getServerIp() {

        return serverIp;
    }
    
    public void setServerIp(String serverIp) {

        this.serverIp = serverIp;
    }
    
    public String getOperateType() {

        return operateType;
    }
    
    public void setOperateType(String operateType) {

        this.operateType = operateType;
    }
    
    public String getOperateTime() {

        return operateTime;
    }
    
    public void setOperateTime(String operateTime) {

        this.operateTime = operateTime;
    }
    
    public String getOperateDesc() {

        return operateDesc;
    }
    
    public void setOperateDesc(String operateDesc) {

        this.operateDesc = operateDesc;
    }
    
    public List<OperationSql> getSqls() {

        return sqls;
    }
    
    public void setSqls(List<OperationSql> sqls) {

        this.sqls = sqls;
    }
    
    public String getId() {

        return id;
    }
    
    public void setId(String id) {

        this.id = id;
    }
    
    private static final long serialVersionUID = -7513201195800952006L;
    
}
