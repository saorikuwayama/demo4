package com.example.domain;

import java.sql.Timestamp;

public class Users {
    private Integer id;
    private String mailAddress;  
    private String name;
    private String kana;
    private String zipcode;
    private String address;
    private String phoneNumber;
    private String password;
    private Timestamp registDate;
    private Integer registUser;
    private Timestamp updateDate;
    private Integer updateUser;
    private Integer deleteFlg;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getKana() {
        return kana;
    }
    public void setKana(String kana) {
        this.kana = kana;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getDeleteFlg() {
        return deleteFlg;
    }
    public void setDeleteFlg(Integer deleteFlg) {
        this.deleteFlg = deleteFlg;   
    }
    public Timestamp getRegistDate() {
        return registDate;
    }
    public void setRegistDate(Timestamp registDate) {
        this.registDate = registDate;
    }
    public Integer getRegistUser() {
        return registUser;
    }
    public void setRegistUser(Integer registUser) {
        this.registUser = registUser;
    }
    public Timestamp getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
    public Integer getUpdateUser() {
        return updateUser;
    }
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
    @Override
    public String toString() {
        return "Users [address=" + address + ", deleteFlg=" + deleteFlg + ", id=" + id + ", kana=" + kana
                + ", mailAddress=" + mailAddress + ", name=" + name + ", password=" + password + ", phoneNumber="
                + phoneNumber + ", registDate=" + registDate + ", registUser=" + registUser + ", updateDate="
                + updateDate + ", updateUser=" + updateUser + ", zipcode=" + zipcode + "]";
    }
    
}
