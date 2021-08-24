package lk.wixis.springboot.dao.impl;

import lk.wixis.springboot.dao.UserDAO;
import lk.wixis.springboot.dto.UserDTO;
import lk.wixis.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int addUser(User user) {
        //que
        String savequery = "INSERT INTO user(id,name,address,password) VALUES(:id,:name, :address, :password)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();
         mapSqlParameterSource.addValue("id", user.getId());
         mapSqlParameterSource.addValue("name",user.getName());
         mapSqlParameterSource.addValue("address" ,user.getAddress());
         mapSqlParameterSource.addValue("password",user.getPassword());

        return namedParameterJdbcTemplate.update(savequery,mapSqlParameterSource);
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public User searchUser(String id) {
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(UserDTO dto) {


    }
}

