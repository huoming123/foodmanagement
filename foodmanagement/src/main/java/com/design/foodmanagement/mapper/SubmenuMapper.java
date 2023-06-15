package com.design.foodmanagement.mapper;

import com.design.foodmanagement.pojo.Submenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;
/**
 * (Submenu)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-02 09:07:08
 */
public interface SubmenuMapper {


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void addMenu(Submenu submenu);

    void updateMenu(Submenu submenu);

    List<Submenu> getSubMenu();

    List<Submenu> getByMainId(Integer id);

    Submenu queryById(Integer id);

    void insert(Submenu submenu);

    void update(Submenu submenu);
}

