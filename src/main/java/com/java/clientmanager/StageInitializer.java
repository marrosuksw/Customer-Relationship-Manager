package com.java.clientmanager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<MenuApplication.StageReadyEvent> {
    @Value("classpath:/login.fxml")
    private Resource menuResource;
    private String applicationTitle;
    private ApplicationContext applicationContext;

    public StageInitializer(@Value("${spring.application.ui.title}") String applicationTitle, ApplicationContext applicationContext){
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(MenuApplication.StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(menuResource.getURL());
            fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
            Parent parent = fxmlLoader.load();
            Stage stage = event.getStage();
            stage.getIcons().add(new Image("file:C:\\Users\\marce\\Desktop\\bpmtb.png"));
            stage.setScene(new Scene(parent, 479, 406));
            stage.setTitle((applicationTitle));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getCause());
            throw new RuntimeException();
        }

    }
}
