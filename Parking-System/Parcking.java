import java.util.*;

public class Parking {
    private int numberOfSlots;
    private ParkingSlot[] slots;

    public Parking(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
        this.slots = new ParkingSlot[this.numberOfSlots];
        for (int i = 0; i < this.numberOfSlots; i++) {
            slots[i] = new ParkingSlot(i);  // Initialize parking slots
        }
    }

    public synchronized boolean isFull() {
        for (ParkingSlot slot : slots) {
            if (slot.isEmpty()) {
                return false;  // There's at least one empty spot
            }
        }
        return true;
    }

    public synchronized void parkCar(Car car) {
        for (ParkingSlot slot : slots) {
            if (slot.isEmpty()) {
                slot.parkCar(car);
                return;
            }
        }
    }

    public synchronized void removeCar(Car car) {
        for (ParkingSlot slot : slots) {
            if (slot.getCar() != null && slot.getCar().getName().equals(car.getName())) {
                slot.removeCar();
                return;
            }
        }
    }
}
