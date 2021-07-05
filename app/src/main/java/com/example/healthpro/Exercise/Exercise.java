package com.example.healthpro.Exercise;

public class Exercise {
    int id;
    String name;
    String description;
    String calories;
    int image;

    public Exercise(int id, String name, String description, String calories, int image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
