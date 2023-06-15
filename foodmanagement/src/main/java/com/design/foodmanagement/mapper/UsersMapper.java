package com.design.foodmanagement.mapper;

import com.design.foodmanagement.dto.Page;
import com.design.foodmanagement.pojo.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-30 10:36:44
 */
public interface UsersMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);


    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Users getByEmailAndRole(String email);

    List<Users> getPageListByCondition(@Param("page") Page<Users> page);

    Integer getPageListCount(@Param("page")Page<Users> page);

    Users getByEmail(String email);
}
