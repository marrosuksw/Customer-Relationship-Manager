package com.java.clientmanager.goals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    private GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository){
        this.goalRepository = goalRepository;
    }
    //create goal
    //remove goal
    //update goal all with .save()
    public void createGoal(){

    }
}

