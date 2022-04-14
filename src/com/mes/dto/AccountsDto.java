package com.mes.dto;

import java.util.ArrayList;
import java.util.Date;

public class AccountsDto {

    private int id;
    private String name;
    private String businessNumber;
    private String businessType;
    private String businessCategory;
    private String ceo;
    private String zipcode;
    private String address;
    private String addressDesc;
    private String phone;
    private String fax;
    private String etc;
    private Date createdAt;
    private Date updatedAt;
    private ArrayList<Integer> accountIds;

    public ArrayList<Integer> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(String[] accountIds) {
        for (String ids : accountIds) {
            this.accountIds.add(Integer.parseInt(ids));
        }
    }

    @Override
    public String toString() {
        return "AccountsDto{" +
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
                ", accountIds=" + accountIds +
                '}';
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
