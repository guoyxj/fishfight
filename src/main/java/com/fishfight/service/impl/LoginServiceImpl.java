package com.fishfight.service.impl;

import com.fishfight.common.model.entity.UserInfo;
import com.fishfight.dao.UserInfoRepository;
import com.fishfight.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo login(String account, String password) {
        return userInfoRepository.getByAccountAndPassword(account,password);
    }

}
