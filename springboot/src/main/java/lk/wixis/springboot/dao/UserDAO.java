package lk.wixis.springboot.dao;

import lk.wixis.springboot.dto.UserDTO;
import lk.wixis.springboot.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/
public interface UserDAO {

   int addUser(User user);

    void deleteUser(String id);

    User searchUser(String id);

    ArrayList<User> getAllUsers();

    void updateUser(UserDTO dto);
}
