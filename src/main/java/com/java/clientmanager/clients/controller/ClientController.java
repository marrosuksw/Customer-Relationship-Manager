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

    private UpdateClientController updateClientController;
    @Autowired
    public ClientController(ClientCollection clientCollection, MenuController menuController, UpdateClientController updateClientController){
        this.menuController = menuController;
        this.clientCollection = clientCollection;
        this.updateClientController = updateClientController;
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
        if(clientTableView.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Select a client to be removed");
            alert.showAndWait();
            return;
        }
        Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
        clientTableView.getItems().remove(selectedClient);
        clientCollection.removeClient(selectedClient);
    }
    @FXML
    private void updateClient(ActionEvent event){
        if(clientTableView.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Select a client to be updated");
            alert.showAndWait();
            return;
        }
        Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
        updateClientController.setCurrentClient(selectedClient);
        menuController.showUpdateClient();


    }



}

