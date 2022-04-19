package com.mes.model;

import java.sql.Date;
import java.sql.Timestamp;

public class MaterialsOrders {

    /*
    CREATE TABLE materialsOrders(
        `id` bigint(20) AUTO_INCREMENT PRIMARY KEY,
        `name` varchar(200),
        `number` varchar (200),
        `account_id` bigint(20),
        `price` bigint (20),
        `orderDate` varchar (200),
        `deadlineDate` varchar (200),
        `etc` varchar (200),
        `created_at` TimeStamp,
        `updated_at` TimeStamp,
        FOREIGN KEY(account_id) REFERENCES accounts(id)
    );
     */

    protected int id;
    protected String name;
    protected String number;
    protected int account_id;
    protected int price;
    protected Date orderDate;
    protected Date deadlineDate;
    protected String etc;
    protected Timestamp created_at;
    protected Timestamp updated_at;

    protected String accountName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
