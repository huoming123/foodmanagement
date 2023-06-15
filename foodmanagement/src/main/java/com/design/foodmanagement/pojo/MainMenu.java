package com.design.foodmanagement.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (MainMenu)实体类
 *
 * @author makejava
 * @since 2022-07-02 09:06:34
 */
public class MainMenu implements Serializable {
    private static final long serialVersionUID = -49108938701091754L;
     
    private Integer id;
     /**
     * 菜单名
     */
    private String mainName;
     /**
     * 创建人
     */
    private String createdBy;
     /**
     * 创建时间
     */
    private Timestamp createdAt;
     /**
     * 修改时间
     */
    private Timestamp updatedAt;
     /**
     * 修改人
     */
    private String updatedBy;
     /**
     * 删除人
     */
    private String deletedBy;
     /**
     * 删除时间
     */
    private Date deletedAt;
     /**
     * 序号
     */
    private Integer seq;
    /**
     *  数据对象
     */
    private List<Submenu> submenuList;

    public List<Submenu> getSubmenuList() {
        return submenuList;
    }

    public void setSubmenuList(List<Submenu> submenuList) {
        this.submenuList = submenuList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
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

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

}

