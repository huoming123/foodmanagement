package com.design.foodmanagement.controller;

import com.design.foodmanagement.dto.Page;
import com.design.foodmanagement.pojo.Image;
import com.design.foodmanagement.pojo.Users;
import com.design.foodmanagement.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.foodmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2022-08-30 10:36:41
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Autowired
    private UsersService usersService;

    /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Users> page) throws Exception{
        return this.usersService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("/get/by/id")
    public RestFulBean<Users> queryById(@RequestBody Users users) {
        return this.usersService.queryById(users.getId());
    }

    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Users users) {
        return this.usersService.insert(users);
    }

    /**
     * 编辑数据
     *
     * @param
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Users users) {
        return this.usersService.update(users);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Users users) {
        return this.usersService.deleteById(users.getId());
    }

}
