package com.java.clientmanager;
import com.java.clientmanager.clients.ClientController;
import com.java.clientmanager.goals.GoalController;
import com.java.clientmanager.statistics.StatisticsController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import javafx.event.ActionEvent;
import java.io.IOException;


@Component
public class MenuController {
    @FXML
    private TextField textField;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane menuPane;

    @FXML
    private AnchorPane dynamicPane;

    @Autowired
    private ClientController clientController;

    @Autowired
    private GoalController goalController;

    @Autowired
    private StatisticsController statisticsController;

    @Autowired
    private StageInitializer stageInitializer;

    public void onButtonPress(){
        System.out.println("LOGOUT PRESSED");
    }
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MainViewController mainViewController;

    @Value("classpath:/login.fxml")
    private Resource loginResource;
    @Autowired
    public MenuController(ApplicationContext applicationContext, StageInitializer stageInitializer,
    GoalController goalController, ClientController clientController, StatisticsController statisticsController,
                          MainViewController mainViewController){
        this.mainViewController = mainViewController;
        this.stageInitializer = stageInitializer;
        this.applicationContext = applicationContext;
        this.clientController = clientController;
        this.goalController = goalController;
        this.statisticsController = statisticsController;
    }
    //create some main menu side class?
    public void showMainView(){
        loadContent("/mainView.fxml");
    }

    public void showClients() {
        loadContent("/clients.fxml");
    }


    public void showStatistics() {
        loadContent("/statistics.fxml");
    }


    public void showGoals() {
        loadContent("/goals.fxml");
    }
    private void loadContent(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            loader.setControllerFactory(applicationContext::getBean);
            AnchorPane newContent = loader.load();
            dynamicPane.getChildren().setAll(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void logOut(ActionEvent event) throws IOException {
        //AnchorPane pane = FXMLLoader.load(getClass().getResource("/menu.fxml"));
        Platform.exit();
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
//                loader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
//                Parent root = loader.load(); // This line loads the FXML and its controller automatically
//                Stage stage = new Stage();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.centerOnScreen();
//                stage.show();
//            } catch (IOException e) {
//                System.out.println(e.getCause());
//                throw new RuntimeException();
//        }
    }
}
