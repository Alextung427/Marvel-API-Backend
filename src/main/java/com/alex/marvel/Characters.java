package com.alex.marvel;

public class Characters {

    private long id;
    private String name;
    private String description;
    private String image;

    public Characters(long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public void characterId(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription(){
        return description;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
