package com.design.foodmanagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2022-08-30 10:36:44
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 837099144191836816L;
    
    private Integer id;
    /**
     * 密码
     */
    private String password;
    /**
     * 注册时间
     */
    private Date createdAt;
    /**
     * 账号
     */
    private String email;
    /**
     * 角色
     */
    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
