package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class UserController {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    FlowPane elementContainer;

    @FXML
    protected void initialize() {
        refreshContent();
    }

    public void refreshContent() {
        elementContainer.getChildren().clear();
        for(Directory f : App.currentDirectory.getDirectories()){   
            elementContainer.getChildren().add(new Button(f.getName()));
        }
    }


    @FXML
    private void switchWindow() throws IOException {
        App.setRoot("login");
    }


}
