package com.fishfight.common.util;

import com.fishfight.common.model.entity.UserInfo;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 在线用户管理器
 */
public class OnlineUserManger {
    private static Map<String,HttpSession> playerMap = new ConcurrentHashMap<>();

    public static void addUser(String account,HttpSession session){
        playerMap.put(account,session);
    }

    public static void removeUser(String account){
        playerMap.remove(account);
    }

    public static boolean checkUser(String account){
        return playerMap.containsKey(account);
    }

    public static List<UserInfo> list(){
        List<UserInfo> userInfos = new LinkedList<>();
        for (HttpSession session : playerMap.values()) {
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            if(userInfo != null){
                userInfos.add(userInfo);
            }
        }
        return userInfos;
    }
}
