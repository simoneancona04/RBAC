package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class AdminController {
    @FXML
    private void switchWindow() throws IOException { // servisse
        App.setRoot("admin");
    }

    @FXML
    FlowPane elementContainer;

    @FXML
    protected void initialize() {
        refreshContent();
    }

    public void refreshContent() {
        elementContainer.getChildren().clear();
        for(String f : App.currentDirectoryChildren){   
            elementContainer.getChildren().add(new Button(f));
        }
    }
}