package com.java.clientmanager.goals;

import com.java.clientmanager.MenuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GoalController {
    //if goal tick = true, change bg goal colour to light green

     @Autowired
    private GoalService goalService;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    public GoalController(GoalService goalService, ApplicationContext applicationContext) {
        this.goalService = goalService;
        this.applicationContext = applicationContext;
    }
    //create goal
    //remove goal
    //update goal all with .save()
}
