package com.handy.frame.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author longhairen
 * @create 2017-07-22 8:47
 * @description
 **/
@Controller
@RequestMapping("cross")
public class CrossDomainController {

    @RequestMapping("/index")
    public String cross(){
        return "cross";
    }

}
