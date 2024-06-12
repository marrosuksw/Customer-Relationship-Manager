package com.java.clientmanager.statistics;
import com.java.clientmanager.clients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class Statistics {
    //number of customers
    //total income from all customers
    //average income
    // other ideas welcome

    //component clientCollection implemented
    private final ClientCollection clientCollection;

    @Autowired
    public Statistics(ClientCollection clientCollection) {
        this.clientCollection = clientCollection;
    }


    //total income from all clients
    public BigDecimal getTotalValueOfClients() {
        int size = clientCollection.getNumberOfClients();
        return BigDecimal.valueOf(size);
    }


    //average value of income from all clients
    public BigDecimal getAverageValueOfClients(){
        BigDecimal decimal = getTotalValueOfClients();
        int size = clientCollection.getNumberOfClients();
        BigDecimal averageValue = decimal.divide(BigDecimal.valueOf(size));
        return averageValue;
    }


    //highest grossing client in terms of estimated value
    public Client getHighestGrossingClient(){
        Client highestGrossClient = new Client();
        BigDecimal highestPay = new BigDecimal(0);
        for(Client client : clientCollection.getClientList()) {
            if (client.getEstimatedValue().compareTo(highestPay) > 0) {
                highestPay = client.getEstimatedValue();
                highestGrossClient = client;
            }
        }
        return highestGrossClient;
    }



    //ClientCollection list = new ClientCollection();
}
