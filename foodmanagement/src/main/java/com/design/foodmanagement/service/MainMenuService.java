package com.design.foodmanagement.service;

import com.design.foodmanagement.pojo.MainMenu;
import com.design.foodmanagement.pojo.Submenu;
import com.design.foodmanagement.pojo.Users;
import com.design.foodmanagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (MainMenu)表服务接口
 *
 * @author makejava
 * @since 2022-07-02 09:06:33
 */
public interface MainMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<MainMenu> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param mainMenu 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(MainMenu mainMenu);

    /**
     * 修改数据
     *
     * @param mainMenu 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(MainMenu mainMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);
    /**
     * 获取系统菜单栏
     *
     * 
     */
    RestFulBean<Map<Object, Object>> getMenuTree() throws Exception;


    RestFulBean<String> addMenu(Submenu submenu)throws Exception;

    RestFulBean<String> addMainMenu(MainMenu mainMenu);

    RestFulBean<String> updateMainMenu(MainMenu mainMenu);

    RestFulBean<String> updateMenu(Submenu submenu);

    RestFulBean<String> delMenu(Submenu submenu);

    RestFulBean<String> delMainMenu(MainMenu mainMenu);
}
