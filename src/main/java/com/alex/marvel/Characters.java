package com.alex.marvel;

public class Characters {

    private String id;
    private String name;
    private String description;
    private String image;

    public Characters(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
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

    public String getImage() {
        return image;
    }
}
