package com.java.clientmanager;
import com.java.clientmanager.clients.ClientCollection;
import com.java.clientmanager.goals.*;
import com.java.clientmanager.statistics.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MenuController {
    @FXML
    private TextField textField;

    @Autowired
    private StageInitializer stageInitializer;

    @Autowired
    public MenuController(){}
}
