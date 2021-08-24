package lk.wixis.springboot.service;

import lk.wixis.springboot.dto.UserDTO;

import java.util.ArrayList;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/
public interface UserService {
    void addUser(UserDTO dto);

    void deleteUser(String id);

    UserDTO searchUser(String id);

    ArrayList<UserDTO> getAllUsers();

    void updateUser(UserDTO dto);
}
