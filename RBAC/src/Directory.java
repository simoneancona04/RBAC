import java.util.ArrayList;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonParser;

public class Directory extends SysElement {
    @JSONignore
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
        return nodes;
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

    public String getPath() {
        ArrayList<String> path = new ArrayList<String>();
        Directory home = this;
        while(home.parent != null) {
            path.add("/");
            path.add(home.getName());
        }

        String str = "";
        for(int i = path.size() - 1; i > 0; i--) {
            str.concat(path.get(i));
        }

        return str;
    }
}
