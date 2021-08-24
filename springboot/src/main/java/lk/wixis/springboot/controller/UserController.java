package lk.wixis.springboot.controller;

import lk.wixis.springboot.dao.UserDAO;
import lk.wixis.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/
@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
   UserDAO dao;

    @PostMapping("/user")
    public int addUser (@RequestBody User user){

        return  dao.addUser(user);
    }
}
