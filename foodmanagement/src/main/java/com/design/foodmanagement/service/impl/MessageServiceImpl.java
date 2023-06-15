package com.design.foodmanagement.service.impl;

import com.design.foodmanagement.mapper.UsersMapper;
import com.design.foodmanagement.pojo.Message;
import com.design.foodmanagement.mapper.MessageMapper;
import com.design.foodmanagement.pojo.Users;
import com.design.foodmanagement.service.MessageService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.foodmanagement.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.foodmanagement.util.PageUtil;
import com.design.foodmanagement.dto.Page;
/**
 * (Message)表服务实现类
 *
 * @author makejava
 * @since 2022-09-03 10:51:47
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UsersMapper usersMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Message> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Message> list= messageMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = messageMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Message> queryById(Integer id) {
       Message message=this.messageMapper.queryById(id);
         return RestFulBean.succ(message);
    }

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Message message) {
        if(message.getEmail()==null){
            return RestFulBean.error("邮箱不能为空");
        }
        if(message.getMessage()==null){
            return RestFulBean.error("留言不能为空");
        }
        String email =message.getEmail().trim();//获取用户邮箱
        Users user =usersMapper.getByEmail(email);//判断邮箱是否注册
        if(user==null){
            return RestFulBean.error("该邮箱还未注册");
        }
        this.messageMapper.insert(message);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Message message) {
        this.messageMapper.update(message);
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.messageMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }
}
