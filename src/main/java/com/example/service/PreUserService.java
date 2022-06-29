package com.example.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.PreUsers;
import com.example.repository.PreUsersRepositry;

@Service
public class PreUserService {
    
    @Autowired
    public PreUsersRepositry repositry;
    //insertする
    public void insert(PreUsers preusers){
        repositry.insert(preusers);
    }
    //プレユーザーテーブルに24時間以内に登録あるか確認
    public PreUsers findByEmail(String mailAddress){
        return repositry.findByEmail(mailAddress);
    }
    public PreUsers findByKey(String key,Timestamp timestamp){
        return repositry.findByKey(key, timestamp);

    }
    }
    
