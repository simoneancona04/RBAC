public class SysElement {
    private AccessTable act;
    private String name;

    public SysElement() {
        this.name = new String();
        this.act = new AccessTable();
    }

    public SysElement(String name, AccessTable act) {
        this.name = name;
        this.act = act;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public AccessTable getAct() {return act;}
    public AccessTable copyAct() {return act.clone();}
    public void setAct(AccessTable act) {this.act = act;}
}
