package com.design.foodmanagement.controller;

import com.design.foodmanagement.pojo.FestivalFood;
import com.design.foodmanagement.pojo.Image;
import com.design.foodmanagement.service.FestivalFoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.foodmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.foodmanagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (FestivalFood)表控制层
 *
 * @author makejava
 * @since 2022-08-31 20:38:36
 */
@RestController
@RequestMapping("/festivalFood")
public class FestivalFoodController {
    /**
     * 服务对象
     */
    @Autowired
    private FestivalFoodService festivalFoodService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<FestivalFood>page) throws Exception{
        return this.festivalFoodService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<FestivalFood> queryById(@RequestBody FestivalFood festivalFood) {
        return this.festivalFoodService.queryById(festivalFood.getId());
    }

    /**
     * 新增数据
     *
     * @param festivalFood 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody FestivalFood festivalFood) {
        return this.festivalFoodService.insert(festivalFood);
    }

    /**
     * 编辑数据
     *
     * @param festivalFood 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody FestivalFood festivalFood) {
        return this.festivalFoodService.update(festivalFood);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody FestivalFood festivalFood) {
        return this.festivalFoodService.deleteById(festivalFood.getId());
    }
    //上传照片
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return festivalFoodService.upload(coverFile);
    }
    /**
     * 获取网页最新发布
     *
     * @param
     * @return
     */
    @PostMapping("/get/new/product")
    public RestFulBean<List<FestivalFood>> getNewProduct() {
        return this.festivalFoodService.getNewProduct();
    }
    /**
     * 获取网页热门推荐
     *
     * @param
     * @return
     */
    @PostMapping("/get/recommend")
    public RestFulBean<List<FestivalFood>> getRecommend() {
        return this.festivalFoodService.getRecommend();
    }
    /**
     * 获取网页节日美食
     *
     * @param
     * @return
     */
    @PostMapping("/get/festival/food")
    public RestFulBean<List<FestivalFood>> getFestivalFood() {
        return this.festivalFoodService.getFestivalFood();
    }

    /**
     * 修改数据是否展示
     *
     * @param
     * @return
     */
    @PostMapping("/show/in")
    public RestFulBean<String> showIn(@RequestBody FestivalFood festivalFood) {
        return this.festivalFoodService.showIn(festivalFood);
    }
    /**
     * 获取美食活动数据
     *
     * @param
     * @return
     */
    @PostMapping("/get/food/active")
    public RestFulBean<List<FestivalFood>> getFoodActive() {
        return this.festivalFoodService.getFoodActive();
    }
}

