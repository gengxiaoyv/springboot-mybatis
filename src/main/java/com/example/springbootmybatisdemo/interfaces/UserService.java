package com.example.springbootmybatisdemo.interfaces;

import com.example.springbootmybatisdemo.entity.UserDomain;
import com.github.pagehelper.PageInfo;

public interface UserService {

    int addUser(UserDomain userDomain);

    PageInfo<UserDomain> findAllUser(int pageNum,int pageSize);

}
