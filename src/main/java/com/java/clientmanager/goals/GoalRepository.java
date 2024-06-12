package com.java.clientmanager.goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GoalRepository extends JpaRepository<GoalManager, Long>{
    GoalManager findGoalById(int id);
}
