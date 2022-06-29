package com.example.form;

public class UserForm {
    private String id;
    private String mailAddress;  
    private String name;
    private String kana;
    private String zipcode;
    private String address;
    private String phoneNumber;
    private String password;
    private String registDate;
    private String registUser;
    private String updateDate;
    private String updateUser;
    private String deleteFlg;

    
    @Override
    public String toString() {
        return "UserForm [address=" + address + ", deleteFlg=" + deleteFlg + ", id=" + id + ", kana=" + kana
                + ", mailAddress=" + mailAddress + ", name=" + name + ", password=" + password + ", phoneNumber="
                + phoneNumber + ", registDate=" + registDate + ", registUser=" + registUser + ", updateDate="
                + updateDate + ", updateUser=" + updateUser + ", zipcode=" + zipcode + "]";
    }
    public String getRegistDate() {
        return registDate;
    }
    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }
    public String getRegistUser() {
        return registUser;
    }
    public void setRegistUser(String registUser) {
        this.registUser = registUser;
    }
    public String getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    public String getUpdateUser() {
        return updateUser;
    }
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    
    public String getDeleteFlg() {
        return deleteFlg;
    }
    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }  
    
}
