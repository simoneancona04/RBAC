package com.rbac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static ArrayList<Entity> users = new ArrayList<Entity>();
    static Entity currentEntity;
    static ArrayList<String> currentDirectoryChildren = new ArrayList<>();
    
    //static Directory currentDirectory;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        FileSys fileSys = new FileSys();
        currentEntity = new Entity("mimmo","123");
        users.add(new Entity("mimmo","123"));
        currentDirectoryChildren.add("file 1");
        currentDirectoryChildren.add("file 2");
        currentDirectoryChildren.add("file 3");
        currentDirectoryChildren.add("file 4");
        currentDirectoryChildren.add("file 5");
        currentDirectoryChildren.add("file 6");
        currentDirectoryChildren.add("file 7");
        currentDirectoryChildren.add("file 8");
        currentDirectoryChildren.add("file 9");
        currentDirectoryChildren.add("file 10");
        currentDirectoryChildren.add("file 11");
        currentDirectoryChildren.add("file 12");
        currentDirectoryChildren.add("uffa 13");
        launch();
    }

}