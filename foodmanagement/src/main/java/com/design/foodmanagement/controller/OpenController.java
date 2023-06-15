package com.design.foodmanagement.controller;
import com.design.foodmanagement.pojo.Users;
import com.design.foodmanagement.pojo.res.RestFulBean;
import com.design.foodmanagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OpenController {

    @Autowired
    private UsersService userService;
    /**
     *
     * @param Users 需要teachNo和password
     * @return data token
     */
    @PostMapping("/login")
    public RestFulBean<String> login(@RequestBody Users Users) throws Exception {
        return userService.login(Users);
    }

}

