package src;

public class Car implements Comparable<Car> {
    private String name;
    private int arrivedAt;
    private int parkingTime;
    private int gateNumber;  // Add gate number

    // Constructor
    public Car(String name, int arrivedAt, int parkingTime, int gateNumber) {
        this.name = name;
        this.arrivedAt = arrivedAt;
        this.parkingTime = parkingTime;
        this.gateNumber = gateNumber;
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

    public int getGateNumber() {
        return gateNumber;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.arrivedAt, car.getArrivedAt());  // Priority by arrival time
    }

    public void printCar() {
        System.out.println("Car name: " + name + " arrived at: " + arrivedAt + " parking time: " + parkingTime + " from gate: " + gateNumber);
    }
}