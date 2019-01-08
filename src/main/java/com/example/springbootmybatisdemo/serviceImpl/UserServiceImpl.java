package com.example.springbootmybatisdemo.serviceImpl;

import com.example.springbootmybatisdemo.entity.UserDomain;
import com.example.springbootmybatisdemo.interfaces.UserService;
import com.example.springbootmybatisdemo.mappers.UserDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(UserDomain userDomain) {
        return userDao.insert(userDomain);
    }

    @Override
    public PageInfo<UserDomain> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<UserDomain> userDomains = userDao.selectUsers();
        PageInfo result = new PageInfo(userDomains);

        return result;
    }
}
