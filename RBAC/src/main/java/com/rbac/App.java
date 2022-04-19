package com.rbac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static Users users = new Users();
    static FileSys fileSys = new FileSys();
    static Entity currentEntity;
    static Directory currentDirectory;

    @Override
    public void start(Stage stage) throws IOException {
        if(!users.isEmpty())
            scene = new Scene(loadFXML("login"), 800, 600);
        else
            scene = new Scene(loadFXML("registration"), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) {
        try{
            scene.setRoot(loadFXML(fxml));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    static void mainScene() throws IOException {
        if(currentEntity.isAdmin()) scene.setRoot(loadFXML("admin"));
        else scene.setRoot(loadFXML("user"));
    }

    @Override
    public void stop() {
        users.save();
        fileSys.save();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        currentEntity = users.get("mimmo", "123");
        currentDirectory = fileSys.getHome();
        launch();
    }

}