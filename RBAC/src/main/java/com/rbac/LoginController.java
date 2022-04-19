package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    private void switchWindow() throws IOException {

        String password = passwordField.getText();
        String username = usernameField.getText();
        System.out.println(username + " " + password);
        
        if (username == null || password == null) return;
        Entity e = App.users.get(username, password);
        
        if (e != null) {
            //App.setRoot("admin");
            App.setRoot("user");
            App.currentEntity = e;
        }

        return;

    }
}
