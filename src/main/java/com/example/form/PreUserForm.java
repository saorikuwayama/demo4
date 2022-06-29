package com.example.form;

import com.example.domain.PreUsers;

public class PreUserForm {
    private String mailAddress;

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public String toString() {
        return "PreUserForm [mailAddress=" + mailAddress + "]";
    }
    
    
}
