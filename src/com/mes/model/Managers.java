package com.mes.model;

import java.util.ArrayList;
import java.util.Date;

public class Managers {

    /*
    CREATE TABLE `managers`(
        `id` bigint(20) AUTO_INCREMENT PRIMARY KEY,
        `account_id` bigint(20),
        `name` varchar(200),
        `email` varchar(200),
        `phone` varchar(200),
        `position` varchar(200),
        `department` varchar(200),
        `created_at` timestamp,
        `updated_at` timestamp,
        FOREIGN KEY(account_id) REFERENCES accounts(id)
    );
     */


    protected int id;
    protected int accountId;
    protected String name;
    protected String email;
    protected String phone;
    protected String position;
    protected String department;
    protected Date createdAt;
    protected Date updatedAt;

    protected String accountName;
    protected String[] managerIds;

    @Override
    public String toString() {
        return "Managers{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public ArrayList<Integer> getManagerIds(){
        ArrayList<Integer> ids = new ArrayList<>();
        for (String id : managerIds){
            ids.add(Integer.parseInt(id));
        }
        return ids;
    }

    public void setManagerIds(String[] managerIds) {
        this.managerIds = managerIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


}
