package com.fishfight.Interceptor;

import com.fishfight.common.model.entity.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysUserLoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //校验用户是否登录
        UserInfo user = (UserInfo)request.getSession().getAttribute("userInfo");
        if(user == null){
            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
