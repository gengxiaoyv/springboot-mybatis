package com.example.springbootmybatisdemo.controller;


import com.example.springbootmybatisdemo.entity.UserDomain;
import com.example.springbootmybatisdemo.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(UserDomain userDomain){
        return userService.addUser(userDomain);
    }

    @GetMapping("/all")
    public Object findAllUser(int pageNum,int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }


}
