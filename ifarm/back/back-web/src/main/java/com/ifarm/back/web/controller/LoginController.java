package com.ifarm.back.web.controller;

import com.handy.frame.server.web.security.CookieNonCheckRequired;
import com.handy.frame.server.web.security.SecurityNonCheckRequired;
import com.handy.frame.server.web.security.exception.UserNotLoginException;
import com.ifarm.back.web.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author longhairen
 * @create 2017/6/9 0009 上午 10:02
 */
@Controller
public class LoginController extends AbstractController{

    @Autowired
    private ILoginService loginService;

    @SecurityNonCheckRequired
    @CookieNonCheckRequired
    @RequestMapping("/index")
    public String index() {
        try {
//            ButterflyUserContext.getCurrentUser();
        } catch(UserNotLoginException e) {
            return "login";
        }
        return "main";
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public String login(String userName, String password) {
        return "main";
    }
}
