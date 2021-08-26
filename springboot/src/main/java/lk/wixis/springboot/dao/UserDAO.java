package lk.wixis.springboot.dao;

import lk.wixis.springboot.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/
public interface UserDAO {

   int addUser(User user);

    int deleteUser(User user);
//    User findUser(ResultSet resultSet) throws SQLException;
//User findUser(ResultSet resultSet) throws SQLException;
  User getUser(String id);
   List<User> getAllUsers();

    int updateUser(User user);
}
