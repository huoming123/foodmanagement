package com.design.foodmanagement.controller;

import com.design.foodmanagement.pojo.Image;
import com.design.foodmanagement.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.foodmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.foodmanagement.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Image)表控制层
 *
 * @author makejava
 * @since 2022-08-31 20:40:52
 */
@RestController
@RequestMapping("/image")
public class ImageController {
    /**
     * 服务对象
     */
    @Autowired
    private ImageService imageService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Image>page) throws Exception{
        return this.imageService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Image> queryById(@RequestBody Image image) {
        return this.imageService.queryById(image.getId());
    }

    /**
     * 新增数据
     *
     * @param image 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Image image) {
        return this.imageService.insert(image);
    }

    /**
     * 编辑数据
     *
     * @param image 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Image image) {
        return this.imageService.update(image);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Image image) {
        return this.imageService.deleteById(image.getId());
    }
    /**
     * 获取网页轮播图
     *
     * @param
     * @return
     */
    @PostMapping("/get/slideshow")
    public RestFulBean<List<Image>> getSlideshow() {
        return this.imageService.getSlideshow();
    }
    /**
     * 获取美食页面图片
     *
     * @param
     * @return
     */
    @PostMapping("/get/food/image")
    public RestFulBean<List<Image>> getFoodImage() {
        return this.imageService.getFoodImage();
    }
}

