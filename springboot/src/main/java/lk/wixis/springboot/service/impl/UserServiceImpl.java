package lk.wixis.springboot.service.impl;

import lk.wixis.springboot.dao.impl.UserDAOImpl;
import lk.wixis.springboot.dto.UserDTO;
import lk.wixis.springboot.model.User;
import lk.wixis.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/
// marks a java class as a bean so the component-scanning mechanism of
// spring can pick it up and pull it into the application context.
// it's is also a specialization of the component annotation
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAOImpl dao;



    @Override
    public void addUser(UserDTO dto) {
        dao.addUser(new User(dto.getId(),dto.getName(),dto.getAddress(),dto.getPassword()));

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public UserDTO searchUser(String id) {
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(UserDTO dto) {

    }
}
