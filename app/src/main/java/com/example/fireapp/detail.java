package com.example.fireapp;

public class detail {
    String name;
    String coffeeType,size, date;

    float paisa;

    public detail(String name, String coffeeType, String size, float paisa, String date) {
        this.name = name;
        this.coffeeType = coffeeType;
        this.size = size;
        this.paisa = paisa;
        this.date= date;
    }

    public detail() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPaisa() {
        return paisa;
    }

    public void setPaisa(float paisa) {
        this.paisa = paisa;
    }
}

