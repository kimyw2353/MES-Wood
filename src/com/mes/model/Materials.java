package com.mes.model;

import com.mysql.cj.exceptions.StreamingNotifiable;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Materials {
   /*
   CREATE TABLE `matreials`(
        `id` bigint(20) AUTO_INCREMENT PRIMARY KEY,
        `code` varchar(200),
        `name` varchar(200),
        `account_id` bigint(20),
        `height` varchar(200),
        `width` varchar(200),
        `etc` varchar(200),
        `crated_at` timestamp,
        `updated_at` timestamp ,
        FOREIGN KEY(account_id) REFERENCES accounts(id)
    );
    */

    protected int id;
    protected String code;
    protected String name;
    protected int accountId;
    protected String height;
    protected String width;
    protected String etc;
    protected Timestamp created_at;
    protected Timestamp updated_at;

    protected String accountName;
    protected String[] materialIds;

    @Override
    public String toString() {
        return "Materials{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", accountId=" + accountId +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", etc='" + etc + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public ArrayList<Integer> getMaterialIds(){
        ArrayList<Integer> ids = new ArrayList<>();
        for (String id : materialIds){
            ids.add(Integer.parseInt(id));
        }
        return ids;
    }

    public void setMaterialIds(String[] materialIds) {
        this.materialIds = materialIds;
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
