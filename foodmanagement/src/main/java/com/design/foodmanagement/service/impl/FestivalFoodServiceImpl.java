package com.design.foodmanagement.service.impl;

import com.design.foodmanagement.pojo.FestivalFood;
import com.design.foodmanagement.mapper.FestivalFoodMapper;
import com.design.foodmanagement.pojo.Image;
import com.design.foodmanagement.service.FestivalFoodService;
import com.design.foodmanagement.util.FileUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.foodmanagement.pojo.res.RestFulBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.foodmanagement.util.PageUtil;
import com.design.foodmanagement.dto.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * (FestivalFood)表服务实现类
 *
 * @author makejava
 * @since 2022-08-31 20:38:36
 */
@Service("festivalFoodService")
public class FestivalFoodServiceImpl implements FestivalFoodService {
    @Autowired
    private FestivalFoodMapper festivalFoodMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<FestivalFood> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<FestivalFood> list= festivalFoodMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(FestivalFood festivalFood: list){
                festivalFood.setImagesUrl("http://localhost:8087/file/"+festivalFood.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = festivalFoodMapper.getPageListCount(page);
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
    public RestFulBean<FestivalFood> queryById(Integer id) {
       FestivalFood festivalFood=this.festivalFoodMapper.queryById(id);
         return RestFulBean.succ(festivalFood);
    }

    /**
     * 新增数据
     *
     * @param festivalFood 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(FestivalFood festivalFood) {
        if(festivalFood.getTitle()==null){
            return RestFulBean.error("标题不能为空");
        }
        if(festivalFood.getDescb()==null){
            return RestFulBean.error("描述不能为空");
        }
        this.festivalFoodMapper.insert(festivalFood);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param festivalFood 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(FestivalFood festivalFood) {
        this.festivalFoodMapper.update(festivalFood);
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
        this.festivalFoodMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> upload(MultipartFile coverFile) {
        String destPath ="D:\\design\\images\\";
        // 存图片
        try{
            FileUtil.saveFile(coverFile, destPath,coverFile.getOriginalFilename());
        }
        catch(Exception e){
            return RestFulBean.error("请求异常");
        }
        Map map =new HashMap();
        //将图片名字返回 用于录入用户的时候 把这个值保存到image字段中
        map.put("imageName",coverFile.getOriginalFilename());
        //本地获取图片的路劲
        map.put("url","http://localhost:8087/file/"+coverFile.getOriginalFilename());

        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<List<FestivalFood>> getNewProduct() {
        List<FestivalFood> list =festivalFoodMapper.getNewProduct();
        if(list.size()>0){  //数据大于0 才进去
            for(FestivalFood festivalFood: list){
                festivalFood.setImagesUrl("http://localhost:8087/file/"+festivalFood.getImages());
            }
        }
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<List<FestivalFood>> getRecommend() {
        List<FestivalFood> list =festivalFoodMapper.getRecommend();
        if(list.size()>0){  //数据大于0 才进去
            for(FestivalFood festivalFood: list){
                festivalFood.setImagesUrl("http://localhost:8087/file/"+festivalFood.getImages());
            }
        }
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<List<FestivalFood>> getFestivalFood() {
        List<FestivalFood> list =festivalFoodMapper.getFestivalFood();
        if(list.size()>0){  //数据大于0 才进去
            for(FestivalFood festivalFood: list){
                festivalFood.setImagesUrl("http://localhost:8087/file/"+festivalFood.getImages());
            }
        }
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<String> showIn(FestivalFood festivalFood) {
        this.festivalFoodMapper.showIn(festivalFood);
        return RestFulBean.succ("修改成功");
    }

    @Override
    public RestFulBean<List<FestivalFood>> getFoodActive() {
        List<FestivalFood> list =festivalFoodMapper.getFoodActive();
        if(list.size()>0){  //数据大于0 才进去
            for(FestivalFood festivalFood: list){
                festivalFood.setImagesUrl("http://localhost:8087/file/"+festivalFood.getImages());
            }
        }
        return RestFulBean.succ(list);
    }
}
