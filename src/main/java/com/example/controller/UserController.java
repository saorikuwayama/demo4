package com.example.controller;

import java.sql.Timestamp;
import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.PreUsers;
import com.example.domain.Users;
import com.example.form.UserForm;
import com.example.service.PreUserService;
import com.example.service.TimeService;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private PreUserService preUserService;
    @Autowired
    private HttpSession session;
    //初期表示
    @RequestMapping("") 
    public String index(String key)throws ParseException{
        //24時間前の日付取得
        Timestamp time = timeService.minustime();
        //URL発行から24時間経過していたらユーザ登録失敗画面へ
        PreUsers pre = preUserService.findByKey(key,time);
        if(pre ==null){
            System.out.println("本登録用URLが無効です。登録用URLリクエスト画面から再度お試しください");
            return "register_fail";
        }
        //keyを検索値にpre_userからmailを持ってくる
        String mail = pre.getMailAddress();
        session.setAttribute("mail", mail);        
        return "input";
    }
    @ModelAttribute
	public UserForm setUpUserForm() {
		return new UserForm();
	}

    //ここから下登録ボタン押下後insertしてページ遷移
    @RequestMapping("/finished")
    public String insert(UserForm form,BindingResult result){

        Users users = new Users();
        
        users.setName(form.getName());
        users.setKana(form.getKana());
        users.setZipcode(form.getZipcode());
        users.setAddress(form.getAddress());
        users.setPhoneNumber(form.getPhoneNumber());
        users.setPassword(form.getPassword());
        //仮
        users.setMailAddress("mail");
        //現在時刻
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        users.setRegistDate(timestamp);
        users.setUpdateDate(timestamp);
        users.setDeleteFlg(0);
        userService.insert(users);

        return "finished";

}}
