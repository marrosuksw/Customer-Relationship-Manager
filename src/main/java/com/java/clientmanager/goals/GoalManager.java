package com.java.clientmanager.goals;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class GoalManager {
    @Id
    @GeneratedValue
    private Long id;
    private String goalName;
    private String goalText;
    private boolean goalTick;
    private final int characterTextLimit = 256;
    private final int characterNameLimit = 64;


    public GoalManager(String goalName, String goalText, boolean goalTick){
        this.goalName = goalName;
        this.goalText = goalText;
        this.goalTick = goalTick;
    }


    public boolean createGoal() {
        // frontend interactions needed
        /*
        - check if goalName is shorter than 32
        - check if goalText is shorter than 256
         */
        return true;
    }


    public boolean isGoalTick() {
        return goalTick;
    }

    public void setGoalTick(boolean goalTick) {
        this.goalTick = goalTick;
    }

    public String getGoalText() {
        return goalText;
    }

    public void setGoalText(String goalText) {
        this.goalText = goalText;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Long getId() {
        return id;
    }
}
