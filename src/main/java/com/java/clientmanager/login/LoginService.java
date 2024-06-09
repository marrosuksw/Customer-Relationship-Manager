package com.java.clientmanager.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

import static javax.swing.UIManager.getString;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public void findUsername(String givenUsername) {
        Login login = loginRepository.findByUsername(givenUsername);

    }
    public void findPassword(){

    }

}
