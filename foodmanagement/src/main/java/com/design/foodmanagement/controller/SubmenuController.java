package com.design.foodmanagement.controller;

import com.design.foodmanagement.pojo.Submenu;
import com.design.foodmanagement.service.SubmenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.foodmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * (Submenu)表控制层
 *
 * @author makejava
 * @since 2022-07-02 09:07:08
 */
@RestController
@RequestMapping("/submenu")
public class SubmenuController {
    /**
     * 服务对象
     */
    @Autowired
    private SubmenuService submenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @GetMapping("/{id}")
    public RestFulBean<Submenu> queryById(@PathVariable Integer id) {
        return this.submenuService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param submenu 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Submenu submenu) {
        return this.submenuService.insert(submenu);
    }

    /**
     * 编辑数据
     *
     * @param submenu 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Submenu submenu) {
        return this.submenuService.update(submenu);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @DeleteMapping
    public RestFulBean<String> deleteById(Integer id) {
        return this.submenuService.deleteById(id);
    }

}

