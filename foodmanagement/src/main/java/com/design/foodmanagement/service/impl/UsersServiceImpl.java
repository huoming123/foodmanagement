package com.design.foodmanagement.service.impl;

import com.design.foodmanagement.dto.Page;
import com.design.foodmanagement.pojo.Image;
import com.design.foodmanagement.pojo.Users;
import com.design.foodmanagement.mapper.UsersMapper;
import com.design.foodmanagement.service.UsersService;
import com.design.foodmanagement.util.PageUtil;
import org.springframework.stereotype.Service;
import com.design.foodmanagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2022-08-30 10:36:43
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Users> queryById(Integer id) {
       Users users=this.usersMapper.queryById(id);
         return RestFulBean.succ(users);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Users users) {
        if(users.getEmail()==null){
            return RestFulBean.error("邮箱不能为空");
        }
        if(!users.getEmail().contains("@"))
        {
            return RestFulBean.error("请输入合法邮箱");
        }
        this.usersMapper.insert(users);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Users users) {
        this.usersMapper.update(users);
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
        this.usersMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<String> login(Users users) {
        if(users.getEmail()==null)
        {
            return RestFulBean.error("账号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }

        //new 一个map对象 用于返回数据给前端
        Map<String,Object> result =new HashMap<>();
        String email=users.getEmail().trim();
        Users user =usersMapper.getByEmailAndRole(email);//根据账号跟角色获取对应的用户账号 //后台只能管理员登录
        //用户不为空
        if (user!=null){
            //密码跟数据库一样
            if(users.getPassword().equals(user.getPassword()))
            {
                return RestFulBean.succ("登录成功");
            }
            else{
                return RestFulBean.error("密码错误");
            }

        }
        return RestFulBean.error("用户不存在");
    }

    @Override
    public RestFulBean<Map> getList(Page<Users> page)throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Users> list= usersMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = usersMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
}
