package com.handy.frame.mockito.domain;

/**
 * @author longhairen
 * @create 2017/7/4 0004 下午 4:03
 */
public class Person {
    private String userName;
    private String password;

    public Person(){}

    public Person(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
