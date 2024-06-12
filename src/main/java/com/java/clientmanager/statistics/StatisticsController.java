package com.java.clientmanager.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsController {


    private Statistics statistics;

    @Autowired
    public StatisticsController(Statistics statistics){
        this.statistics = statistics;
    }



    //three fields with: highest grossing client, average value of all income, highest grossing client

    // axis column chart with each client company name (x) and income value (y)

    // axis chart with
}
