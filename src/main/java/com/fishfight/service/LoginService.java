package com.fishfight.service;

import com.fishfight.common.model.entity.UserInfo;

public interface LoginService {

    UserInfo login(String account,String password);
}
