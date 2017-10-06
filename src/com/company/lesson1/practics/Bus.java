package com.company.lesson1.practics;

public class Bus extends Car implements Drivable {

    private int placeCount;

    public Bus () {
        super();
    }

    public Bus (int speed) {
        super(speed);
        this.setDescription();
    }

    public Bus (int speed, int placeCount) {
        super(speed);
        this.placeCount = placeCount;
        this.setDescription();
    }

    public void drive() {
        System.out.println("Driving bus");
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public void stop() {
        System.out.println("Stopping bus");
    }


    @Override
    public String getDescription() {
        return this.description;
    }

    private void setDescription() {
        this.description = "This is a Bus with " + this.getPlaceCount() + " places";
    }
}
