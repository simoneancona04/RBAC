public class Entity {
//chiarlo
    private String userName;
    private String password;
    //TODO private Role role;

    public Entity(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        //this.role = role;

    }

    public void createEntity(String userName, String password, String role) {
        //implementazione tipo:
        //utenti.add( new Entity(userName, password, ruolo))
        //a seconda se si utilizza direttamente json o si tiene un appoggio
    }

    public boolean open(SysElement target, Operation mode){

        
        if(target.accepts(userName,mode)){ //TODO da implementare in file e folder
            //fai cose
            return true;
        }

        return false;

    }

    // ho bisogno di un metodo equals (override) che sia deep
    // anche di un metodo clone deep
}
