package com.rbac;
import java.io.IOException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileSys {
    private Directory home; // chiamo home la directory principale che conterrà tutto
    private ObjectMapper om;
    private final String filename = "local/fileSys.json";

    public FileSys() {
        om = new ObjectMapper();
        try {
            om.readValue(new java.io.File(filename), Directory.class);
        } catch (Exception e) {
            
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
}
