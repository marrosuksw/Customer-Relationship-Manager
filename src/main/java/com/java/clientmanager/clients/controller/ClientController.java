package com.java.clientmanager.clients.controller;

import com.java.clientmanager.clients.Client;
import com.java.clientmanager.clients.ClientCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import com.java.clientmanager.MenuController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class ClientController {

    private ClientCollection clientCollection;

    private final MenuController menuController;

    @Value("classpath:/addClient.fxml")
    private Resource addClientView;

    @FXML
    private TableView<Client> clientTableView;
    @FXML
    private TableColumn<Client, String> companyName;
    @FXML
    private TableColumn<Client, String> ownerName;
    @FXML
    private TableColumn<Client, String> ownerSurname;
    @FXML
    private TableColumn<Client, String> phoneNumber;
    @FXML
    private TableColumn<Client, String> emailAddress;
    @FXML
    private TableColumn<Client, LocalDate> creationDate;
    @FXML
    private TableColumn<Client, BigDecimal> estimatedValue;

    @FXML
    private Button addClient;
    @FXML
    private void initialize(){
        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        ownerName.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        ownerSurname.setCellValueFactory(new PropertyValueFactory<>("ownerSurname"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailAddress.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        creationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        estimatedValue.setCellValueFactory(new PropertyValueFactory<>("estimatedValue"));
        loadClientData();
    }

    @Autowired
    public ClientController(ClientCollection clientCollection, MenuController menuController){
        this.menuController = menuController;
        this.clientCollection = clientCollection;
    }

    private void loadClientData() {
        List<Client> clients = clientCollection.getClientList();
        clientTableView.getItems().setAll(clients);
    }

    @FXML
    private void addClient(ActionEvent event){
        menuController.showAddClient();
    }

    @FXML
    private void removeClient(ActionEvent event) {
        Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
        clientTableView.getItems().remove(selectedClient);
        clientCollection.removeClient(selectedClient);
    }
    @FXML
    private void updateClient(ActionEvent event){
        Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();

    }



}

