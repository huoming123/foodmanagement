package com.design.foodmanagement.controller;

import com.design.foodmanagement.pojo.Message;
import com.design.foodmanagement.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.foodmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.foodmanagement.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Message)表控制层
 *
 * @author makejava
 * @since 2022-09-03 10:51:47
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    /**
     * 服务对象
     */
    @Autowired
    private MessageService messageService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Message>page) throws Exception{
        return this.messageService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Message> queryById(@RequestBody Message message) {
        return this.messageService.queryById(message.getId());
    }

    /**
     * 新增数据
     *
     * @param message 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Message message) {
        return this.messageService.insert(message);
    }

    /**
     * 编辑数据
     *
     * @param message 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Message message) {
        return this.messageService.update(message);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Message message) {
        return this.messageService.deleteById(message.getId());
    }

}

