package lk.wixis.springboot.controller;


import lk.wixis.springboot.dto.UserDTO;
import lk.wixis.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/

@Controller
@RequestMapping( value = "/api")
public class UserController {
//    @Autowired
//    UserDTO dto;

    @Autowired
    UserService service;


@GetMapping( value="/userform")
@ResponseBody
public ModelAndView userView(){
    ModelAndView modelAndView=new ModelAndView("userSave/user_form");
    return modelAndView;

}

    @PostMapping("/userSave")
    @ResponseBody
    public String save(@RequestParam String id, @RequestParam String name, @RequestParam String address,
                       @RequestParam String password) throws Exception {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setAddress(address);
        dto.setPassword(password);

        if (service.addUser(dto)) {
            return "200";
        } else {
            return "500";
        }


    }

    @PutMapping("/userUpdate")
    @ResponseBody
    public String update(@RequestParam String id, @RequestParam String name, @RequestParam String address,
                         @RequestParam String password) throws Exception {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setAddress(address);
        dto.setPassword(password);

        if (service.updateUser(dto)) {
            return "200";
        } else {
            return "500";
        }


    }

    @DeleteMapping("/userDelete")
    @ResponseBody
    public String delete(@RequestParam String id, @RequestParam String name, @RequestParam String address,
                         @RequestParam String password) throws Exception {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setAddress(address);
        dto.setPassword(password);

        if (service.deleteUser(dto)) {
            return "200";
        } else {
            return "500";
        }


    }
//
//    @GetMapping("/userFind/{id}")
//    public UserDTO searchEmployee(@PathVariable("id") ResultSet id) throws SQLException {
////        UserDTO dto = new UserDTO();
//        //  dto.setId(id);
//        return service.searchUser(id);
//    }

//[]
    @GetMapping("/users")
   @ResponseBody
    public ArrayList<UserDTO> getAllUser() {
        ArrayList<UserDTO> allUser = (ArrayList<UserDTO>) service.getAllUsers();
        return allUser;
     //   return service.getAllUsers();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable("id") String id) throws SQLException {
       // return  service.getUser(id);
       return service.getUser(id);
    }






}
