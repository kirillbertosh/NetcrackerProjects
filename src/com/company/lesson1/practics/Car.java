package com.company.lesson1.practics;

public abstract class Car {

    String description;
    int speed;

    Car() {
        this.speed = 1;
    }

    Car (int speed) {
        this.speed = speed;
    }

    public abstract String getDescription();
}
