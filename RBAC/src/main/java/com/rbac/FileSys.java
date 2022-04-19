package com.rbac;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileSys {
    private Directory home; // chiamo home la directory principale che conterrà tutto
    private ObjectMapper om;
    private final String filename = "local/fileSys.json";

    public FileSys() {
        om = new ObjectMapper();
        try {
            home = om.readValue(new java.io.File(filename), Directory.class);
            home.attach();
        } catch (Exception e) {
            home = new Directory("home", (Directory)null);
        }
    }

    public Directory getHome() {
        return home;
    }

    public Directory goTo(String path) {
        return home.getDirectory(path);
    }

    public void save() {
        try {
            om.writeValue(new java.io.File(filename), home);
        } catch (Exception e) {
            
        }
    }

    public ArrayList<File> findFiles(String name, String extension) {
        return home.findFiles(name, extension);
    }

    public ArrayList<Directory> findDirs(String name) {
        return home.findDirs(name);
    }
}
