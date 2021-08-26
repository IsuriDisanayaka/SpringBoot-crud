package lk.wixis.springboot.service;

import lk.wixis.springboot.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/
public interface UserService {
    boolean addUser(UserDTO dto);

    boolean deleteUser(UserDTO dto);

    UserDTO getUser(String id);
  //  UserDTO getUser(ResultSet resultSet) throws SQLException;
     List<UserDTO> getAllUsers();

    boolean updateUser(UserDTO dto);
}
