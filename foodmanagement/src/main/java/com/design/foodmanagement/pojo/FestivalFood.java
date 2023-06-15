package com.design.foodmanagement.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * (FestivalFood)实体类
 *
 * @author makejava
 * @since 2022-08-31 20:46:14
 */
public class FestivalFood implements Serializable {
    private static final long serialVersionUID = 849941803291096211L;
     
    private Integer id;
     /**
     * 标题
     */
    private String title;
     /**
     * 描述
     */
    private String descb;
     /**
     * 图片
     */
    private String images;
    /**
     * 图片路劲 用于前端显示
     */
    private String imagesUrl;
     /**
     * 类型 是哪一个页面的图文信息
     */
    private String type;
    /**
     * 注册时间
     */
    private Timestamp createdAt;

    private Integer  showIn;

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public Integer getShowIn() {
        return showIn;
    }

    public void setShowIn(Integer showIn) {
        this.showIn = showIn;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

