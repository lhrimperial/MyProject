package com.handy.frame.web.domain;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

/**
 * Created by longhairen on 2017/4/25 0025.
 */
public class UserInfo implements Serializable {
    private int id;
    private String userName;
    private String passWord;
    private String mobileNo;
    private String email;
    private String gender;

    public UserInfo(){}

    public UserInfo(String userName, String passWord, String mobileNo, String email, String gender){
        this.userName = userName;
        this.passWord = passWord;
        this.mobileNo = mobileNo;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
