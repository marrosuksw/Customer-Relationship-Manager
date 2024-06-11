package com.java.clientmanager.clients;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class ClientController {

    @Autowired
    private ClientCollection clientCollection;

    @Autowired
    private ApplicationContext applicationContext;

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
    public ClientController(ClientCollection clientCollection, ApplicationContext applicationContext){
        this.clientCollection = clientCollection;
        this.applicationContext = applicationContext;
    }
    private void loadClientData() {
        List<Client> clients = clientCollection.getClientList();
        clientTableView.getItems().setAll(clients);
    }
}
