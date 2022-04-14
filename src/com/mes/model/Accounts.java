package com.mes.model;

import java.util.ArrayList;
import java.util.Date;

public class Accounts {

   /* CREATE TABLE `accounts`(
        `id` bigint(20) AUTO_INCREMENT PRIMARY KEY,
        `name` varchar(200) ,
        `businessNumber` varchar(200) ,
        `businessType` varchar(200) ,
        `businessCategory` varchar(200) ,
        `ceo` varchar(20) ,
        `zipcode` varchar(200) ,
        `address` varchar(200) ,
        `addressDesc` varchar(200) ,
        `phone` varchar(200),
        `fax` varchar(200) ,
        `etc` varchar(200) ,
        `created_at` timestamp ,
        `updated_at` timestamp
    );*/


    protected int id;
    protected String name;
    protected String businessNumber;
    protected String businessType;
    protected String businessCategory;
    protected String ceo;
    protected String zipcode;
    protected String address;
    protected String addressDesc;
    protected String phone;
    protected String fax;
    protected String etc;
    protected Date createdAt;
    protected Date updatedAt;

    public String[] accountIds;

    public ArrayList<Integer> getAccountIds(){
        ArrayList<Integer> ids = new ArrayList<>();
        for (String id : accountIds){
            ids.add(Integer.parseInt(id));
        }
        return ids;
    }

    public void setAccountIds(String[] accountIds){
        this.accountIds = accountIds;
    }


    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", businessNumber='" + businessNumber + '\'' +
                ", businessType='" + businessType + '\'' +
                ", businessCategory='" + businessCategory + '\'' +
                ", ceo='" + ceo + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", address='" + address + '\'' +
                ", addressDesc='" + addressDesc + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", etc='" + etc + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Accounts() {
    }

    public Accounts(int id, String name, String businessNumber, String businessType, String businessCategory, String ceo, String zipcode, String address, String addressDesc, String phone, String fax, String etc, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.businessNumber = businessNumber;
        this.businessType = businessType;
        this.businessCategory = businessCategory;
        this.ceo = ceo;
        this.zipcode = zipcode;
        this.address = address;
        this.addressDesc = addressDesc;
        this.phone = phone;
        this.fax = fax;
        this.etc = etc;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
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
