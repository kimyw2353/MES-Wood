package com.mes.model;

import java.sql.Date;

public class OrderMaterials {
    protected int id;
    protected String code;
    protected String name;
    protected int account_id;
    protected String height;
    protected String width;
    protected String etc;
    protected Date createAt;
    protected Date updateAt;

    protected int amount; //수량
    protected int price; //단가

    @Override
    public String toString() {
        return "OrderMaterials{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", account_id=" + account_id +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", etc='" + etc + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
