public class Entity {
//chiarlo
    private String userName;
    private String password;
    //TODO private Role role;   // Operation?

    public Entity(String userName, String password) {
        this.userName = userName;
        this.password = password;
        //this.role = role;

    }

    public void createEntity(String userName, String password, String role) {
        //implementazione tipo:
        //utenti.add( new Entity(userName, password, ruolo))
        //a seconda se si utilizza direttamente json o si tiene un appoggio
    }

    // ho bisogno di un metodo equals (override) che sia deep
    @Override
    public boolean equals(Object o) {
        return userName.equals(((Entity)o).userName) && userName.equals(((Entity)o).password);
    }

    // anche di un metodo clone deep
    public Entity clone(){
        return new Entity(userName,password);
    }
}
