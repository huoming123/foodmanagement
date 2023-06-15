package com.design.foodmanagement.mapper;

import com.design.foodmanagement.pojo.Message;
import java.util.List;
import com.design.foodmanagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Message)表数据库访问层
 *
 * @author makejava
 * @since 2022-09-03 10:51:47
 */
public interface MessageMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Message queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Message> getPageListByCondition(@Param("page") Page<Message> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Message> page);


    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 影响行数
     */
    int insert(Message message);




    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 影响行数
     */
    int update(Message message);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

