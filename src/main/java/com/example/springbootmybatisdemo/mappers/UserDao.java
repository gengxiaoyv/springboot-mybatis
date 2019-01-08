package com.example.springbootmybatisdemo.mappers;

import com.example.springbootmybatisdemo.entity.UserDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    int insert(UserDomain record);

    List<UserDomain> selectUsers();

}
