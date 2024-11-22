package src;

import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {
        // Create a parking lot with 4 spots
        Parking parkingLot = new Parking(4);

        // Shared priority queue for all gates
        PriorityQueue<Car> sharedQueue = new PriorityQueue<>();

        // Create a single gate (thread) with the file path
        Gate gate = new Gate(parkingLot, sharedQueue, "input.txt");

        // Start the gate (thread)
        gate.start();

        // Process the shared queue
        new Thread(() -> {
            while (true) {
                synchronized (sharedQueue) {
                    while (sharedQueue.isEmpty()) {
                        try {
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    Car car = sharedQueue.poll();
                    if (car != null) {
                        if (!parkingLot.isFull()) {
                            parkingLot.parkCar(car);
                        } else {
                            System.out.println("Parking full, " + car.getName() + " from Gate " + car.getGateNumber() + " can't park yet.");
                        }
                    }
                }
            }
        }).start();
    }
}