package com.example.domain;

import java.sql.Timestamp;

public class PreUsers {
    private Integer id;
    private String mailAddress;
    private String key;
    private Integer enabled;
    private Timestamp created;

    
    public Timestamp getCreated() {
        return created;
    }
    public void setCreated(Timestamp created) {
        this.created = created;
    }
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
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public Integer getEnabled() {
        return enabled;
    }
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
    @Override
    public String toString() {
        return "PreUsers [created=" + created + ", enabled=" + enabled + ", id=" + id + ", key=" + key
                + ", mailAddress=" + mailAddress + "]";
    }
    
    }
