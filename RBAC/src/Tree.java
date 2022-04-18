import java.util.ArrayList;

public class Tree {
    //chiarlo

    
    private String name;
    private Tree parent;
    private ArrayList<Tree> children;


    public Tree(String name) { //solo per creare la root,che non ha padre
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }
 
    public Tree(String name, Tree parent) {
        this.name = name;
        this.parent = parent;
        this.children = new ArrayList<>();
    }



    public void addChild(Tree child) {
        children.add(child);
    }


    public void addChild(String childName) {
        children.add(new Tree(childName,this)); // do come genitore l'albero che ha creato il figlio
    }

    
    //setter e getter vari
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }
 
    public ArrayList<Tree> getChildren() {
        return children;
    }

    public void setChildren( ArrayList<Tree> children ){
        this.children = children;
    }
 
 
}
