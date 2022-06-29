package com.example.controller;


import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.PreUsers;
import com.example.domain.Users;
import com.example.form.PreUserForm;
import com.example.service.PreUserService;
import com.example.service.UserService;

@Controller
@RequestMapping("/request")
public class UrlRequestController {
    @RequestMapping("")
    public String index(){
        return "urlrequest";
    }

      @Autowired
	private MailSender mailSender;

    @Autowired
	private HttpSession session;
    @Autowired
    private PreUserService service;
    @Autowired
    private UserService userService;

    @RequestMapping("/mailed")
    public String mailSend(PreUserForm form,Model model){
        PreUsers preUsers = service.findByEmail(form.getMailAddress());
        Users users = userService.findByEmail(form.getMailAddress());
        //preuser登録ある時
           if(preUsers != null){
            model.addAttribute("errormessage","入力内容をご確認ください");
            return index();
            //preuser登録ない時
        }else if(preUsers == null){
            session.setAttribute("userEmail", form.getMailAddress());
            //本登録ある時
        }if(users != null){
            return "send";
        }

        String key = UUID.randomUUID().toString();
        session.setAttribute("key", key);
        SimpleMailMessage msg = new SimpleMailMessage();
        
        try{
            msg.setFrom("coffeeShopMaster2022@gmail.com");
            msg.setTo(form.getMailAddress());
            msg.setSubject("ユーザー登録メールの送付");
            msg.setText("http://localhost:8080/user?key="+ key);
            
            mailSender.send(msg);

            PreUsers preUsers2 = new PreUsers();
            preUsers2.setMailAddress(form.getMailAddress());
            preUsers2.setKey((String) session.getAttribute("key"));
            Long datetime = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(datetime);
            preUsers2.setCreated(timestamp);
            service.insert(preUsers2);

        }catch (MailException e) {
			e.printStackTrace();
        }return "send";
        
    }  
    /* @RequestMapping("/Urlclick")
    public String index2(String key){
        session.setAttribute("key", key);

        return "input";

    }*/
}
