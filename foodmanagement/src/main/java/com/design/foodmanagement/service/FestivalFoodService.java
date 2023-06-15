package com.design.foodmanagement.service;

import com.design.foodmanagement.pojo.FestivalFood;
import com.design.foodmanagement.pojo.res.RestFulBean;
import com.design.foodmanagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (FestivalFood)表服务接口
 *
 * @author makejava
 * @since 2022-08-31 20:38:36
 */
public interface FestivalFoodService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<FestivalFood> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<FestivalFood> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param festivalFood 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(FestivalFood festivalFood);

    /**
     * 修改数据
     *
     * @param festivalFood 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(FestivalFood festivalFood);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> upload(MultipartFile coverFile);

    RestFulBean<List<FestivalFood>> getNewProduct();

    RestFulBean<List<FestivalFood>> getRecommend();

    RestFulBean<List<FestivalFood>> getFestivalFood();

    RestFulBean<String> showIn(FestivalFood festivalFood);

    RestFulBean<List<FestivalFood>> getFoodActive();
}
