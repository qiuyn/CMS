package com.qiuy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by admin on 2019/12/11.
 */
@Entity(name="maintenanceForm")
public class MaintenanceForm {
    @Id
    @GeneratedValue
    private Long fomrid;//表单Id
    private String computermodels;//电脑型号
    private String problemcause;//故障原因
    private String worktime;//上门时间
    private String workmenphone;//维修人员联系方式
    private String workmenusername;//维修人员
    private String applysphone;//申请人联系方式
    private String applysusername;//申请人
    private String status;//状态 0 未分配 1 已分配 2维修中 3 已完成 4暂停
    private String leavemessage;//留言

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeavemessage() {
        return leavemessage;
    }

    public void setLeavemessage(String leavemessage) {
        this.leavemessage = leavemessage;
    }

    public Long getFomrid() {
        return fomrid;
    }

    public void setFomrid(Long fomrid) {
        this.fomrid = fomrid;
    }

    public String getComputermodels() {
        return computermodels;
    }

    public void setComputermodels(String computermodels) {
        this.computermodels = computermodels;
    }

    public String getProblemcause() {
        return problemcause;
    }

    public void setProblemcause(String problemcause) {
        this.problemcause = problemcause;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getWorkmenphone() {
        return workmenphone;
    }

    public void setWorkmenphone(String workmenphone) {
        this.workmenphone = workmenphone;
    }

    public String getWorkmenusername() {
        return workmenusername;
    }

    public void setWorkmenusername(String workmenusername) {
        this.workmenusername = workmenusername;
    }

    public String getApplysphone() {
        return applysphone;
    }

    public void setApplysphone(String applysphone) {
        this.applysphone = applysphone;
    }

    public String getApplysusername() {
        return applysusername;
    }

    public void setApplysusername(String applysusername) {
        this.applysusername = applysusername;
    }
}
