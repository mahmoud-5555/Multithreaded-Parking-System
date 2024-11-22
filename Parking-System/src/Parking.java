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
                new Thread(() -> {
                    try {
                        Thread.sleep(car.getParkingTime() * 1000);  // Simulate parking time
                        slot.removeCar();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }).start();
                break;
            }
        }
    }
}