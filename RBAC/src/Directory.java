import java.util.ArrayList;

import javax.swing.DefaultRowSorter;

public class Directory extends SysElement {
    private Directory parent;
    private ArrayList<Directory> nodes;
    private ArrayList<File> files;
    
    public Directory(String name, AccessTable act) {
        super(name, act);
        parent = null;
    }

    public Directory(String name, Directory parent) {
        super(name, parent.getAct().clone());
    }

    public void addDirectory(Directory directory) {
        nodes.add(directory);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public Directory getParent() {
        return parent;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public ArrayList<Directory> getDirectories() {
        return directories;
    }
}
