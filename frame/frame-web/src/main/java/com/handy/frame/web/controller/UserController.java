package com.handy.frame.web.controller;

import com.handy.frame.shared.response.ResponseBaseEntity;
import com.handy.frame.web.domain.UserInfo;
import com.handy.frame.web.service.IUserInfoService;
import com.handy.frame.web.service.impl.UserInfoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longhairen
 * @create 2017/5/8 0008 上午 10:46
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private UserInfoTestService userInfoTestService;

    @ResponseBody
    @RequestMapping("/getNumber")
    public int getNumber(){
        return userInfoTestService.getNumber("hello","world");
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<UserInfo> findList(){
        return userInfoService.findUserInfoList();
    }

    @ResponseBody
    @RequestMapping("/findtest")
    public UserInfo findTest(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        return userInfoTestService.findUserInfo(userInfo);
    }

    @ResponseBody
    @RequestMapping("/find/{id}")
    public UserInfo queryUserInfo(@PathVariable("id") int id){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        return userInfoService.findUserInfo(userInfo);
    }

    @ResponseBody
    @RequestMapping("/find/page/{page}")
    public List<UserInfo> findUserList(@PathVariable("page") int page){
        return userInfoService.findUserInfoList(new UserInfo());
    }


    @ResponseBody
    @RequestMapping("/batch/save")
    public ResponseBaseEntity saveUserInfo(){
        ResponseBaseEntity entity = new ResponseBaseEntity();
        entity.setCode("10000");
        entity.setMessage("successfully");

        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        UserInfo userinfo = null;
        for (int i = 0; i < 30; i++){
            userinfo = new UserInfo("hello_"+i,
                    "123456",
                    "1364059" + String.format("%04d", i),
                    "136" + String.format("%03d", i) + "@163.com",
                    i%2 == 0 ? "male" : "female");

            userInfos.add(userinfo);
        }

        userInfoService.saveBatchUserInfo(userInfos);
        return entity;
    }

}
