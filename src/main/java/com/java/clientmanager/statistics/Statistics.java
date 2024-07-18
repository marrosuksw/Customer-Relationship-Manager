package com.java.clientmanager.statistics;
import com.java.clientmanager.clients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class Statistics {

    //component clientCollection implemented
    private final ClientCollection clientCollection;

    @Autowired
    public Statistics(ClientCollection clientCollection) {
        this.clientCollection = clientCollection;
    }

    private BigDecimal currentTotalValue;


    //total income from all clients
    public BigDecimal getTotalValueOfClients() {
        ArrayList<BigDecimal> decimalList = new ArrayList<>();
        for(Client client : clientCollection.getClientList()){
            decimalList.add(client.getEstimatedValue());
        }
        currentTotalValue = new BigDecimal(0);
        BigDecimal addBigDecimals = decimalList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return addBigDecimals;
    }
    //average value of income from all clients
    public BigDecimal getAverageValueOfClients(){
        int size = clientCollection.getNumberOfClients();
        if(size == 0 ) return BigDecimal.valueOf(0);
        BigDecimal total = getTotalValueOfClients();
        BigDecimal average = total.divide(BigDecimal.valueOf(size), 2, RoundingMode.HALF_UP);
        return average;
    }
    public List<Client> getClients(){
        return clientCollection.getClientList();
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


}
