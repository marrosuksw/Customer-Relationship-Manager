package com.java.clientmanager.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    public Login findLogin() {
        Login login = loginRepository.findById(0);
        System.out.println(login.getUsername());
        if(login == null){
            System.out.println("it's empty");
            return null;
        }
        return login;
    }


}
