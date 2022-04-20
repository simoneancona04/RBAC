package com.rbac;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateSysElementController {

    @FXML
    TextField nameField;

    @FXML
    TextField extensionField;

    @FXML
    private void newFile() throws IOException{
        String name = nameField.getText();
        String extension = extensionField.getText();

        if(name != "" && extension != ""){
            try {
                App.currentDirectory.addFile(new File(name,"",extension));
                App.mainScene();
            } catch (DuplicateName e) {
                // TODO chiarlo alert se esiste già
                e.printStackTrace();
            }
        }
    }


    @FXML
    private void newDirectory() throws IOException{
        String name = nameField.getText();

        if(name != "" ){
            try {
                App.currentDirectory.addDirectory(new Directory(name,App.currentDirectory));
                App.mainScene();

            } catch (DuplicateName e) {
                // TODO chiarlo se esiste già
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void cancel() throws IOException {
        App.mainScene();
    }
}
