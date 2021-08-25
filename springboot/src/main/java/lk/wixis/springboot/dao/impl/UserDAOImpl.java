package lk.wixis.springboot.dao.impl;

import lk.wixis.springboot.dao.UserDAO;
import lk.wixis.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public int deleteUser(User user) {
        //qu

        String deletequery = "DELETE FROM user WHERE id=:id";
       NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", user.getId());
//        mapSqlParameterSource.addValue("name",user.getName());
//        mapSqlParameterSource.addValue("address" ,user.getAddress());
//        mapSqlParameterSource.addValue("password",user.getPassword());

         return namedParameterJdbcTemplate.update(deletequery,mapSqlParameterSource);
        //return jdbcTemplate.update(deletequery);
    }

    @Override
    public User searchUser(ResultSet resultSet) throws SQLException {

       User user=new User();

       user.setId(resultSet.getString("id"));
       user.setName(resultSet.getString("name"));
       user.setAddress(resultSet.getString("address"));
       user.setPassword(resultSet.getString(("password")));
       return user;

    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user WHERE ACTIVE=1";
        List<User> list = null;
        try {
            list = jdbcTemplate.query(sql, new ResultSetExtractor<List<User>>() {
                @Override
                public List<User> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    List<User> listTemp = new ArrayList<>();
                    while (resultSet.next()) {
                        try {
                           // User user = getAllUsers(resultSet);
                          //  listTemp.add(user);
                        } catch (Exception ex) {

                        }
                    }
                    return listTemp;
                }
            });
        } catch (DataAccessException dataAccessException) {
            throw dataAccessException;
        }catch (Exception exception){

        }
        return list;

    }

    @Override
    public int updateUser(User user) {

        String updatequery = "UPDATE user SET name = :name ,address=:address, password=:password WHERE id=:id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        MapSqlParameterSource mapSqlParameterSource=new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", user.getId());
        mapSqlParameterSource.addValue("name",user.getName());
        mapSqlParameterSource.addValue("address" ,user.getAddress());
        mapSqlParameterSource.addValue("password",user.getPassword());

        return namedParameterJdbcTemplate.update(updatequery,mapSqlParameterSource);

    }
}

