package com.java.clientmanager.clients;
import com.java.clientmanager.clients.controller.UpdateClientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientCollection {

    private final ClientRepository clientRepository;

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

    public void addClient(Client client){
        clientRepository.save(client);
    }


    public void removeClient(Client client){
        clientRepository.delete(client);
    }
    public void updateClientById(Client client){
        clientRepository.findById(client.getId());
        clientRepository.save(client);
    }
}
