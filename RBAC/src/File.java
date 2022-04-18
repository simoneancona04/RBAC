import java.util.ArrayList;
import java.util.HashMap;

public class File extends SysElement {
//chiarlo
    private String content;
    private String extension;

    
    public File(String name, String content, String extension, AccessTable act) {
        super(name, act);
        this.content = content;
        this.extension = extension;
    }

    public String getContent() { // per future letture
        return content;
    }

    public void setContent(String content) { // per scrittura
        this.content = content;
    }

    public String getExtension() { 
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }


    
    public boolean accepts(SysElementOperation op){ /* intendevi forse SysElementOperation? */{
        return getAct().permits(name, op);    // ho usato canRead e canWrite, oppure usi getReaders o getWriters
    }


}
