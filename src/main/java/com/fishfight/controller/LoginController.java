package com.fishfight.controller;
import java.util.Date;
import	java.util.Random;

import com.fishfight.common.model.entity.UserInfo;
import com.fishfight.service.LoginService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public String redirectLogin(){
        return toLogin();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public UserInfo login(HttpServletRequest request, String account, String password){
        UserInfo userInfo = null;
        try{
            logger.info("user login,account={}",account);
            userInfo = loginService.login(account, password);
            if(userInfo == null){
                throw new IllegalAccessException("account or password is not correct");
            }

            //save userInfo in session
            request.getSession().setAttribute("userInfo",userInfo);
        }catch (Exception e){
            logger.error("login fail",e);
        }
        return userInfo;
    }

    @RequestMapping(value = "/loginByVisitor", method = RequestMethod.POST)
    @ResponseBody
    public UserInfo login(HttpServletRequest request){
        UserInfo userInfo = new UserInfo();
        try{
            userInfo.setNickname("fish-" + new Random().nextInt(1024) + "-" + DateFormatUtils.format(new Date(),"HHmmss"));
            userInfo.setSex(-1);
            //save userInfo in session
            request.getSession().setAttribute("userInfo",userInfo);
        }catch (Exception e){
            logger.error("Visitor login fail",e);
        }
        return userInfo;
    }

}
