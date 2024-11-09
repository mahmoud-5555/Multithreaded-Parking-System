package src;

public class ParkingSlot {
    private int slotNumber;
    private Car car;

    // Constructor
    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.car = null;  // Initially, no car is parked in the slot
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Car getCar() {
        return car;
    }

    public void parkCar(Car car) {
        this.car = car;
        System.out.println("src.Car " + car.getName() + " parked in slot " + slotNumber);
    }

    public void removeCar() {
        if (this.car != null) {
            System.out.println("src.Car " + this.car.getName() + " removed from slot " + slotNumber);
            this.car = null;
        }
    }

    public boolean isEmpty() {
        return car == null;
    }
}