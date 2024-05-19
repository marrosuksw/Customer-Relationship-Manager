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
        System.out.println("Component Statistics zostal utworzony i zaladowany do systemu");
        this.clientCollection = clientCollection;
    }

    public BigDecimal getTotalValueOfClients() {
        int size = clientCollection.getNumberOfClients();
        
        return BigDecimal.valueOf(1);
    }
    public BigDecimal getAverageValueOfClients(){
        BigDecimal decimal = getTotalValueOfClients();
        int size = clientCollection.getNumberOfClients();
        BigDecimal averageValue = decimal.divide(BigDecimal.valueOf(size));
        return averageValue;
    }
    public void getHighestGrossingClient(){

    }



    //ClientCollection list = new ClientCollection();
}
