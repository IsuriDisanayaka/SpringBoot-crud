package lk.wixis.springboot.dto;


import org.springframework.data.annotation.Id;

/**
 * @author : Isuri Disanayaka
 * @date:23/08/2021
 * @since : 0.0.1
 **/

public class UserDTO {

        private String id;
        private String name;
        private String address;
        private String password;

        public UserDTO() {
        }

        public UserDTO(String id, String name, String address, String password) {
                this.id = id;
                this.name = name;
                this.address = address;
                this.password = password;
        }



        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}
