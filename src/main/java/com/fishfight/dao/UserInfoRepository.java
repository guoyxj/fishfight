package com.fishfight.dao;

import com.fishfight.common.model.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    UserInfo getByAccountAndPassword(String account,String password);
}
