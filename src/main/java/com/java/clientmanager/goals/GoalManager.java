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

    public GoalManager(){}

    public GoalManager(String goalName, String goalText){
        this.goalName = goalName;
        this.goalText = goalText;
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
