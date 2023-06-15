package com.design.foodmanagement.mapper;

import com.design.foodmanagement.pojo.FestivalFood;
import java.util.List;
import com.design.foodmanagement.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (FestivalFood)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-31 20:38:36
 */
public interface FestivalFoodMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    FestivalFood queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<FestivalFood> getPageListByCondition(@Param("page") Page<FestivalFood> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<FestivalFood> page);


    /**
     * 新增数据
     *
     * @param festivalFood 实例对象
     * @return 影响行数
     */
    int insert(FestivalFood festivalFood);




    /**
     * 修改数据
     *
     * @param festivalFood 实例对象
     * @return 影响行数
     */
    int update(FestivalFood festivalFood);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<FestivalFood> getNewProduct();

    List<FestivalFood> getRecommend();

    List<FestivalFood> getFestivalFood();

    void showIn(FestivalFood festivalFood);

    List<FestivalFood> getFoodActive();
}

