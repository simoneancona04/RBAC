public class Directory extends SysElement {
    private Tree home;
    
    public Directory(String name, AccessTable act) {
        super(name, act);
        home = new Tree();
    }
}
