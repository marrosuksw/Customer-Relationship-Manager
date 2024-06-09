package com.java.clientmanager.login;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
        Login findByUsername(String username);
}
