package com.metro.service;

import com.metro.pojo.Admin;

import java.util.List;

public interface AdminService {
    public Admin findOneAdmin(String account, String pwd);
    List<Admin>  findAllAccount();
    int updateAdminPwd(String pwd,String account);
}
