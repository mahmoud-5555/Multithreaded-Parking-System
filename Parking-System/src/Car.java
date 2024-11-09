package src;

public class Car implements Comparable<Car> {
    private String name;
    private int arrivedAt;
    private int parkingTime;

    // Constructor
    public Car(String name, int arrivedAt, int parkingTime) {
        this.name = name;
        this.arrivedAt = arrivedAt;
        this.parkingTime = parkingTime;
    }

    public String getName() {
        return name;
    }

    public int getArrivedAt() {
        return arrivedAt;
    }

    public int getParkingTime() {
        return parkingTime;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.arrivedAt, car.getArrivedAt());  // Priority by arrival time
    }

    public void printCar() {
        System.out.println("src.Car name: " + name + " arrived at: " + arrivedAt + " parking time: " + parkingTime);
    }
}