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
        // boolean admin = checkBox.
        try {
            App.users.add(new Entity(user, pass));
        } catch (DuplicateName e) {
            // TODO:
        }
    }

    @FXML
    private void cancel() throws IOException {
        App.setRoot("user");
    }
}
