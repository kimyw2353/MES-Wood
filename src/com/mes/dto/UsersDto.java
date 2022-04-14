package com.mes.dto;

import java.util.Date;

public class UsersDto {

    protected int id;
    protected String userId;
    protected String password;
    protected String name;
    protected Date createdAt;
    protected Date updatedAte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAte() {
        return updatedAte;
    }

    public void setUpdatedAte(Date updatedAte) {
        this.updatedAte = updatedAte;
    }
}
