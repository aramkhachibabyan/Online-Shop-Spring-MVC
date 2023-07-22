package com.smartCode.springMvc.service.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void register(String name, String lastname, String email, String password, int age);

    void login(String email, String password) ;

    void deleteUser(String email,String password) ;
    void updateUser(String email,String newPassword, String repeatPassword) ;

}
