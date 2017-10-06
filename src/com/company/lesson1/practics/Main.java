package com.company.lesson1.practics;

public class Main {

    public static void main(String[] args) {
        Bus bus = new Bus(3, 20);
        SportCar sportCar = new SportCar(10);

        bus.drive();
        sportCar.drive();
        bus.stop();
        sportCar.stop();

        System.out.println(bus.getDescription());
        System.out.println(sportCar.getDescription());
    }
}
