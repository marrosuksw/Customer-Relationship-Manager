package com.java.clientmanager.goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Repository
public interface GoalRepository extends JpaRepository<GoalManager, Long>{
    GoalManager findGoalById(int id);
}
