package com.ifarm.back.base.domain.bo;

import com.handy.frame.shared.entity.IUser;

import java.util.Date;
import java.util.Set;

/**
 * @author longhairen
 * @create 2017/6/15 0015 上午 9:46
 */
public class UserBO implements IUser{

    private String userCode;
    private String password;
    private String empCode;
    private String orgCode;
    private Integer isEmp;
    private Date lastLogin;
    private String notes;
    private Integer isDeleted;

    @Override
    public Set<String> getRoleids() {
        return null;
    }

    @Override
    public Set<String> queryAccessUris() {
        return null;
    }

    @Override
    public void setRoleids(Set<String> paramSet) {

    }

    @Override
    public void setUserName(String paramString) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getIsEmp() {
        return isEmp;
    }

    public void setIsEmp(Integer isEmp) {
        this.isEmp = isEmp;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
