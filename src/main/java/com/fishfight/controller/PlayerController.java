package com.fishfight.controller;

import com.fishfight.common.model.entity.UserInfo;
import com.fishfight.common.util.OnlineUserManger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    /**
     * 获取在线用户列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserInfo> getUserInfo(){
        return OnlineUserManger.list();
    }

    /**
     * 对用户发起挑战
     */
    public Boolean fightUser(String account){
        if(!OnlineUserManger.checkUser(account)){
            //用户状态为离线
            return false;
        }
        return true;
    }

}
