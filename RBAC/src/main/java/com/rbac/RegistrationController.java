package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationController {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    CheckBox checkBox;

    @FXML
    private void createEntity() throws IOException {
        String user = usernameField.getText();
        String pass = passwordField.getText();
        boolean admin = checkBox.isSelected();
        Entity entity = new Entity(user, pass, admin);
        try {
            App.users.add(entity);
        } catch (DuplicateName e) {
            // TODO chiarlo
        }
        
        if(App.currentEntity==null) {
            App.currentEntity = entity;
        }
        App.mainScene();
    }

    @FXML
    private void cancel() throws IOException {
        App.mainScene();
    }
}
