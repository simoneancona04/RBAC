package com.rbac;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.*;

public class Entity {
    private String username;
    private String password;
    private ArrayList<EntityOperation> operations;

    @JsonCreator
    public Entity(@JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("operations") ArrayList<EntityOperation> operations) {
        this.username = username;
        this.password = password;
        this.operations = operations;

    }

    public Entity(String username, String password) {
        this.username = username;
        this.password = password;
        operations = new ArrayList<>();

    }

    public Entity(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        operations = new ArrayList<>();
        if(isAdmin) {
            operations.add(EntityOperation.IS_ADMIN);
        }
    }

    @Override
    public boolean equals(Object o) {
        return username.equals(((Entity)o).username) && username.equals(((Entity)o).password);
    }

    public Entity clone(){
        return new Entity(username,password);
    }

    public String getName(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    @JsonIgnore
    public boolean isAdmin() {
        return operations.contains(EntityOperation.IS_ADMIN);
    }

    public void setName(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
