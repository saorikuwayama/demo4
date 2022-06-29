package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Users;
import com.example.repository.UserRepositry;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepositry userRepositry;

    public void insert(Users users){
        userRepositry.insert(users);

    }
    public Users findByEmail(String mailAddress){
        return userRepositry.findByEmail(mailAddress);
    }
}
