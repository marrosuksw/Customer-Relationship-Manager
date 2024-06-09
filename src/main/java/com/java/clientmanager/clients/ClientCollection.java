package com.java.clientmanager.clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientCollection /*implements ClientRepository*/ {



    private ClientRepository clientRepository;
    @Autowired
    public ClientCollection(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getClientList() {
        return clientRepository.findAll();
    }


    public int getNumberOfClients(){
        return clientRepository.findAll().size();
    }

}
