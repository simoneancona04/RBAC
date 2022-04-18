import java.util.ArrayList;
import java.util.HashMap;

public class AccessTable {
    private HashMap<SysElementOperation, ArrayList<Entity>> table;
    
    public AccessTable() {
        table = new HashMap<SysElementOperation, ArrayList<Entity>>();
        table.put(SysElementOperation.READ, new ArrayList<Entity>());
        table.put(SysElementOperation.WRITE, new ArrayList<Entity>());
    }

    public boolean canRead(Entity entity) {
        table.get(SysElementOperation.READ).contains(entity);
    }

    public boolean canWrite(Entity entity) {
        table.get(SysElementOperation.WRITE).contains(entity);
    }

    public ArrayList<Entity> getReaders() { return table.get(SysElementOperation.READ); }
    public ArrayList<Entity> getWriters() { return table.get(SysElementOperation.WRITE); }

    public AccessTable clone() {
        AccessTable act = new AccessTable();
        for (Entity entity : act.table.get(SysElementOperation.READ)) {
            act.table.get(SysElementOperation.READ).add(entity.clone());
        }

        for (Entity entity : act.table.get(SysElementOperation.WRITE)) {
            act.table.get(SysElementOperation.WRITE).add(entity.clone());
        }

        return act;
    }
}
