package com.design.foodmanagement.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * (Submenu)实体类
 *
 * @author makejava
 * @since 2022-07-02 09:07:08
 */
public class Submenu implements Serializable {
    private static final long serialVersionUID = 173132120328586407L;
     
    private Integer id;
     /**
     * 外键 main_menu 的主键
     */
    private Integer mainId;
     /**
     * 序号
     */
    private Integer seq;
     /**
     * 菜单名
     */
    private String menuName;
     /**
     * 菜单路劲
     */
    private String menuUrl;
     /**
     * 创建人
     */
    private String createdBy;
     /**
     * 创建时间
     */
    private Timestamp createdAt;
     /**
     * 修改人
     */
    private String updatedBy;
     /**
     * 修改时间
     */
    private Timestamp updatedAt;
     /**
     * 修改人
     */
    private String deletedBy;
     /**
     * 删除时间
     */
    private Timestamp deletedAt;
    /**
     * 用户角色
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }



    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }



    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }
}

