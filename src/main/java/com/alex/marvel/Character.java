package com.alex.marvel;

public class Character {
    private String id;
    private String name;
    private String description;

    public Character(String id, String name, String description) {
    }

    public void characterId (String id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription(){
        return description;
    }

    public String getName() {
        return name;
    }
}
