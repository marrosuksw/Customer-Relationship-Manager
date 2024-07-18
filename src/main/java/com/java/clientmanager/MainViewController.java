package com.java.clientmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainViewController {

    private MenuController menuController;

    @Autowired
    public MainViewController(MenuController menuController){
        this.menuController = menuController;
    }
}
