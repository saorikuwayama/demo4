package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Users;

@Repository
public class UserRepositry {
    @Autowired
	private NamedParameterJdbcTemplate template;
    //@Autowired
	//private PasswordEncoder passwordEncoder;
    
    private static final RowMapper<Users> USERS_ROW_MAPPER  = (rs, i) -> {
        Users users = new Users();
        users.setId(rs.getInt("id"));
        users.setMailAddress(rs.getString("mail_address"));
        users.setName(rs.getString("name"));
        users.setKana(rs.getString("kana"));
        users.setZipcode(rs.getString("zipcode"));
        users.setPhoneNumber(rs.getString("phone_number"));
        users.setPassword(rs.getString("password"));
        users.setRegistDate(rs.getTimestamp("regist_date"));
        users.setRegistUser(rs.getInt("regist_user"));
        users.setUpdateDate(rs.getTimestamp("update_date"));
        users.setUpdateUser(rs.getInt("update_user"));
        users.setDeleteFlg(rs.getInt("del_flg"));
        users.setAddress(rs.getString("address"));

        return users;

    
};
//ここにinsert文
    public void insert(Users users){
        //users.setPassword(passwordEncoder.encode(users.getPassword()));ハッシュ化？
        SqlParameterSource param =new BeanPropertySqlParameterSource(users);
        String sql = "INSERT INTO users(mail_address,name,kana,zipcode,address,phone_number,password,regist_date,update_date,del_flg)"
        +"VALUES(:mailAddress,:name,:kana,:zipcode,:address,:phoneNumber,:password,:registDate,:updateDate,:deleteFlg);";
        template.update(sql, param);


        }
        //Emailあるか確認
        public Users findByEmail(String mailAddress){
            System.out.println(mailAddress);
            String sql = "SELECT * from users WHERE mail_address=:mailAddress";
            SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress);
            List<Users>userList = template.query(sql,param,USERS_ROW_MAPPER);
            if(userList.size()== 0){
                return null;
            }
            return userList.get(0);
        }

}