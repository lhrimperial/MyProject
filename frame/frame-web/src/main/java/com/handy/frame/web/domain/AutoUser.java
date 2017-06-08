package com.handy.frame.web.domain;

/**
 * @author longhairen
 * @create 2017/5/8 0008 下午 4:17
 */
public class AutoUser {
    private int id;
    private String userName;
    private String passWord;

    public AutoUser(){}

    public AutoUser(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
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
}
