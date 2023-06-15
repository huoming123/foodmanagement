package com.design.foodmanagement.mapper;

import com.design.foodmanagement.pojo.Image;
import java.util.List;
import com.design.foodmanagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Image)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-31 20:40:52
 */
public interface ImageMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Image queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Image> getPageListByCondition(@Param("page") Page<Image> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Image> page);


    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 影响行数
     */
    int insert(Image image);




    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 影响行数
     */
    int update(Image image);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Image> getSlideshow();

    List<Image> getFoodImage();
}

