package com.java.clientmanager.clients.controller;

import com.java.clientmanager.MenuController;
import com.java.clientmanager.clients.ClientCollection;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientController {


    private final ClientCollection clientCollection;

    private final MenuController menuController;

    @Autowired
    public UpdateClientController(ClientCollection clientCollection, MenuController menuController){
        this.clientCollection = clientCollection;
        this.menuController = menuController;
    }

    @FXML
    private TextField companyNameField;
    @FXML
    private TextField ownerNameField;
    @FXML
    private  TextField ownerSurnameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField estimatedValueField;

    public void displayClientView() {
        menuController.showClients();
    }
}
