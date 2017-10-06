package com.company.lesson1.practics;

public class SportCar extends Car implements Drivable{

    public SportCar() {
        super();
        this.setDescription();
    }

    public SportCar (int speed) {
        super(speed);
        this.setDescription();
    }

    public void drive() {
        System.out.println("driving sport car");
    }

    public void stop() {
        System.out.println("Stopping sport car");
    }

    private void setDescription() {
        this.description = "This is a sport car with " + speed + "speeds";
    }

    @Override
    public String getDescription() {
        return description;
    }
}
