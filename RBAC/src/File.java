import java.util.ArrayList;
import java.util.HashMap;

public class File extends SysElement {
//chiarlo
    private String content;
    
    public File(String name, String content, AccessTable act) {
        super(name, act);
        this.content = content;
    }

    public String getContent() { // per future letture
        return content;
    }

    public void setContent(String content) { // per scrittura
        this.content = content;
    }

    public boolean accepts(String name, Operation mode){
        return getAct().permits(name, mode);
    }


}
