package com.design.foodmanagement.service;

import com.design.foodmanagement.pojo.Image;
import com.design.foodmanagement.pojo.res.RestFulBean;
import com.design.foodmanagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Image)表服务接口
 *
 * @author makejava
 * @since 2022-08-31 20:40:52
 */
public interface ImageService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Image> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Image> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Image image);

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Image image);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Image>> getSlideshow();

    RestFulBean<List<Image>> getFoodImage();
}
