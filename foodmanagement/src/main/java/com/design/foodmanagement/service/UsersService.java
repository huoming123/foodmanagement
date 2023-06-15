package com.design.foodmanagement.service;

import com.design.foodmanagement.dto.Page;
import com.design.foodmanagement.pojo.Users;
import com.design.foodmanagement.pojo.res.RestFulBean;

import java.util.Map;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2022-08-30 10:36:43
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Users> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<String> login(Users users);

    RestFulBean<Map> getList(Page<Users> page) throws Exception;
}
