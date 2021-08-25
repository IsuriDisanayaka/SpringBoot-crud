package lk.wixis.springboot.service;

import lk.wixis.springboot.dto.UserDTO;
import lk.wixis.springboot.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/
public interface UserService {
    boolean addUser(UserDTO dto);

    boolean deleteUser(UserDTO dto);

    User searchUser(String id) throws SQLException;
     UserDTO searchUser(ResultSet id) throws SQLException;

    ArrayList<UserDTO> getAllUsers();

 boolean updateUser(UserDTO dto);
}
