package lk.wixis.springboot.service.impl;

import lk.wixis.springboot.dao.impl.UserDAOImpl;
import lk.wixis.springboot.dto.UserDTO;
import lk.wixis.springboot.model.User;
import lk.wixis.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ModelMapper mapper;
//
//    @Autowired
//    private ModelMapper mapper;


    @Override
    public boolean addUser(UserDTO dto) {
        int save = dao.addUser(getUser((dto)));

        if(save==1){
            return true;
        }else {
            return false;
        }



    }
    private User getUser(UserDTO dto){

        return mapper.map(dto, User.class);
    }
    private User getUserId(String id){

        return mapper.map(id, User.class);
    }




    @Override
    public boolean deleteUser(UserDTO dto) {
        int delete = dao.deleteUser(getUser((dto)));

        if(delete==1){
            return true;
        }else {
            return false;
        }



    }

    @Override
    public UserDTO getUser(String id) {
           User user = dao.getUser(id);
        return new UserDTO(user.getId(),user.getName(),user.getAddress(),user.getPassword());
    }

//    @Override
//    public UserDTO getUser(ResultSet resultSet) throws SQLException {
//        User user = dao.findUser(resultSet);
//        return new UserDTO(user.getId(),user.getName(),user.getAddress(),user.getPassword());

//
//    }

//    @Override
//    public UserDTO searchUser(ResultSet id) throws SQLException {
//        User user=dao.searchUser(id);
//        return new UserDTO(user.getId(),user.getName(),user.getAddress(),user.getPassword());
////        User search = dao.searchUser((ResultSet) getUserId((id)));
////
////       return search;
//
//    }

//    @Override
//    public User searchUser(String id) throws SQLException {
//
//        User users = dao.searchUser((ResultSet) getUserId((id)));
////       // dao.searchUser(getUserDTO((id)));
////        User user=new User();
////        return new User(user.getId(),user.getName(),user.getAddress(),user.getPassword());
//        return users;
////    }
//
//    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> uList =dao.getAllUsers();
      List<UserDTO>dtoList =new ArrayList();
        for (User u: uList){
            dtoList.add(new UserDTO(u.getId(),u.getName(),u.getAddress(),u.getPassword()));
        }
        return dtoList;
    }

    @Override
    public boolean updateUser(UserDTO dto) {
        int update = dao.updateUser(getUser((dto)));

        if(update==1){
            return true;
        }else {
            return false;
        }



    }

}
