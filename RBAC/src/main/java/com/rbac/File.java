package com.rbac;

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



    // ssecondo te ci sta tipo in syselement un attributo: data di creazione, ultima modifica?
    //secondo me si, ma avevamo detto che sarebbero state cose da aggiungere più avanti, volendo. ma comunque non ci starebbero male
    // ok, cmq, non riesco a fare quasi niente senza intellisense, esco da live share
    //va bene, faccio un commit così hai la roba più recente, ok
    
    public boolean read(){
        return getAct().canRead(App.currentEntity);
    }

    public boolean write(){
        return getAct().canWrite(App.currentEntity);
    }


}
