package com.java.clientmanager.statistics;

import com.java.clientmanager.clients.Client;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class StatisticsController {


    @FXML
    private Label averageVal;
    @FXML
    private Label totalVal;
    @FXML
    private Label highestGrossVal;

    private Statistics statistics;

    @Autowired
    public StatisticsController(Statistics statistics){
        this.statistics = statistics;
    }

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    public void initialize() {
        updateStatistics();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (Client client : statistics.getClients()) {
            series.getData().add(new XYChart.Data<>(client.getCompanyName(), client.getEstimatedValue()));
        }
        barChart.getData().add(series);

    }

    public void updateStatistics(){
        //BigDecimal totalValue = BigDecimal.valueOf(statistics.getTotalValueOfClients().intValue());
        System.out.println(statistics.getTotalValueOfClients());
        //totalVal.setText(statistics.getTotalValueOfClients().toString());
        totalVal.setText(statistics.getTotalValueOfClients().toString());
        System.out.println(totalVal.getText());


        averageVal.setText(statistics.getAverageValueOfClients().toString());

        Client highestValueClient = statistics.getHighestGrossingClient();
        if(highestValueClient != null ) {
            String combinedStats = (highestValueClient.getCompanyName() + ": " + highestValueClient.getEstimatedValue());
            highestGrossVal.setText(combinedStats);
        }
        else {
            highestGrossVal.setText("N/A");
        }

    }
}
