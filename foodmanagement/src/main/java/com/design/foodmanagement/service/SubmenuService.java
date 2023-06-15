package com.design.foodmanagement.service;

import com.design.foodmanagement.pojo.Submenu;
import com.design.foodmanagement.pojo.res.RestFulBean;
/**
 * (Submenu)表服务接口
 *
 * @author makejava
 * @since 2022-07-02 09:07:08
 */
public interface SubmenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Submenu> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param submenu 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Submenu submenu);

    /**
     * 修改数据
     *
     * @param submenu 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Submenu submenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
