package com.rbac;

import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;

public class Users {

    private List<Entity> users;
    private ObjectMapper om;
    private final String filename = "RBAC/src/main/java/com/local/users.json";
    
    public Users() {
        om = new ObjectMapper();
        try {
            users = om.readValue(new java.io.File(filename), new TypeReference<List<Entity>>(){});
        } catch (Exception e) {
            users = new ArrayList<Entity>();
        }
    }

    public void save() {
        try {
            om.writeValue(new java.io.File(filename), users);
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }

    public void add(Entity e) throws DuplicateName {
        if(contains(e)) throw new DuplicateName();
        users.add(e);
    }

    public boolean contains(Entity e) {
        for(Entity entity : users) {
            if(entity.equals(e)) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return users.isEmpty();
    }

    public void remove(Entity e) throws UserNotFound {
        if(!contains(e)) throw new UserNotFound();
        for(Entity entity : users) {
            users.remove(entity);
            return;
        }
    }

    public Entity get(String name, String password) {
        for(Entity entity : users) {
            if(entity.getName().equals(name) && entity.getPassword().equals(password)) return entity;
        }
        return null;
    }
}

class DuplicateName extends Exception {
    public DuplicateName() { super(); }
}

class UserNotFound extends Exception {
    public UserNotFound() { super(); }
}
