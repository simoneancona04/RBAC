package com.rbac;

import java.util.ArrayList;
import java.util.HashMap;

public class AccessTable {
    private HashMap<SysElementOperation, ArrayList<Entity>> table;
    
    public AccessTable() {
        table = new HashMap<SysElementOperation, ArrayList<Entity>>();
        table.put(SysElementOperation.READ, new ArrayList<Entity>());
        table.put(SysElementOperation.WRITE, new ArrayList<Entity>());
    }
    /**
     * Restituisce una valore booleano che indica se {@code entity} può leggere l'elemento
     * @param entity
     * @return {@code true} se può leggere l'elemento, altrimenti {@code false}
     */
    public boolean canRead(Entity entity) {
        return table.get(SysElementOperation.READ).contains(entity);
    }

    /**
     * Restituisce una valore booleano che indica se {@code entity} può modificare l'elemento
     * @param entity
     * @return {@code true} se può modificare l'elemento, altrimenti {@code false}
     */
    public boolean canWrite(Entity entity) {
        return table.get(SysElementOperation.WRITE).contains(entity);
    }

    /**
     * Restituisce una lista di {@code Entity} rappresentante coloro che possono leggere l'elemento
     * @return {@code ArrayList<Entity>} lista di utenti
     */
    public ArrayList<Entity> getReaders() { return table.get(SysElementOperation.READ); }
    
    /**
     * Restituisce una lista di {@code Entity} rappresentante coloro che possono modificare l'elemento
     * @return {@code ArrayList<Entity>} lista di utenti
     */
    public ArrayList<Entity> getWriters() { return table.get(SysElementOperation.WRITE); }

    /**
     * Crea una copia dell'oggetto
     * @return una nuova AccessTable uguale all'oggetto che chiama il metodo
     */
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

    /**
     * Aggiungi un nuovo utente con permessi di lettura
     * @param entity l'utente da aggiungere ai permessi
     */
    public void addReader(Entity entity) {
        table.get(SysElementOperation.READ).add(entity);
    }

    /**
     * Aggiungi un nuovo utente con permessi di scrittura
     * @param entity l'utente da aggiungere ai permessi
     */
    public void addWriter(Entity entity) {
        table.get(SysElementOperation.WRITE).add(entity);
    }
}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
