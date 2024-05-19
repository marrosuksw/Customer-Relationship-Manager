package com.java.clientmanager.clients;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class ClientCollection /*implements ClientRepository*/ {

    private ArrayList<Client> clientList = new ArrayList<>();
    //ArrayList of Clients
    
    //implement singleton? - Component is singleton
    private Client client = new Client();
    public ArrayList<Client> getClientList() {
        return clientList;
    }
    //add client method that uses a createClient method to add Client to the ArrayList

    //remove client that deletes a Client from the ArrayList and overall

    public void addClientToList(Client client){
        clientList.add(client);
    }

    public boolean removeClientFromList(Client client){
        return clientList.remove(client);
    }


    //getNumberOfClients
    public int getNumberOfClients(){
        return clientList.size();
    }

}
