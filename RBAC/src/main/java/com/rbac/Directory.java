package com.rbac;

import java.util.ArrayList;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.*;


public class Directory extends SysElement {
    
    @JsonIgnore
    private Directory parent;
    private ArrayList<Directory> nodes;
    private ArrayList<File> files;
    
    @JsonCreator
    public Directory(@JsonProperty("name") String name, @JsonProperty("act") AccessTable act) {
        super(name, act);
        parent = null;
        nodes = new ArrayList<Directory>();
        files = new ArrayList<File>();
    }

    public Directory(String name, Directory parent) {
        super(name, new AccessTable());
        nodes = new ArrayList<Directory>();
        files = new ArrayList<File>();
        if(parent != null){
            setAct(parent.copyAct());
            this.parent = parent;
        }
        
    }

    /**
     * Aggiungi una nuova cartella
     * @param directory cartella da aggiungere
     * @throws DuplicateName non possono esserci cartella con lo stesso nome
     */
    public void addDirectory(Directory directory) throws DuplicateName {
        if(containsDir(directory)) throw new DuplicateName();
        nodes.add(directory);
    }

    public void addFile(File file) throws DuplicateName {
        if(containsFile(file)) throw new DuplicateName();
        files.add(file);
    }


    public boolean containsDir(Directory dir) {
        for (Directory node : nodes) {
            if(node.getName().equals(dir.getName())) return true;
        }

        return false;
    }

    public boolean containsFile(File f) {
        for (File file : files) {
            if(file.getName().equals(f.getName()) && file.getExtension().equals(f.getExtension())) return true;
        }
        return false;
    }

    public Directory getParent() {
        return parent;
    }

    private void setParent(Directory parent) {
        this.parent = parent;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void  setFiles( ArrayList<File> files){
        this.files = files;
    }

    public ArrayList<Directory> getDirectories() {
        return nodes;
    }

    public void setDirectories(ArrayList<Directory> nodes){
        this.nodes = nodes;
    }

    public Directory getDirectory(String path) {
        String[] address = path.split("/");
        if(address.length == 0) return null;
        if(address.length == 1) {
            for(Directory dir : nodes) {
                if(dir.getName().equals(address[0])) return dir;
            }
            return null;
        }
        for(Directory dir : nodes) {
            if(dir.getName().equals(address[0])) {
                return getDirectory(Arrays.copyOfRange(address, 1, address.length));
            }
        }
        return null;
    }

    public Directory getDirectory(String[] path) {
        if(path.length == 0) return null;
        if(path.length == 1) {
            for(Directory dir : nodes) {
                if(dir.getName().equals(path[0]))
                    return dir;

            }
            return null;
        }
        for(Directory dir : nodes) {
            if(dir.getName().equals(path[0])) {
                return getDirectory(Arrays.copyOfRange(path, 1, path.length));
            }
        }
        return null;
    }

    @JsonIgnore
    public String getPath() {
        ArrayList<String> path = new ArrayList<String>();
        Directory home = this;
        
        while(home.parent != null) {
            path.add("/");
            path.add(home.getName());
            home = home.parent;
        }

        String str = "";
        for(int i = path.size() - 1; i >= 0; i--) {
            str = str.concat(path.get(i));
        }

        return str;
    }

    public ArrayList<File> findFiles(String name, String extension) {
        ArrayList<File> files = new ArrayList<File>();
        for(File file : files) {
            if(file.getName().equals(name) && file.getExtension().equals(extension))
                files.add(file);
        }
        for(Directory dir : nodes) {
            files.addAll(dir.findFiles(name, extension));
        }
        return files;
    }

    public ArrayList<Directory> findDirs(String name) {
        ArrayList<Directory> dirs = new ArrayList<>();
        for(Directory dir : nodes) {
            if(dir.getName().equals(name))
                dirs.add(dir);
        }
        for(Directory dir : nodes) {
            dirs.addAll(dir.findDirs(name));
        }
        return dirs;
    }

    public void attach() {
        for(Directory dir : nodes) {
            dir.parent = this;
            dir.attach();
        }
    }
}
