package com.design.foodmanagement.service.impl;

import com.design.foodmanagement.pojo.FestivalFood;
import com.design.foodmanagement.pojo.Image;
import com.design.foodmanagement.mapper.ImageMapper;
import com.design.foodmanagement.service.ImageService;
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
 * (Image)表服务实现类
 *
 * @author makejava
 * @since 2022-08-31 20:40:52
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Image> page) throws Exception{
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Image> list= imageMapper.getPageListByCondition(page);
        if(list.size()>0){  //数据大于0 才进去
            for(Image image: list){
                image.setImagesUrl("http://localhost:8087/file/"+image.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = imageMapper.getPageListCount(page);
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
    public RestFulBean<Image> queryById(Integer id) {
       Image image=this.imageMapper.queryById(id);
         return RestFulBean.succ(image);
    }

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Image image) {
        if(image.getImages()==null || image.getImages().equals("")){
            return RestFulBean.error("图片不能为空");
        }
        this.imageMapper.insert(image);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Image image) {
        this.imageMapper.update(image);
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
        this.imageMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Image>> getSlideshow() {
        List<Image> list =imageMapper.getSlideshow();
        if(list.size()>0){  //数据大于0 才进去
            for(Image image: list){
                image.setImagesUrl("http://localhost:8087/file/"+image.getImages());
            }
        }
        return RestFulBean.succ(list);
    }

    @Override
    public RestFulBean<List<Image>> getFoodImage() {
        List<Image> list =imageMapper.getFoodImage();
        if(list.size()>0){  //数据大于0 才进去
            for(Image image: list){
                image.setImagesUrl("http://localhost:8087/file/"+image.getImages());
            }
        }
        return RestFulBean.succ(list);
    }
}
