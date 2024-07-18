package com.java.clientmanager.goals;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class GoalController {

    private GoalService goalService;

    @FXML
    private TextArea textArea;
    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }
    public void writeText(){
        String text = textArea.getText();
        LocalDate date = LocalDate.now();
        GoalManager goal = new GoalManager(date.toString(), text);
        goalService.createGoal(goal);
    }
}
