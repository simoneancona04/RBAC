package com.rbac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static Users users = new Users();
    static FileSys fileSys = new FileSys();
    static Entity currentEntity;
    static ArrayList<String> currentDirectoryChildren = new ArrayList<>();
    
    //static Directory currentDirectory;

    @Override
    public void start(Stage stage) throws IOException {
        if(users.isEmpty())
            scene = new Scene(loadFXML("login"), 800, 600);
        else
            scene = new Scene(loadFXML("registration"));
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

    // Path, Java 7
    private static void printCurrentWorkingDirectory2() {
        String userDirectory = Paths.get("")
                .toAbsolutePath()
                .toString();
        System.out.println(userDirectory);
    }

    public static void main(String[] args) {

        /*
        if(users.isEmpty())
        */
        printCurrentWorkingDirectory2();

        try {
            users.add(new Entity("mimmo","123"));
        } catch (DuplicateName e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        currentEntity = users.get("mimmo", "123");
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