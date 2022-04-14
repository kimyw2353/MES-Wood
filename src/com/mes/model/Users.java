package com.mes.model;

import java.util.Date;

public class Users {


    /*
    CREATE TABLE  `users`(
        `id` bigint(20) AUTO_INCREMENT PRIMARY KEY,
        `user_id` varchar(200),
        `password` varchar(200),
        `name` varchar(200),
        `created_at` timestamp,
        `updated_at` timestamp
     );
    */

    protected int id;
    protected String userId;
    protected String password;
    protected String name;
    protected Date createdAt;
    protected Date updatedAt;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAte=" + updatedAt +
                '}';
    }

    public Users() {
    }

    public Users(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
