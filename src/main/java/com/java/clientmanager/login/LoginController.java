package com.java.clientmanager.login;
import com.java.clientmanager.MenuController;
import com.java.clientmanager.StageInitializer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label label;

    @FXML
    private Button button;

    @Autowired
    private LoginService loginService;

    @Autowired
    private StageInitializer stageInitializer;

    @Autowired
    ApplicationContext applicationContext;
    @Value("classpath:/menu.fxml")
    private Resource menuResource;

    @Autowired
    public LoginController(StageInitializer stageInitializer, LoginService loginService, ApplicationContext applicationContext){
        this.stageInitializer = stageInitializer;
        this.loginService = loginService;
        this.applicationContext = applicationContext;
    }

    public boolean buttonVerifyLoginData(){
        Login login = loginService.findLogin();
        if(login == null) {
            return false;
        }
        if(login.getPassword().equals(passwordField.getText()) && login.getUsername().equals(usernameField.getText())){
            return true;
        }
        return false;
    }
    @FXML
    public void switchToMainMenu(ActionEvent event) throws IOException {
        try {
        if (!buttonVerifyLoginData()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter correct information");
            alert.showAndWait();
            return;
        }

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/menu.fxml"));
                loader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
                Parent root = loader.load(); // This line loads the FXML and its controller automatically
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                System.out.println(e.getCause());
                throw new RuntimeException();
            }
        }

}
