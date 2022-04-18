package com.rbac;

import java.io.IOException;
import javafx.fxml.FXML;

public class AdminController {
    @FXML
    private void switchWindow() throws IOException { // servisse
        App.setRoot("admin");
    }
}