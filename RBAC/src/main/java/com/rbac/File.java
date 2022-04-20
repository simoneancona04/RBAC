package com.rbac;

public class File extends SysElement {
    private String content;
    private String extension;

    
    public File(String name, String content, String extension, AccessTable act) {
        super(name, act);
        this.content = content;
        this.extension = extension;
    }
    public File(String name, String content, String extension) {
        super(name);
        this.content = content;
        this.extension = extension;
    }

    public String getContent() {
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
    
    public boolean read(){
        return getAct().canRead(App.currentEntity);
    }

    public boolean write(){
        return getAct().canWrite(App.currentEntity);
    }


}
