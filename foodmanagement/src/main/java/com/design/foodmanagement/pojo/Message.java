package com.design.foodmanagement.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (Message)实体类
 *
 * @author makejava
 * @since 2022-09-03 10:51:47
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 760001032978659388L;
     
    private Integer id;
     /**
     * 邮箱账号
     */
    private String email;
     /**
     * 留言
     */
    private String message;
     /**
     * 留言时间
     */
    private Date createdAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}

