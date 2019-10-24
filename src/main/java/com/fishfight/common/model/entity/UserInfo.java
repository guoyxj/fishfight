package com.fishfight.common.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "user_info")
@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nickname;
    private Integer sex;
    private String pic;
    private Integer level;
    private Date createTime;
    private Date lastLoginTime;
    private String password;
    private String account;
}
