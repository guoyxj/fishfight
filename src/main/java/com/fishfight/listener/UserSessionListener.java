package com.fishfight.listener;

import com.fishfight.common.util.OnlineUserManger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 用户上下线监听
 */
@WebListener
public class UserSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        String account = (String)session.getAttribute("account");
        OnlineUserManger.removeUser(account);
    }
}
