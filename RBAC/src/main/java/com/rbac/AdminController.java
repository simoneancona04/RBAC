package com.rbac;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    Label usernameLabel;

    @FXML
    TextField pathField;


    public void refreshContent(){
        pathField.setText(App.currentDirectory.getPath());

        Button tmp;
        elementContainer.getChildren().clear();
        for(Directory folder : App.currentDirectory.getDirectories()){
            tmp = new Button("(folder) " + folder.getName());
            elementContainer.getChildren().add(tmp);
        }

        for(File file : App.currentDirectory.getFiles()){
            tmp = new Button("(file) " + file.getName());
            elementContainer.getChildren().add(tmp);
        }
    }
    
    @FXML
    public void initialize() {

        usernameLabel.setText("Benvenuto " + App.currentEntity.getName());


        Button tmp;
        for(EntityOperation op :App.currentEntity.getOperations()){
            switch(op){
                case ADD_NEW_USER:
                    tmp = new Button("Nuovo utente");
                    tmp.setOnAction(e->App.setRoot("registration"));
                    usrActionContainer.getChildren().add(tmp);
                break;
                default:
                break;
                

                
            }
        }
        tmp = new Button("Nuovo");
        tmp.setOnAction(e->{
            //if(App.currentDirectory.getAct().canWrite(App.currentEntity)) // TODO anco
                App.setRoot("createSysElement");
            
        });
        fileActionContainer.getChildren().add(tmp);

        refreshContent();
        
    }

    @FXML
    public void goTo() {
        Directory dir = App.fileSys.getHome().getDirectory(pathField.getText());
        if(dir != null){
            //TODO anco directory non esistente
            //if(dir.getAct().canRead(App.currentEntity)){ //TODO anco canread
            //TODO anco directory non accessibile

                App.currentDirectory = dir;
                refreshContent();

            //}
        }
    }
}