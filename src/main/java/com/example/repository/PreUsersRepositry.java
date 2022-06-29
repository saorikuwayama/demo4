package com.example.repository;


import java.sql.Timestamp;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.PreUsers;

@Repository
public class PreUsersRepositry {
    @Autowired
	private NamedParameterJdbcTemplate template;

    private static final RowMapper<PreUsers> PREUSER_ROW_MAPPER  = (rs, i) -> {
		PreUsers preusers = new PreUsers();
		preusers.setId(rs.getInt("id"));
		preusers.setMailAddress(rs.getString("mail_address"));
		preusers.setKey(rs.getString("key"));
        preusers.setEnabled(rs.getInt("enabled"));
        preusers.setCreated(rs.getTimestamp("created"));
        return preusers;
	};

    //登録nullかそうじゃないか返す
    public PreUsers findByEmail(String mailAddress){
        System.out.println(mailAddress);
        String sql = "SELECT * from pre_users WHERE mail_address=:mailAddress";
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress);
        List<PreUsers>preUserList = template.query(sql,param,PREUSER_ROW_MAPPER);
        if(preUserList.size()== 0){
            return null;
        }
        return preUserList.get(0);
    }


    //仮登録のinsert
    public void insert(PreUsers preusers){
        SqlParameterSource param = new BeanPropertySqlParameterSource(preusers);
        String sql ="INSERT INTO pre_users(mail_address,key,enabled,created) VALUES(:mailAddress,:key,0,:created);";
        template.update(sql, param);
    }

    //24時間以内かどうかを返す
    public PreUsers findByKey(String key,Timestamp timestamp){
        String sql = "SELECT * FROM pre_users where key=:key AND created>=:time AND enabled=0";
        SqlParameterSource param = new MapSqlParameterSource().addValue("key", key).addValue("time", timestamp);
        List<PreUsers>preList = template.query(sql, param, PREUSER_ROW_MAPPER);
        if(preList.size()==0){
            return null;
        }
        return preList.get(0);
    }

    //登録完了後にpreuserテーブルの有効フラグ変えるupdate
    //public void update(PreUsers preusers){
    //    SqlParameterSource param = BeanPropertySqlParameterSource(preusers);
    //    String updatesql ="UPDATE pre_users SET enabled = 1 WHERE key=:key";
    //}




    

}
