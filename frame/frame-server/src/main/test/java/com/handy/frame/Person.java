package com.handy.frame;

/**
 * @author longhairen
 * @create 2017/6/7 0007 下午 5:41
 */
public class Person {
    private int id;
    private String userName;
    private String password;

    public Person(){}

    public Person(int id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
