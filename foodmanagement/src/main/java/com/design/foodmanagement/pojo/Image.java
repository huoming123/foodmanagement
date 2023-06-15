package com.design.foodmanagement.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * (Image)实体类
 *
 * @author makejava
 * @since 2022-08-31 20:40:52
 */
public class Image implements Serializable {
    private static final long serialVersionUID = -81803598524952151L;
     
    private Integer id;
     /**
     * 图片
     */
    private String images;
    /**
     * 图片路劲 用于前端显示
     */
    private String imagesUrl;
    /**
     * 录入人
     */
    private String createdBy;
     /**
     * 区别是轮播图还是 美食页面图片
     */
    private String type;
    /**
     * 注册时间
     */
    private Timestamp createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

