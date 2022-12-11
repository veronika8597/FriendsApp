package com.example.friends;

public class Friends_Model {

    String name;
    String zodiac;
    String description;
    int image;

    public Friends_Model(String name, String zodiac, int image, String description) {
        this.name = name;
        this.zodiac = zodiac;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getZodiac() {
        return zodiac;
    }


    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
