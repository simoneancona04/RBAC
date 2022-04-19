package com.rbac;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class AdminController {
    

    @FXML
    FlowPane elementContainer;

    @FXML
    HBox fileActionContainer;

    @FXML
    HBox usrActionContainer;
    
    @FXML
    public void initialize() {
        for(EntityOperation op :App.currentEntity.getOperations()){
            switch(op){
                case ADD_NEW_USER:
                Button tmp = new Button("add new user");
                tmp.setOnAction(e->App.setRoot("registration"));
                usrActionContainer.getChildren().add(tmp);
                break;
            }
        }


        
        elementContainer.getChildren().clear();
        for(String f : App.currentDirectoryChildren){
            
            Button tmp = new Button(f);
            //tmp.setOnAction(arg0);
            elementContainer.getChildren().add(tmp);
        }
    }
}