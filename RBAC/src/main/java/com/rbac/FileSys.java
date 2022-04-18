package com.rbac;

import com.fasterxml.jackson.core.JsonParser;

public class FileSys {
    private Directory home; // chiamo home la directory principale che conterrà tutto
    
    public FileSys() {
        ObjectMapper om = new ObjectMapper();
        
    }

    public Directory getHome() {
        return home;
    }

    public Directory goTo(String path) {
        return home.getDirectory(path);
    }
}
